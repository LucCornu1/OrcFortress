package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.game.SpriteManager;
import com.ccicraft.gamedev.resources.ResourceType;
import javafx.scene.image.Image;

public class TileType {
    // Constructor
    public TileType(String name, Image tileSprite, ResourceType resourceFactoryGathered) {
        this.name = name;
        this.tileSprite = tileSprite;
        this.resourceGathered = resourceFactoryGathered;
    }

    // Variables
    public String name;

    protected ResourceType resourceGathered;
    protected Image tileSprite = null;
    private static final Image hiddenSprite = SpriteManager.cropSprite(19, 9);

    // Methods

    // Getters & Setters
    public static Image getHiddenSprite() {
        return hiddenSprite;
    }

    public ResourceType getResourceGathered() {
        return resourceGathered;
    }

    public void setResourceGathered(ResourceType resourceGathered) {
        this.resourceGathered = resourceGathered;
    }
}
