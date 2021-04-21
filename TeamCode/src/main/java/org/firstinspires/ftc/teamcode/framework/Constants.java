package org.firstinspires.ftc.teamcode.framework;

public class Constants {

    //Intake
    public static final double LEFT_SERVO_EXTENDED_POSITION = 0;
    public static final double RIGHT_SERVO_EXTENDED_POSITION = 1;
    public static final double LEFT_SERVO_RETRACTED_POSITION = 1;
    public static final double RIGHT_SERVO_RETRACTED_POSITION = 0;

    //DriveTrain
    public static final double DRIVETRAIN_MOTOR_POWER_LIMIT = 1;
    public static final double FRONT_WHEEL_MODIFIER = 0.8;

    //Shooter
    public static final double MAX_SHOOTER_POWER = 1;
    public static final double SHOOT_ANGLE = 14;

    //Storage
    public static final double STORAGE_FEED_SPEED = 0.85;
    public static final double STORAGE_REVERSE_SPEED = -0.9;

    //For the getDistance method:
    public static final double DRIVETRAIN_WHEEL_DIAMETER = 96/25.4; //in
    public static final double Y_JACKET_TICKS_PER_REVOLUTION = (1+(46/17))*(1+(46/11))*28*-0.98;

    //Angle PID Values:
    public static final double ANGLE_P = 0.04;
    public static final double ANGLE_I = 0;
    public static final double ANGLE_D = 0;

    //IsFinished thresholds:
    public static final double ANGLE_FINISHED_THRESHOLD = 1;
    public static final double DISTANCE_FINISHED_THRESHOLD = 1;

    //Distance PID Values:
    public static final double DISTANCE_P = 0.1;
    public static final double DISTANCE_I = 0;
    public static final double DISTANCE_D = 0;

    //Offset PID Values:
    public static final double X_OFFSET_P = 0.04;
    public static final double X_OFFSET_I = 0;
    public static final double X_OFFSET_D = 0;
}
