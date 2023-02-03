package com.ccicraft.gamedev.buildings;

import com.ccicraft.gamedev.game.GameManager;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class BuildingFactory {
    // Variables
    private static Map<String, BuildingType> buildingTypes = new HashMap<>();

    // Factory
    public static BuildingType getResourceType(String name, GameManager.EGatherMethod gatherMethod, Image image) {
        BuildingType type = buildingTypes.get(name);
        if (type == null) {
            type = new BuildingType(name, gatherMethod, image);
            buildingTypes.put(name, type);
        }
        return type;
    }

    public static BuildingType getResourceType(String name) {
        BuildingType type = buildingTypes.get(name);
        if (type == null) {
            type = new BuildingType(name);
            buildingTypes.put(name, type);
        }
        return type;
    }
}