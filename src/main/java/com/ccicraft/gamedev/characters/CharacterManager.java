package com.ccicraft.gamedev.characters;

import com.ccicraft.gamedev.characters.Character;
import com.ccicraft.maths.Vector2D;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    // Constructor

    // Variables
    private static Character selectedWorker = null;

    // Methods
    public static void selectCharacter(Character worker) {
        selectedWorker = worker;
    }

    public static void deselectCharacter() {
        selectedWorker = null;
    }

    public static CharacterType getSpecies(String species) {
        return CharacterFactory.getCharacterType(species);
    }

    public static Character getSelectedWorker() {
        return selectedWorker;
    }

    public static Boolean isSelected(Character worker) {
        return selectedWorker == worker;
    }

    public static Boolean isAnySelected() {
        return selectedWorker != null;
    }
}
