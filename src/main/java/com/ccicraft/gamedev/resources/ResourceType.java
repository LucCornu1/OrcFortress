package com.ccicraft.gamedev.resources;

import com.ccicraft.gamedev.buildings.Building;

public class ResourceType {
    // Constructor
    public ResourceType(String name) {
        this.name = name;
        this.gatherMethod = EGatherMethod.NONE;
    }

    public ResourceType(String name, EGatherMethod gatherMethod, float gatheringSpeed) {
        this.name = name;
        this.gatherMethod = gatherMethod;
        this.gatheringSpeed = gatheringSpeed;
    }

    // Variables
    public String name = "";
    public enum EGatherMethod {
        NONE,
        MINING,
        GATHERING,
        CHOPPING,
        HUNTING
    }

    private EGatherMethod gatherMethod;
    private float resourceCount = 0;
    private float gatheringSpeed = 0.2f;

    // Methods
    public void addResource(float resourceCount) {
        setResourceCount(getResourceCount() + resourceCount);
    }

    // Getters & Setters
    public EGatherMethod getGatherMethod() {
        return gatherMethod;
    }

    public void setGatherMethod(EGatherMethod gatherMethod) {
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
