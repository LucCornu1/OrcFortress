package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.Actor;
import com.ccicraft.gamedev.DeltaTime;
import com.ccicraft.gamedev.SpriteManager;
import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.maths.Vector2D;
import com.ccicraft.orcfortress.MainApplication;
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
    // private List<Tile> tiles = new ArrayList<>();
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
            if (child instanceof Actor) {
                Actor a = (Actor) child;
                a.update(deltaTime);
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
        if (nextTilePosition.x > MainApplication.SCREEN_WIDTH - SpriteManager.SPRITE_SIZE_PX) {
            nextTilePosition.x = 0;
            nextTilePosition.y += SpriteManager.SPRITE_SIZE_PX;
        }
        // tiles.add(tile);
        getChildren().add(tile);
    }

    public void revealNeighbours(Tile tile) {
        double spriteSize = SpriteManager.SPRITE_SIZE_PX;
        double rowSize = MainApplication.SCREEN_WIDTH - spriteSize;
        int indexDiff = (int) Math.round(rowSize / spriteSize);
        int index = getChildren().indexOf(tile);

        checkLowerBound(indexDiff, index);
        checkUpperBound(indexDiff, index);
    }

    private void checkLowerBound(int indexDiff, int index) {
        if (index - 1 < 0) {
            return;
        }
        Node child = null;
        child = getChildren().get(index - 1);
        if (child != null && child instanceof Tile) {
            Tile t = (Tile) child;
            t.revealSingle();
        }

        if (index - indexDiff < 0) {
            return;
        }
        child = null;
        child = getChildren().get(index - indexDiff);
        if (child != null && child instanceof Tile) {
            Tile t = (Tile) child;
            t.revealSingle();
        }
    }

    private void checkUpperBound(int indexDiff, int index) {
        if (index + 1 >= MainApplication.MAP_SIZE) {
            return;
        }
        Node child = null;
        child = getChildren().get(index + 1);
        if (child != null && child instanceof Tile) {
            Tile t = (Tile) child;
            t.revealSingle();
        }

        if (index + indexDiff >= MainApplication.MAP_SIZE) {
            return;
        }
        child = null;
        child = getChildren().get(index + indexDiff);
        if (child != null && child instanceof Tile) {
            Tile t = (Tile) child;
            t.revealSingle();
        }
    }

    // Methods
    public void changeScale(double xScale, double yScale) {
        for (Node child: getChildren()) {
            if (child instanceof Actor) {
                Actor a = (Actor) child;
                a.scale(xScale, yScale);
            }
        }
    }

    // Getters & Setters
}
