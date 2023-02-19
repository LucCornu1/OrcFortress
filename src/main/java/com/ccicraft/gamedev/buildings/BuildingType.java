package com.ccicraft.gamedev.buildings;

import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.gamedev.tiles.TileType;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class BuildingType extends TileType {
    // Constructor
    public BuildingType(String name) {
        super(name);
    }

    public BuildingType(String name, Image tileSprite) {
        super(name, tileSprite);
    }

    public BuildingType(String name, Image tileSprite, float bonus,
                        Map<ResourceType, Float> dwarfBuildCost,
                        Map<ResourceType, Float> orcBuildCost) {
        super(name, tileSprite);
        this.bonus = bonus;
        this.dwarfBuildCost = dwarfBuildCost;
        this.orcBuildCost = orcBuildCost;
    }

    // Variables
    protected float bonus = 1;
    private Map<ResourceType, Float> dwarfBuildCost = new HashMap<>();
    private Map<ResourceType, Float> orcBuildCost = new HashMap<>();

    // Getters & Setters
    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public Map<ResourceType, Float> getDwarfBuildCost() {
        return dwarfBuildCost;
    }

    public void setDwarfBuildCost(Map<ResourceType, Float> dwarfBuildCost) {
        this.dwarfBuildCost = dwarfBuildCost;
    }

    public Map<ResourceType, Float> getOrcBuildCost() {
        return orcBuildCost;
    }

    public void setOrcBuildCost(Map<ResourceType, Float> orcBuildCost) {
        this.orcBuildCost = orcBuildCost;
    }
}
