package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.Actor;
import com.ccicraft.maths.Vector2D;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class Tile extends Actor {
    // Constructor
    public Tile(Vector2D pos, TileType type) {
        super(type.tileSprite, pos);
        this.type = type;
        setClickable();
    }

    // Variables
    public ArrayList<Character> workersList;
    private int tileResources;
    private int densityResources;
    protected TileType type;

    protected STATE CURRENT_STATE = STATE.HIDDEN;
    public enum STATE{
        HIDDEN,
        DISCOVERED
    };

    // Methods
    public void update(float delta) {
        gatherResources();

        // System.out.println("This is a Tile");
    }

    private void setClickable() {
        setPickOnBounds(true);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Clicked on a tile !!");
            }
        });
    }

    private int gatherResources() {
        int stack = workersList.size() * densityResources;
        setTileResources(tileResources - stack);
        return stack;
    }

    public void revealTile() {
        if (CURRENT_STATE == STATE.DISCOVERED) {
            return;
        }
        CURRENT_STATE = STATE.DISCOVERED;
    }

    // Getters & Setters
    public int getTileResources() {
        return tileResources;
    }

    public void setTileResources(int tileResources) {
        this.tileResources = Math.max(0, tileResources);
    }

    public int getDensityResources() {
        return densityResources;
    }

    public void setDensityResources(int densityResources) {
        this.densityResources = densityResources;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }
}
