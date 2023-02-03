package com.ccicraft.gamedev.game;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.ccicraft.maths.*;

public class Actor extends GameObject {
    // Constructor
    public Actor(Image image) {
        sprite = new ImageView(image);
        GameManager.root.addRenderedActor(this);
        setClickable();
    }

    public Actor(Image image, Vector2D pos) {
        sprite = new ImageView(image);
        sprite.setX(pos.x);
        sprite.setY(pos.y);
        GameManager.root.addRenderedActor(this);
        setClickable();
    }

    /*public Actor(Image image, Vector2D numCells, Vector2D firstFrame) {
        this.numCells = numCells;

        double cellWidth = image.getWidth() / numCells.x;
        double cellHeight = image.getHeight() / numCells.y;

        cellClips = new Rectangle2D[numCells.x][numCells.y];
        for (int i = 0; i < numCells.x; i++) {
            for (int j = 0; j < numCells.y; j++) {
                cellClips[i][j] = new Rectangle2D(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
            }
        }

        setImage(image);
        setViewport(cellClips[firstFrame.x][firstFrame.y]);

        setSmooth(false);
    }*/

    // Variables
    protected ImageView sprite = null;
    /*protected Vector2D numCells;
    protected Rectangle2D[][] cellClips;*/

    // Methods
    public void update(float delta) {
        super.update(delta);
    }

    // Getters & Setters
    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }

    protected void setClickable() {
        // Pass
    }
}
