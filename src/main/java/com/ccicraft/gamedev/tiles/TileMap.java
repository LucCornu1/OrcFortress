package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.DeltaTime;
import com.ccicraft.gamedev.GameObject;
import com.ccicraft.gamedev.Level;
import com.ccicraft.gamedev.SpriteManager;
import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.maths.Vector2D;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class TileMap extends Pane implements DeltaTime {
    // Constructor
    public TileMap() {
        // Pass
    }

    // Variables
    private List<Tile> tiles = new ArrayList<>();
    private Vector2D nextTilePosition = new Vector2D(0, 0);

    // Interface implementation
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            update();
        }
    };
    private long previousTime = System.nanoTime();

    public float computeDeltaTime() {
        long time = System.nanoTime();
        int deltaTime = (int) ((time - previousTime) / 1000000);
        previousTime = time;

        return deltaTime;
    }

    public void update() {
        float deltaTime = computeDeltaTime();

        for (Node child: getChildren()) {
            if (child instanceof GameObject) {
                GameObject go = (GameObject) child;
                go.update(deltaTime);
            }
        }
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
        getChildren().removeAll();
    }

    // Methods
    public void placeTile(String name, Image image, ResourceType resourceType) {
        TileType type = TileFactory.getTileType(name, image, resourceType);
        Tile tile = new Tile(nextTilePosition, type);
        nextTilePosition.x += SpriteManager.SPRITE_SIZE_PX;
        if (nextTilePosition.x > 1500) {
            nextTilePosition.x = 0;
            nextTilePosition.y += SpriteManager.SPRITE_SIZE_PX;
        }
        tiles.add(tile);
        getChildren().add(tile);
    }

    // Getters & Setters
}
