package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.DCMotorWithEncoderHandler;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.Mechanism;

import static org.firstinspires.ftc.teamcode.framework.Constants.*;

import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

public class DriveTrain extends Mechanism {

    private BNO055IMU imu;

    private boolean flipped = false;

    private double left_distance, right_distance, starting_distance, previous_distance;
    double x_position, z_position, linear_displacement;

    private double left_speed = 0;
    private double right_speed = 0;

    private double currentHeading, lastHeading, trueHeading, headingChange;


    private static DCMotorWithEncoderHandler frontLeft = new DCMotorWithEncoderHandler("drivetrain_front_left", true, true);
    private static DCMotorWithEncoderHandler frontRight = new DCMotorWithEncoderHandler("drivetrain_front_right", false, true);
    private static DCMotorWithEncoderHandler backLeft = new DCMotorWithEncoderHandler("drivetrain_back_left", true, true);
    private static DCMotorWithEncoderHandler backRight = new DCMotorWithEncoderHandler("drivetrain_back_right", false, true);

    public void init(HardwareMap hwmap) {
        frontLeft.init(hwmap);
        frontRight.init(hwmap);
        backLeft.init(hwmap);
        backRight.init(hwmap);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = false;
        parameters.mode = BNO055IMU.SensorMode.IMU;

        imu = hwmap.get(BNO055IMU.class, "imu");

        imu.initialize(parameters);
    }

    public void flip() {
        flipped = !flipped;
    }

    public boolean isFlipped() {
        return flipped;
    }

    //I'm just gonna assume we know how to feed the motors proper values at this point, I'm not clipping their speeds anymore
    public void setRawSpeeds(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed) {
        frontLeft.setPower(frontLeftSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
        frontRight.setPower(frontRightSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
        backLeft.setPower(backLeftSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
        backRight.setPower(backRightSpeed * DRIVETRAIN_MOTOR_POWER_LIMIT);
    }

    public void vectorDrive(double forwardSpeed, double strafeSpeed, double rotateSpeed) {
        setRawSpeeds(forwardSpeed + strafeSpeed + rotateSpeed,
                     forwardSpeed - strafeSpeed - rotateSpeed,
                     forwardSpeed - strafeSpeed + rotateSpeed,
                     forwardSpeed + strafeSpeed - rotateSpeed
        );
    }

    public void setSpeeds(double fL, double fR, double bL, double bR) {
        double largest = 1.0;

        largest = Math.max(largest, Math.abs(fL));
        largest = Math.max(largest, Math.abs(fR));
        largest = Math.max(largest, Math.abs(bL));
        largest = Math.max(largest, Math.abs(bR));

        frontLeft.setPower(fL / largest);
        frontRight.setPower(fR / largest);
        backLeft.setPower(bL / largest);
        backRight.setPower(bR / largest);
    }

    public void vectorDriveField(double fSpeed, double sSpeed, double rSpeed) {
        left_speed = fSpeed;
        right_speed = fSpeed;
        setSpeeds((fSpeed + FRONT_WHEEL_MODIFIER * sSpeed + rSpeed), (fSpeed - FRONT_WHEEL_MODIFIER * sSpeed - rSpeed), (fSpeed - sSpeed + rSpeed), (fSpeed + sSpeed - rSpeed));
    }

    public double getSpeed() {
        return (left_speed + right_speed) / 2;
    }

    public double getHeading() {
        return -imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle + IMU_OFFSET;
    }

    public void setTrueHeading(double heading){
        this.trueHeading = heading;
    }

    public void adjustTrueHeading() { // To be called periodically in the OpMode
        currentHeading = getHeading();
        headingChange = currentHeading - lastHeading;
        trueHeading += headingChange;
        if (headingChange > 180) {
            trueHeading -= 360;
        } else if (headingChange < -180) {
            trueHeading += 360;
        }
        lastHeading = currentHeading;
    }

    public void setLastHeading() {
        lastHeading = getHeading();
    }

    public double getTrueHeading() {
        return trueHeading;
    }

    public double getDistance() {
        left_distance = (frontLeft.getEncoderValue() + backLeft.getEncoderValue()) / 2;
        right_distance = -(frontRight.getEncoderValue() + backRight.getEncoderValue()) / 2;
        return ((left_distance + right_distance) / 2) * DRIVETRAIN_WHEEL_DIAMETER * Math.PI / Y_JACKET_TICKS_PER_REVOLUTION;
    }


    public void incrementXZ() {
        if (getTrueHeading() - lastHeading == 0) {
            linear_displacement = getDistance() - previous_distance;
        } else {
            linear_displacement = 2 * (getDistance() - previous_distance) * Math.abs(Math.sin((getTrueHeading() - lastHeading) * Math.PI / 360) / ((getTrueHeading() - lastHeading) * Math.PI / 180));
        }

        x_position += Math.sin((getTrueHeading() + lastHeading) * Math.PI / 360) * linear_displacement;
        z_position += Math.cos((getTrueHeading() + lastHeading) * Math.PI / 360) * linear_displacement;

        previous_distance = getDistance();
        lastHeading = getTrueHeading();
    }


    public void setXZ(double x_input, double z_input) {
        x_position = x_input;
        z_position = z_input;
    }

    public double getX() {
        return x_position;
    }

    public double getZ() {
        return z_position;
    }
}

