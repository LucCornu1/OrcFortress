package com.ccicraft.gamedev.characters;

import com.ccicraft.gamedev.Actor;
import com.ccicraft.maths.Vector2D;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Character extends Actor {
    // Constructor
    public Character(Image image, Vector2D pos, CharacterType type) {
        super(image, pos);
        this.type = type;
        setClickable();
    }

    // Variables
    public String characterName = "Jason";
    protected CharacterType type;
    private int uniqueID = -1;

    // Methods
    public void update(float delta) {
        // Pass
    }

    private void setClickable() {
        setPickOnBounds(true);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                selectSelf();
            }
        });
    }

    private void selectSelf() {
        if (CharacterManager.isSelected(this)) {
            CharacterManager.deselectCharacter();
            System.out.println("Character deselected");
            return;
        }
        CharacterManager.selectCharacter(this);
        System.out.println("Character selected");
    }

    // Getters & Setters
}
