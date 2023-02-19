package com.ccicraft.gamedev.buildings;

import com.ccicraft.gamedev.characters.CharacterType;
import com.ccicraft.gamedev.tiles.Tile;
import com.ccicraft.gamedev.tiles.TileType;
import com.ccicraft.maths.Vector2D;

public class Building extends Tile {
    // Constructor
    public Building(Vector2D pos, TileType type) {
        super(pos, type);
        tileResources = 10.f;
    }

    // Variables
    private int level = 0;

    // Methods
    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void interact(CharacterType species) {
        setTileResources((float) (tileResources - currentDelta));
    }

    public float getScaledBonus() {
        float bonus = 1.f;
        if (type instanceof BuildingType) {
            BuildingType t = (BuildingType) this.type;
            bonus = t.getBonus();
        }
        return level * bonus;
    }

    // Getters & Setters
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setTileResources(float tileResources) {
        super.setTileResources(tileResources);
        if (tileResources <= 0.f) {
            level += 1;
            setTileResources(type.getMaxResourceCount());
        }
    }
}
