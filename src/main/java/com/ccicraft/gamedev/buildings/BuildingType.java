package com.ccicraft.gamedev.buildings;

import com.ccicraft.gamedev.game.GameManager;
import com.ccicraft.gamedev.resources.ResourceType;
import javafx.scene.image.Image;

public class BuildingType {
    // Constructor
    public BuildingType(String name, GameManager.EGatherMethod gatherBoost, Image image) {
        this.name = name;
        this.gatherBoost = gatherBoost;
        this.image = image;
    }

    public BuildingType(String name) {
        this.name = name;
    }

    // Variables
    public String name = "";
    protected GameManager.EGatherMethod gatherBoost = GameManager.EGatherMethod.NONE;
    protected Image image = null;

    // Methods

    // Getters & Setters
}
