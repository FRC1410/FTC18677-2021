package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class UpdateDriveTrain extends Command {

    private DriveTrain localDriveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);

    public void initialize() {}

    public void execute() {
        localDriveTrain.adjustTrueHeading();
        localDriveTrain.incrementXZ();
    }

    public boolean isFinished() { return false; }

    public void end() {}
}