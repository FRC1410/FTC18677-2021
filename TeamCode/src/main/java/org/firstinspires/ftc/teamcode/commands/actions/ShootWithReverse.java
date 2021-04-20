package org.firstinspires.ftc.teamcode.commands.actions;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.util.TelemetryHandler;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.mechanisms.Storage;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import static org.firstinspires.ftc.teamcode.framework.Constants.*;

public class ShootWithReverse extends Command {

    private Shooter localShooter = MechanismEngine.getInstance().getMechanism(Shooter.class);
    private Storage localStorage = MechanismEngine.getInstance().getMechanism(Storage.class);

    public ShootWithReverse() {
        Requires(localShooter);
    }

    public void initialize() {
        localStorage.runStorage(-0.8);
    }

    public void execute() {
        localShooter.setPower(MAX_SHOOTER_POWER);
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {
        localShooter.setPower(0);
    }
}
