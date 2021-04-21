package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.FlipDriveTrain;
import org.firstinspires.ftc.teamcode.commands.actions.LoadShooter;
import org.firstinspires.ftc.teamcode.commands.actions.RetractIntake;
import org.firstinspires.ftc.teamcode.commands.actions.ReverseStorage;
import org.firstinspires.ftc.teamcode.commands.actions.RunStorage;
import org.firstinspires.ftc.teamcode.commands.actions.Shoot;
import org.firstinspires.ftc.teamcode.commands.actions.ToggleIntakePosition;
import org.firstinspires.ftc.teamcode.commands.looped.RunIntake;
import org.firstinspires.ftc.teamcode.commands.looped.TankDrive;
import org.firstinspires.ftc.teamcode.commands.looped.UpdateTeleop;

@TeleOp
public class DriveTankDualController extends TeleOpModeWrapper {

    @Override
    public void teleOpInit() {
        scheduler.enableDebugTelemetry();
//        scheduler.add(new ExtendIntake());

    }

    @Override
    public void teleOpLoop() {
        scheduler.add(new UpdateTeleop());
        scheduler.add(new TankDrive(DriverLeftYAxis, DriverRightYAxis, DriverLeftXAxis, DriverRightXAxis, DriverAButton));
        scheduler.add(new RunIntake(OperatorRightTrigger, OperatorLeftTrigger));

        DriverLeftBumper.whenPressed(new FlipDriveTrain());

        DriverRightBumper.whenPressed(new ToggleIntakePosition());

        OperatorRightBumper.whileHeld(new LoadShooter());
        OperatorLeftBumper.whileHeld(new ReverseStorage());
        OperatorYButton.whileHeld(new RunStorage());

        OperatorBButton.toggleWhenPressed(new Shoot());
    }
}

