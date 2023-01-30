package com.ccicraft.gamedev.game;

public interface DeltaTime {
    // Variables
    long previousTime = 0;

    // Methods
    float computeDeltaTime();
    void update();
}
