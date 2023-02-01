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
    protected Image characterSprite;
    private float miningSpeed = 1.f;
    private float gatheringSpeed = 1.f;
    private float choppingSpeed = 1.f;
    private float huntingSpeed = 1.f;

    // Methods

    // Getters & Setters
    public float getMiningSpeed() {
        return miningSpeed;
    }

    public void setMiningSpeed(float miningSpeed) {
        this.miningSpeed = miningSpeed;
    }

    public float getGatheringSpeed() {
        return gatheringSpeed;
    }

    public void setGatheringSpeed(float gatheringSpeed) {
        this.gatheringSpeed = gatheringSpeed;
    }

    public float getChoppingSpeed() {
        return choppingSpeed;
    }

    public void setChoppingSpeed(float choppingSpeed) {
        this.choppingSpeed = choppingSpeed;
    }

    public float getHuntingSpeed() {
        return huntingSpeed;
    }

    public void setHuntingSpeed(float huntingSpeed) {
        this.huntingSpeed = huntingSpeed;
    }
}
