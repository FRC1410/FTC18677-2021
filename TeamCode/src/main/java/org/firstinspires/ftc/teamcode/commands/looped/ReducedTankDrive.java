package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.controllers.Axis;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class ReducedTankDrive extends Command {
    private DriveTrain localDriveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);
    private Axis leftYAxis;
    private Axis rightYAxis;
    private Axis leftXAxis;
    private Axis rightXAxis;

    public ReducedTankDrive(Axis leftYAxis, Axis rightYAxis, Axis leftXAxis, Axis rightXAxis) {
        Requires(localDriveTrain);

        this.leftYAxis = leftYAxis;
        this.rightYAxis = rightYAxis;
        this.leftXAxis = leftXAxis;
        this.rightXAxis = rightXAxis;
    }

    public void initialize() {

    }

    public void execute() {
        if (!localDriveTrain.isFlipped()) {
            localDriveTrain.vectorDrive((leftYAxis.get() + rightYAxis.get())/4, (leftXAxis.get() + rightXAxis.get())/4, (leftYAxis.get() - rightYAxis.get())/4);
        } else {
            localDriveTrain.vectorDrive(-(leftYAxis.get() + rightYAxis.get())/4, -(leftXAxis.get() + rightXAxis.get())/4, (leftYAxis.get() - rightYAxis.get())/4);
        }
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }
}
