package com.ccicraft.gamedev;

import javafx.animation.AnimationTimer;

public interface DeltaTime {
    // Variables
    AnimationTimer timer = null;
    long previousTime = 0;

    // Methods
    float computeDeltaTime();
    void update();
    void startTimer();
    void stopTimer();
}
