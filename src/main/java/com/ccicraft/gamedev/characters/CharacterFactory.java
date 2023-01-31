package com.ccicraft.gamedev.characters;

import com.ccicraft.gamedev.game.SpriteManager;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    // Constructor

    // Variables
    private static Map<String, CharacterType> characterTypes = new HashMap<>();

    // Factory
    public static CharacterType getCharacterType(String species, Image image, float ms, float gs, float cs, float hs) {
        CharacterType type = characterTypes.get(species);
        if (type == null) {
            type = new CharacterType(species, image, ms, gs, cs, hs);
            characterTypes.put(species, type);
        }
        return type;
    }

    public static CharacterType getCharacterType(String species) {
        CharacterType type = characterTypes.get(species);
        if (type == null) {
            type = new CharacterType(species, SpriteManager.cropSprite(0, 0), 1.f, 1.f, 1.f, 1.f);
            characterTypes.put(species, type);
        }
        return type;
    }
}
