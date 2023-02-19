package com.ccicraft.gamedev.buildings;

import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.gamedev.tiles.TileType;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class BuildingFactory {
    // Constructor

    // Variables
    private static Map<String, BuildingType> buildingTypes = new HashMap<>();

    // Factory
    public static BuildingType getBuildingType(String name) {
        BuildingType type = buildingTypes.get(name);
        if (type == null) {
            type = new BuildingType(name);
            buildingTypes.put(name, type);
        }
        return type;
    }

    public static BuildingType getBuildingType(String name, Image tileSprite, float bonus,
                                               Map<ResourceType, Float> dwarfBuildCost,
                                               Map<ResourceType, Float> orcBuildCost) {
        BuildingType type = buildingTypes.get(name);
        if (type == null) {
            type = new BuildingType(name, tileSprite, bonus, dwarfBuildCost, orcBuildCost);
            buildingTypes.put(name, type);
        }
        return type;
    }

}
