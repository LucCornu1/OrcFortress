package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.resources.ResourceType;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class TileFactory {
    // Constructor

    // Variables
    private static Map<String, TileType> tileTypes = new HashMap<>();

    // Factory
    public static TileType getTileType(String name, Image image, ResourceType resourceType) {
        TileType type = tileTypes.get(name);
        if (type == null) {
            type = new TileType(name, image, resourceType);
            tileTypes.put(name, type);
        }
        return type;
    }

}