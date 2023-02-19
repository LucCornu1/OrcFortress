package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.buildings.Building;
import com.ccicraft.gamedev.game.SpriteManager;
import com.ccicraft.gamedev.resources.ResourceType;
import javafx.scene.image.Image;

public class TileType {
    // Constructor
    public TileType(String name) {
        this.name = name;
    }

    public TileType(String name, Image tileSprite) {
        this.name = name;
        this.tileSprite = tileSprite;
    }

    public TileType(String name, Image tileSprite, ResourceType resourceGathered, Building building) {
        this.name = name;
        this.tileSprite = tileSprite;
        this.resourceGathered = resourceGathered;
        this.building = building;
    }

    // Variables
    public String name;
    protected float maxResourceCount = 10000.f;
    protected ResourceType resourceGathered;
    protected Image tileSprite = null;
    protected Building building = null;
    private static final Image hiddenSprite = SpriteManager.cropSprite(19, 9);

    // Methods

    // Getters & Setters
    public float getMaxResourceCount() {
        return maxResourceCount;
    }

    public void setMaxResourceCount(float maxResourceCount) {
        this.maxResourceCount = maxResourceCount;
    }

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
