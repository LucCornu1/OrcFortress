package com.ccicraft.gamedev.characters;

import javafx.scene.image.Image;

public class CharacterType {
    // Constructor
    public CharacterType(String species, Image image, float miningSpeed, float gatheringSpeed, float choppingSpeed, float huntingSpeed) {
        this.species = species;
        this.characterSprite = image;
        this.miningSpeed = miningSpeed;
        this.gatheringSpeed = gatheringSpeed;
        this.choppingSpeed = choppingSpeed;
        this.huntingSpeed = huntingSpeed;
    }

    // Variables
    public String species;
    public float miningSpeed = 1.f;
    public float gatheringSpeed = 1.f;
    public float choppingSpeed = 1.f;
    public float huntingSpeed = 1.f;
    protected Image characterSprite;

    // Methods

    // Getters & Setters
}
