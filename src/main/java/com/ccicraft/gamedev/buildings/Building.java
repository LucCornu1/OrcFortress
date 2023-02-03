package com.ccicraft.gamedev.buildings;

import com.ccicraft.gamedev.game.Actor;
import javafx.scene.image.Image;

public class Building extends Actor {
    // Constructor
    public Building(Image image, BuildingType type) {
        super(image);
        this.type = type;
    }

    // Variables
    public boolean isPlaced = false;
    protected BuildingType type;
    private int buildingLevel = 0;

    // Methods
    public void update(float delta) {
        super.update(delta);
    }

    public void placeBuilding() {
        if (!isPlaced) {
            sprite.setX(0.0);
            sprite.setY(0.0);
            isPlaced = true;
        }
    }

    // Getters & Setters
    public int getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }
}
