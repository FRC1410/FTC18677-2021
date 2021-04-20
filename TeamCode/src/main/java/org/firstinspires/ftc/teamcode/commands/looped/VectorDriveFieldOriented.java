package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import static org.firstinspires.ftc.teamcode.framework.Constants.*;

import org.firstinspires.ftc.teamcode.framework.PIDHandler;
import org.firstinspires.ftc.teamcode.framework.controllers.Axis;
import org.firstinspires.ftc.teamcode.framework.controllers.Button;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import java.lang.Math;

public class VectorDriveFieldOriented extends Command {

    private DriveTrain driveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);
    private PIDHandler pid = new PIDHandler(ANGLE_P, ANGLE_I, ANGLE_D);

    private Axis leftX, leftY, rightX;
    private Button dpadDown;

    private double currentAngle, angular_speed;

    public VectorDriveFieldOriented(Axis leftAxisX, Axis leftAxisY, Axis rightAxisX, Button dpadDown) {
        this.leftX = leftAxisX;
        this.leftY = leftAxisY;
        this.rightX = rightAxisX;
        this.dpadDown = dpadDown;
    }

    public void initialize() {}

    public void execute() {
        currentAngle = driveTrain.getTrueHeading() * Math.PI / 180;

        if (dpadDown.get()) {
            angular_speed = pid.getPID((((((driveTrain.getTrueHeading() - SHOOT_ANGLE) + 180) % 360) + 360) % 360) - 180, 0, 0);
        } else {
            angular_speed = rightX.get()/2 + Math.pow(rightX.get(), 3)/2;
        }

        driveTrain.vectorDriveField(leftX.get()*Math.cos(currentAngle) - leftY.get()*Math.sin(currentAngle), -leftY.get()*Math.cos(currentAngle) - leftX.get()*Math.sin(currentAngle), angular_speed);
    }

    public boolean isFinished() { return false; }

    public void end() {}
}