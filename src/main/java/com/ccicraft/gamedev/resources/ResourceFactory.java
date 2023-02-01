package com.ccicraft.gamedev.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceFactory {
    // Variables
    private static Map<String, ResourceType> resourceTypes = new HashMap<>();

    // Factory
    public static ResourceType getResourceType(String name, ResourceType.EGatherMethod gatherMethod) {
        ResourceType type = resourceTypes.get(name);
        if (type == null) {
            type = new ResourceType(name, gatherMethod);
            resourceTypes.put(name, type);
        }
        return type;
    }

    public static ResourceType getResourceType(String name) {
        ResourceType type = resourceTypes.get(name);
        if (type == null) {
            type = new ResourceType(name);
            resourceTypes.put(name, type);
        }
        return type;
    }
}
