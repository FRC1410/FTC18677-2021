package org.firstinspires.ftc.teamcode.commands.actions;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class SetOdometry extends Command {

    private DriveTrain driveTrain = MechanismEngine.getInstance().getMechanism(DriveTrain.class);

    private double x, z, a;

    public SetOdometry(double xInput, double zInput, double aInput) {
        this.x = xInput;
        this.z = zInput;
        this.a = aInput;
    }

    public void initialize() {}

    public void execute() {
        driveTrain.setXZ(x, z);
        driveTrain.setTrueHeading(a);
    }

    public boolean isFinished() {
        return true;
    }

    public void end() {}
}