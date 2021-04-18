package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;

public class TimedSleep extends Command {
    private Timekeeper timekeeper;
    private double startTime, sleepTime;

    public TimedSleep(Timekeeper timekeeper, double sleepTime) {
        this.timekeeper = timekeeper;
        this.sleepTime = sleepTime;
    }

    public void initialize() {
        startTime = timekeeper.getRuntime();
    }

    public void execute() {}

    public boolean isFinished() {
        return timekeeper.getRuntime() - startTime >= sleepTime;
    }

    public void end() { }
}
