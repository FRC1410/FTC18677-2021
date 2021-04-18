package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.SetOdometry;

import org.firstinspires.ftc.teamcode.commands.basecommands.CommandGroup;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;

public class AutoSevenRingWobble extends CommandGroup {
    public AutoSevenRingWobble(Timekeeper timekeeper) {

        addSequential(new SetOdometry(50, -63, 0));

        addParallel(new ExtendIntake());
        addSequential(new DriveToPoint(timekeeper, 0, 0, 0, 0));
        //Add drive to point to get to wobble drop zone (Zone C, farthest back from robot) and then in position to shoot 3 rings

        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new TimedShoot(timekeeper, 5));

        //Add drive to point that faces robot in ideal ring pickup position
        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new DriveToPoint(timekeeper,0, 0,0)); //Drive through rings and a little past

        //Add drive to point to get back to nav line

        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new TimedShoot(timekeeper, 5));

        //Add drive to point that gets us back to last ring
        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new DriveToPoint(timekeeper,0, 0,0)); //Drive through rings and a little past

        //Add drive to point to get back to nav line

        addParallel(new TimedLoadShooter(timekeeper, 2, 3));
        addSequential(new TimedShoot(timekeeper, 5));

        //Add drive to point to get on to nav line
    }
}
