package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.SetOdometry;

import org.firstinspires.ftc.teamcode.commands.basecommands.CommandGroup;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;

public class AutoSevenRingWobble extends CommandGroup {
    public AutoSevenRingWobble(Timekeeper timekeeper) {

        addSequential(new SetOdometry(50, -63, 0));

        addParallel(new ExtendIntake());
        addSequential(new DriveToPoint(timekeeper, 60, -20, 0, 0.6)); //(0,0) is located in direct center of field for drive to point coordinate purposes
        addSequential(new DriveToPoint(timekeeper, 60, 40, 0, 0.4));
        addSequential(new DriveToPoint(timekeeper, 60, 57, 40, 0));
        addSequential(new DriveToPoint(timekeeper, 40, 30, 0, -0.8));

        addParallel(new TimedReverseStorage(timekeeper, 1, 0.5));
        addSequential(new DriveToPoint(timekeeper, 40, -5, 0));
        addParallel(new TimedLoadShooter(timekeeper, 2, 2));
        addSequential(new TimedShoot(timekeeper, 5));

        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new DriveToPoint(timekeeper, 35, -25, 0)); //Drive through rings and a little past

        addParallel(new TimedReverseStorage(timekeeper, 1, 0.5));
        addSequential(new DriveToPoint(timekeeper, 40, -5, 0));
        addParallel(new TimedLoadShooter(timekeeper, 2, 2));
        addSequential(new TimedShoot(timekeeper, 5));

        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new DriveToPoint(timekeeper, 35, -25, 0)); //Drive through rings and a little past

        addParallel(new TimedReverseStorage(timekeeper, 1, 0.5));
        addSequential(new DriveToPoint(timekeeper, 40, -5, 0));
        addParallel(new TimedLoadShooter(timekeeper, 2, 2));
        addSequential(new TimedShoot(timekeeper, 5));

        addSequential(new DriveToPoint(timekeeper, 40, 10, 0)); //Park on Nav Line
    }
}
