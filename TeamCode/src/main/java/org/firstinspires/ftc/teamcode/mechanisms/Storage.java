package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.framework.util.TelemetryHandler;
import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.DCMotorHandler;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.Mechanism;

public class Storage extends Mechanism {

    private DCMotorHandler storageMotor = new DCMotorHandler("storage_motor", true, true);

    public void init(HardwareMap hwmap) {
        storageMotor.init(hwmap);
    }

    public void runStorage(double power) {
        storageMotor.setPower(power);
    }
}
