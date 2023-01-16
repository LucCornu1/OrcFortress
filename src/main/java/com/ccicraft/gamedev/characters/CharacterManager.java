package com.ccicraft.gamedev.characters;

import com.ccicraft.gamedev.characters.Character;

import java.util.List;

public class CharacterManager {
    // Constructor

    // Variables
    public static List<Character> workersList;
    private static List<Character> selectedWorkers;

    // Methods
    public static void addCharacter(String species) {
        // Add a new worker to workersList
    }

    public static void selectCharacter(Character worker) {
        selectedWorkers.add(worker);
    }

    public static void deselectCharacter(Character worker) {
        selectedWorkers.remove(worker);
    }


}
