package com.ccicraft.gamedev.tiles;

import javafx.scene.image.Image;
import com.ccicraft.gamedev.resources.ResourceType;

public class TileType {
    // Constructor
    public TileType(String name, Image tileSprite, ResourceType resourceTypeGathered) {
        this.name = name;
        this.tileSprite = tileSprite;
        this.resourceTypeGathered = resourceTypeGathered;
    }

    // Variables
    public String name;
    protected Image tileSprite = null;
    protected ResourceType resourceTypeGathered;

    // Methods

    // Getters & Setters
}
