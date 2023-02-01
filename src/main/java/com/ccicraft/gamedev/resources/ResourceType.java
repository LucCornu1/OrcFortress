package com.ccicraft.gamedev.resources;

public class ResourceType {
    // Constructor
    public ResourceType(String name) {
        this.name = name;
        this.gatherMethod = EGatherMethod.NONE;
    }

    public ResourceType(String name, EGatherMethod gatherMethod) {
        this.name = name;
        this.gatherMethod = gatherMethod;
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
    private int resourceCount = 0;

    // Methods
    public void addResource(int resourceCount) {
        setResourceCount(getResourceCount() + resourceCount);
    }

    // Getters & Setters
    public EGatherMethod getGatherMethod() {
        return gatherMethod;
    }

    public void setGatherMethod(EGatherMethod gatherMethod) {
        this.gatherMethod = gatherMethod;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(int resourceCount) {
        this.resourceCount = resourceCount;
    }
}
