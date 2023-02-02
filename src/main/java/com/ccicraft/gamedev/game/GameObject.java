package com.ccicraft.gamedev.game;

public class GameObject {
    // Variable
    protected double currentDelta = 0.f; // Could have been in a singleton in order to have access everywhere

    // Methods
    public void update(float delta) {
        currentDelta = delta;
    }
}
