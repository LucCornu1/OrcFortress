package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.SpriteManager;
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
    protected ResourceType resourceTypeGathered;
    protected Image tileSprite = null;
    private static final Image hiddenSprite = SpriteManager.cropSprite(19, 9);

    // Methods

    // Getters & Setters
    public static Image getHiddenSprite() {
        return hiddenSprite;
    }
}
