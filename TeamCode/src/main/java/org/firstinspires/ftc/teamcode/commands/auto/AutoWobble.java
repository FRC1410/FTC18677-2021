package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.basecommands.CommandGroup;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;

public class AutoWobble extends CommandGroup {

    public AutoWobble(Timekeeper timekeeper) {
        addParallel(new ExtendIntake());
        addSequential(new TimedDrive(timekeeper, 3, 0.17));

        addSequential(new TimedDrive(timekeeper, 1.3, 0.5));

        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new TimedShoot(timekeeper, 5));

        addSequential(new TimedDrive(timekeeper, 1.1, 0.5));
        addSequential(new TimedDrive(timekeeper, 0.7, -0.5));
    }
}