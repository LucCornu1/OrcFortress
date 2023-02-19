package com.ccicraft.gamedev.resources;

import com.ccicraft.gamedev.buildings.Building;
import com.ccicraft.gamedev.game.GameManager;

public class ResourceType {
    // Constructor
    public ResourceType(String name) {
        this.name = name;
        this.gatherMethod = GameManager.EGatherMethod.NONE;
    }

    public ResourceType(String name, GameManager.EGatherMethod gatherMethod, float gatheringSpeed) {
        this.name = name;
        this.gatherMethod = gatherMethod;
        this.gatheringSpeed = gatheringSpeed;
    }

    // Variables
    public String name = "";

    private GameManager.EGatherMethod gatherMethod;
    private float resourceCount = 0;
    private float gatheringSpeed = 0.2f;

    // Methods
    public void addResource(float resourceCount) {
        setResourceCount(getResourceCount() + resourceCount);
    }

    // Getters & Setters
    public GameManager.EGatherMethod getGatherMethod() {
        return gatherMethod;
    }

    public void setGatherMethod(GameManager.EGatherMethod gatherMethod) {
        this.gatherMethod = gatherMethod;
    }

    public float getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(float resourceCount) {
        this.resourceCount = resourceCount;
    }

    public float getGatheringSpeed() {
        return gatheringSpeed;
    }

    public void setGatheringSpeed(float gatheringSpeed) {
        this.gatheringSpeed = gatheringSpeed;
    }
}
