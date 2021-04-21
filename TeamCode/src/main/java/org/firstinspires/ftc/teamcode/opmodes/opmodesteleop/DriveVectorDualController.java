package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.actions.ExtendIntake;
import org.firstinspires.ftc.teamcode.commands.actions.FlipDriveTrain;
import org.firstinspires.ftc.teamcode.commands.actions.LoadShooter;
import org.firstinspires.ftc.teamcode.commands.actions.ReverseStorage;
import org.firstinspires.ftc.teamcode.commands.actions.RunStorage;
import org.firstinspires.ftc.teamcode.commands.actions.Shoot;
import org.firstinspires.ftc.teamcode.commands.actions.ToggleIntakePosition;
import org.firstinspires.ftc.teamcode.commands.looped.RunIntake;
import org.firstinspires.ftc.teamcode.commands.looped.UpdateTeleop;
import org.firstinspires.ftc.teamcode.commands.looped.VectorDrive;

@TeleOp
public class DriveVectorDualController extends TeleOpModeWrapper {

    @Override
    public void teleOpInit() {
        scheduler.enableDebugTelemetry();
//        scheduler.add(new ExtendIntake());

    }

    @Override
    public void teleOpLoop() {
        scheduler.add(new UpdateTeleop());
        scheduler.add(new VectorDrive(DriverLeftYAxis, DriverLeftXAxis, DriverRightXAxis, DriverDPadUp));
        scheduler.add(new RunIntake(OperatorRightTrigger, OperatorLeftTrigger));

        DriverLeftBumper.whenPressed(new FlipDriveTrain());

        DriverRightBumper.whenPressed(new ToggleIntakePosition());

        OperatorRightBumper.whileHeld(new LoadShooter());
        OperatorXButton.whileHeld(new ReverseStorage());
        OperatorAButton.whileHeld(new RunStorage());

        OperatorBButton.toggleWhenPressed(new Shoot());
    }
}