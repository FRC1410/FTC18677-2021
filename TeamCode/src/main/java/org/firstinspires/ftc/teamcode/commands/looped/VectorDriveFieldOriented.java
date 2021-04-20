package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.controllers.Axis;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import java.lang.Math;

public class VectorDriveFieldOriented extends Command {

    private DriveTrain driveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);

    private Axis leftX, leftY, rightX;

    private double currentAngle, angular_speed;

    public VectorDriveFieldOriented(Axis leftAxisX, Axis leftAxisY, Axis rightAxisX) {
        this.leftX = leftAxisX;
        this.leftY = leftAxisY;
        this.rightX = rightAxisX;
    }

    public void initialize() {}

    public void execute() {
        currentAngle = driveTrain.getTrueHeading() * Math.PI / 180;

        angular_speed = rightX.get()/2 + Math.pow(rightX.get(), 3)/2;

        driveTrain.vectorDriveField(leftX.get()*Math.cos(currentAngle) - leftY.get()*Math.sin(currentAngle), -leftY.get()*Math.cos(currentAngle) - leftX.get()*Math.sin(currentAngle), angular_speed);
    }

    public boolean isFinished() { return false; }

    public void end() {}
}