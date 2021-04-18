package org.firstinspires.ftc.teamcode.commands.looped;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.controllers.Axis;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

public class RunIntake extends Command {

    private Intake localIntake = MechanismEngine.getInstance().getMechanism(Intake.class);
    private Axis inputAxis;
    private Axis inputAxisTwo;

    public RunIntake(Axis inputAxis, Axis inputAxisTwo) {
        Requires(localIntake);

        this.inputAxis = inputAxis;
        this.inputAxisTwo = inputAxisTwo;
    }

    public void initialize() {}

    public void execute() {
        localIntake.runIntake(inputAxis.get() - inputAxisTwo.get());
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {}
}
//Left trigger for reverse intake
//Run storage Y