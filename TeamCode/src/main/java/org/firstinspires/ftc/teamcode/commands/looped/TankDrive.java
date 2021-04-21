package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.util.PIDHandler;
import org.firstinspires.ftc.teamcode.framework.controllers.Axis;
import org.firstinspires.ftc.teamcode.framework.controllers.Button;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import static org.firstinspires.ftc.teamcode.framework.Constants.ANGLE_D;
import static org.firstinspires.ftc.teamcode.framework.Constants.ANGLE_I;
import static org.firstinspires.ftc.teamcode.framework.Constants.ANGLE_P;
import static org.firstinspires.ftc.teamcode.framework.Constants.SHOOT_ANGLE;

public class TankDrive extends Command {
    private DriveTrain localDriveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);
    private PIDHandler pid = new PIDHandler(ANGLE_P, ANGLE_I, ANGLE_D);

    private Axis leftXAxis, leftYAxis, rightXAxis, rightYAxis;
    private Button dpadDown;

    private double angular_speed;


    public TankDrive(Axis leftYAxis, Axis rightYAxis, Axis leftXAxis, Axis rightXAxis, Button dpadDown) {
        Requires(localDriveTrain);

        this.leftYAxis = leftYAxis;
        this.rightYAxis = rightYAxis;
        this.leftXAxis = leftXAxis;
        this.rightXAxis = rightXAxis;
        this.dpadDown = dpadDown;
    }

    public void initialize() {}

    public void execute() {
        if (dpadDown.get()) {
            angular_speed = pid.getPID((((((localDriveTrain.getTrueHeading() - SHOOT_ANGLE) + 180) % 360) + 360) % 360) - 180, 0, 0);
        } else {
            angular_speed = (leftYAxis.get() - rightYAxis.get())/2;
        }

        if (!localDriveTrain.isFlipped()) {
            localDriveTrain.vectorDrive((leftYAxis.get() + rightYAxis.get())/2, (leftXAxis.get() + rightXAxis.get())/2, angular_speed);
        } else {
            localDriveTrain.vectorDrive(-(leftYAxis.get() + rightYAxis.get())/2, -(leftXAxis.get() + rightXAxis.get())/2, angular_speed);
        }
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }
}
