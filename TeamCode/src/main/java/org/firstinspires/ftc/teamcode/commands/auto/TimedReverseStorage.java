package org.firstinspires.ftc.teamcode.commands.auto;

import org.firstinspires.ftc.teamcode.commands.basecommands.Command;
import org.firstinspires.ftc.teamcode.framework.util.Timekeeper;
import org.firstinspires.ftc.teamcode.mechanisms.Storage;
import org.firstinspires.ftc.teamcode.mechanisms.mechanismhandlers.MechanismEngine;

import static org.firstinspires.ftc.teamcode.framework.Constants.*;

public class TimedReverseStorage extends Command {
    private Storage localStorage = MechanismEngine.getInstance().getMechanism(Storage.class);

    private Timekeeper timekeeper;
    private double delay;
    private double timeToLoad;

    private double startTime;

    public TimedReverseStorage(Timekeeper timekeeper, double delay, double timeToLoad) {
        Requires(localStorage);

        this.timekeeper = timekeeper;
        this.delay = delay;
        this.timeToLoad = timeToLoad;
    }

    public void initialize() {
        startTime = timekeeper.getRuntime();
    }

    public void execute() {
        if (timekeeper.getRuntime() >= startTime + delay) {
            localStorage.runStorage(STORAGE_REVERSE_SPEED);
        }
    }

    public boolean isFinished() {
        return timekeeper.getRuntime() > startTime + timeToLoad + delay;
    }

    public void end() {
        localStorage.runStorage(0);
    }
}
