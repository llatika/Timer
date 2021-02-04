package com.Timer;

public class Timer {

    public double startValue, stopValue, duration;

    public void startTimer() {
        startValue = System.nanoTime();
    }

    public void stopTimer() {
        stopValue = System.nanoTime();
    }

    public double sumDuration() {
        duration = ((stopValue - startValue)/1000000000.0);
        return duration;
    }
}
