package com.ccicraft.gamedev.characters;

import com.ccicraft.gamedev.Actor;
import com.ccicraft.maths.Vector2D;
import javafx.scene.image.Image;

public class Character extends Actor {
    // Constructor
    public Character(Image image) {
        super(image);
    }

    public Character(Image image, Vector2D pos) {
        super(image, pos);
    }

    // Variables
    private int uniqueID = -1;

    // Methods

    // Getters & Setters
}
