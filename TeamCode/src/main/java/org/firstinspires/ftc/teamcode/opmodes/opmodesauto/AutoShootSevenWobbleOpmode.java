package org.firstinspires.ftc.teamcode.opmodes.opmodesauto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.auto.AutoSevenRingWobble;
import org.firstinspires.ftc.teamcode.commands.looped.UpdateDriveTrain;

@Autonomous
public class AutoShootSevenWobbleOpmode extends AutoOpModeWrapper {

    @Override
    public void autoInit() {
        scheduler.enableDebugTelemetry();
        scheduler.add(new UpdateDriveTrain());
    }

    @Override
    public void autoLoop() {
        scheduler.add(new AutoSevenRingWobble(timekeeper));
        scheduler.add(new UpdateDriveTrain());
    }
}
