package com.ccicraft.gamedev.characters;

import com.ccicraft.gamedev.characters.Character;
import com.ccicraft.maths.Vector2D;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    // Constructor

    // Variables
    private static List<Character> selectedWorkers = new ArrayList<>();

    // Methods
    public static void selectCharacter(Character worker) {
        selectedWorkers.add(worker);
    }

    public static void deselectCharacter(Character worker) {
        selectedWorkers.remove(worker);
    }

    public static Character createCharacter(String species, Image image, float ms, float gs, float cs, float hs) {
        CharacterType type = CharacterFactory.getCharacterType(species, image, ms, gs, cs, hs);
        Character worker = new Character(image, new Vector2D(0.f, 0.f), type);
        return worker;
    }

    public static List<Character> getSelectedWorkers() {
        return selectedWorkers;
    }

    public static Boolean isSelected(Character worker) {
        return selectedWorkers.contains(worker);
    }
}
