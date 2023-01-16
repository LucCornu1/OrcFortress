package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.Actor;
import com.ccicraft.gamedev.characters.CharacterManager;
import com.ccicraft.maths.Vector2D;
import com.ccicraft.gamedev.characters.Character;
import javafx.event.EventHandler;
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
    public List<Character> workersList = new ArrayList<>();
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

    public void revealTile() {
        if (CURRENT_STATE == STATE.DISCOVERED) {
            return;
        }
        CURRENT_STATE = STATE.DISCOVERED;
    }

    public void placeCharacter(List<Character> workers) {
        if (workers.size() < 1) {
            System.out.println("This is an empty tile");
        }

        revealTile();
        while(workers.iterator().hasNext()) {
            Character worker = workers.iterator().next();
            workersList.add(worker);
            worker.setX(getX());
            worker.setY(getY());
            CharacterManager.deselectCharacter(worker);
        }
    }

    private void setClickable() {
        setPickOnBounds(true);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                placeCharacter(CharacterManager.getSelectedWorkers());
            }
        });
    }

    private int gatherResources() {
        if (tileResources <= 0) {
            return 0;
        }
        int stack = workersList.size() * densityResources;
        setTileResources(tileResources - stack);
        return stack;
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
