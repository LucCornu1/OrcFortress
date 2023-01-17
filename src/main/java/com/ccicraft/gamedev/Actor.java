package com.ccicraft.gamedev;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.ccicraft.maths.*;

public class Actor extends ImageView {
    // Constructor
    public Actor(Image image) {
        setImage(image);
    }

    public Actor(Image image, Vector2D pos) {
        setImage(image);
        setX(pos.x);
        setY(pos.y);
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
    protected Vector2D numCells;
    protected Rectangle2D[][] cellClips;

    // Methods
    public void update(float delta) {
        // pass
    }

    public void scale(double xScale, double yScale) {
        setScaleX(getScaleX() + xScale);
        setScaleY(getScaleY() + yScale);
    }

    // Getters & Setters
}
