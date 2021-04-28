package org.firstinspires.ftc.teamcode.opmodes.opmodesteleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.camera.RingDetector;

@TeleOp
public class TestCamera extends OpMode {

  public RingDetector rd=new RingDetector();

  @Override
  public void init() {
    rd.init(hardwareMap);
    rd.initTelemetry(telemetry);
    rd.calibrate();
  }

  public void loop() {

  }
}
