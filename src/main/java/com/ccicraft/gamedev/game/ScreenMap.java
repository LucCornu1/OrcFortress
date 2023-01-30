package com.ccicraft.gamedev.game;

import com.ccicraft.maths.Vector2D;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/***
 * I wanted to have two threads, one for game logic and another one for rendering
 * But it was too much work, so I decided to go with only one instead
 * ***/

public class ScreenMap extends GameObject {
    // Constructor
    public ScreenMap() {
        // Pass
    }

    // Variables
    private Pane screen = new Pane();
    // private List<Tile> tiles = new ArrayList<>();
    private Vector2D nextTilePosition = new Vector2D(0, 0);

    public ArrayList<Actor> renderedActors = new ArrayList<>();

    // Interface implementation
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            update();
        }
    };

    public void update() {
        screen.getChildren().clear();
        Rectangle rect = new Rectangle(0, 0, 1920, 1080);
        screen.getChildren().add(rect);

        for (Actor next: renderedActors) {
            screen.getChildren().add(next.getSprite());
        }
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
        screen.getChildren().clear();
    }

    // Methods
    /*public void placeTile(String name, Image image, ResourceType resourceType) {
        TileType type = TileFactory.getTileType(name, image, resourceType);
        Tile tile = new Tile(nextTilePosition, type);
        nextTilePosition.x += SpriteManager.SPRITE_SIZE_PX;
        if (nextTilePosition.x > MainApplication.SCREEN_WIDTH - SpriteManager.SPRITE_SIZE_PX) {
            nextTilePosition.x = 0;
            nextTilePosition.y += SpriteManager.SPRITE_SIZE_PX;
        }
        // tiles.add(tile);
        screen.getChildren().add(tile);
    }

    public void revealNeighbours(Tile tile) {
        double spriteSize = SpriteManager.SPRITE_SIZE_PX;
        double rowSize = MainApplication.SCREEN_WIDTH - spriteSize;
        int indexDiff = (int) Math.round(rowSize / spriteSize);
        int index = screen.getChildren().indexOf(tile);

        checkLowerBound(indexDiff, index);
        checkUpperBound(indexDiff, index);
    }

    private void checkLowerBound(int indexDiff, int index) {
        if (index - 1 < 0) {
            return;
        }
        Node child = null;
        child = screen.getChildren().get(index - 1);
        if (child != null && child instanceof Tile) {
            Tile t = (Tile) child;
            t.revealSingle();
        }

        if (index - indexDiff < 0) {
            return;
        }
        child = null;
        child = screen.getChildren().get(index - indexDiff);
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
        child = screen.getChildren().get(index + 1);
        if (child != null && child instanceof Tile) {
            Tile t = (Tile) child;
            t.revealSingle();
        }

        if (index + indexDiff >= MainApplication.MAP_SIZE) {
            return;
        }
        child = null;
        child = screen.getChildren().get(index + indexDiff);
        if (child != null && child instanceof Tile) {
            Tile t = (Tile) child;
            t.revealSingle();
        }
    }*/

    // Methods

    // Getters & Setters
    public Pane getScreen() {
        return screen;
    }

    public void setScreen(Pane screen) {
        this.screen = screen;
    }
}
