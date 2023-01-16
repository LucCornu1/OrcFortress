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

    public static Character createCharacter(String species, Image image, float ms, float gs, float cs, float hs) {
        CharacterType type = CharacterFactory.getCharacterType(species, image, ms, gs, cs, hs);
        Character worker = new Character(image, new Vector2D(0.f, 0.f), type);
        return worker;
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
