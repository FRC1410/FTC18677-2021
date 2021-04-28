package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.devicehandlers.DCMotorWithEncoderHandler;

@TeleOp
public class TestEncoderCable extends OpMode {

    DCMotorWithEncoderHandler testingMotor = new DCMotorWithEncoderHandler("Testing Motor", false, false);

    @Override
    public void init() {
        testingMotor.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Encoder Value", testingMotor.getEncoderValue());
    }
}
