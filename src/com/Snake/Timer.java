package com.Snake;

public class Timer {

    public double startValue, stopValue, duration;

    public void startTimer() {
        startValue = System.nanoTime();
    }

    public void stopTimer() {
        stopValue = System.nanoTime();
    }

    public double sumDuration() {
        duration = ((stopValue - startValue)/3600000000000.0);
        return duration;
    }
}
