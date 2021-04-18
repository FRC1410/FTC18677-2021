package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.controllers.Axis;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class ReducedVectorDrive extends Command {

    private DriveTrain localDriveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);
    private Axis forwardAxis;
    private Axis strafeAxis;
    private Axis rotateAxis;

    public ReducedVectorDrive(Axis forwardAxis, Axis strafeAxis, Axis rotateAxis) {
        Requires(localDriveTrain);

        this.forwardAxis = forwardAxis;
        this.strafeAxis = strafeAxis;
        this.rotateAxis = rotateAxis;
    }

    public void initialize() {

    }

    public void execute() {
        if (!localDriveTrain.isFlipped()) {
            localDriveTrain.vectorDrive(forwardAxis.get()/2, strafeAxis.get()/2, rotateAxis.get()/2);
        } else {
            localDriveTrain.vectorDrive(-forwardAxis.get()/2, -strafeAxis.get()/2, rotateAxis.get()/2);
        }
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }
}
