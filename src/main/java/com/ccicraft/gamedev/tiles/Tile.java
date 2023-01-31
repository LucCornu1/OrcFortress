package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.game.Actor;
import com.ccicraft.maths.Vector2D;

import java.util.concurrent.ThreadLocalRandom;

public class Tile extends Actor {
    // Constructor
    public Tile(Vector2D pos, TileType type) {
        super(TileType.getHiddenSprite(), pos);
        this.type = type;
        setClickable();
    }

    // Variables
    protected TileType type;
    private int tileResources = ThreadLocalRandom.current().nextInt(9000) + 1000;

    public enum STATE{
        HIDDEN,
        DISCOVERED
    };
    protected STATE CURRENT_STATE = STATE.HIDDEN;

    // Methods
    public void update(float delta) {
        // System.out.println("This is a Tile");
    }

    public void revealTile() {
        if (CURRENT_STATE == STATE.DISCOVERED) {
            return;
        }
        CURRENT_STATE = STATE.DISCOVERED;
        sprite.setImage(type.tileSprite);
    }

    private void setClickable() {
        sprite.setPickOnBounds(true);
        sprite.setOnMouseClicked(mouseEvent -> {
            System.out.println("This tile is a : " + type.name);
            System.out.println("It has : " + tileResources + " resources left");
        });
    }

    // Getters & Setters
    public int getTileResources() {
        return tileResources;
    }

    public void setTileResources(int tileResources) {
        this.tileResources = Math.max(0, tileResources);
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }
}
