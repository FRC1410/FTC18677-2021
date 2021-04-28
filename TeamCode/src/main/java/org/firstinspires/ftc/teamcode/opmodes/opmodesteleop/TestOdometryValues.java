package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

@TeleOp
public class TestOdometryValues extends OpMode {

    DriveTrain driveTrain = new DriveTrain();
    @Override
    public void init() {
//        MechanismEngine.getInstance().setHardwareMap(hardwareMap);
//        driveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);

        driveTrain.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Odometry X Position", driveTrain.getX());
        telemetry.addData("Odometry Z Position", driveTrain.getZ());

        telemetry.addData("Current Heading", driveTrain.getHeading());

        driveTrain.postEncoderValues(telemetry);

        driveTrain.adjustTrueHeading();
        driveTrain.incrementXZ();
    }
}