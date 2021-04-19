package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.FlipDriveTrain;
import org.firstinspires.ftc.teamcode.commands.actions.LoadShooter;
import org.firstinspires.ftc.teamcode.commands.actions.ReverseStorage;
import org.firstinspires.ftc.teamcode.commands.actions.Shoot;
import org.firstinspires.ftc.teamcode.commands.actions.ToggleIntakePosition;
import org.firstinspires.ftc.teamcode.commands.looped.ReducedVectorDrive;
import org.firstinspires.ftc.teamcode.commands.looped.RunIntake;
import org.firstinspires.ftc.teamcode.commands.looped.VectorDrive;

@TeleOp
public class ReducedVectorAll extends TeleOpModeWrapper {

    @Override
    public void teleOpInit() {
        scheduler.enableDebugTelemetry();
        scheduler.add(new ExtendIntake());

    }

    @Override
    public void teleOpLoop() {
        scheduler.add(new RunIntake(DriverRightTrigger, DriverLeftTrigger));
        scheduler.add(new ReducedVectorDrive(DriverLeftYAxis, DriverLeftXAxis, DriverRightXAxis));

        DriverLeftBumper.whenPressed(new FlipDriveTrain());

        DriverAButton.whenPressed(new ToggleIntakePosition());

        DriverRightBumper.whileHeld(new LoadShooter());
        DriverXButton.whileHeld(new ReverseStorage());

        DriverBButton.toggleWhenPressed(new Shoot());
    }
}