package com.ccicraft.gamedev.characters;

import com.ccicraft.gamedev.game.Actor;
import com.ccicraft.gamedev.game.SpriteManager;
import com.ccicraft.gamedev.tiles.Tile;
import com.ccicraft.maths.Vector2D;
import javafx.scene.image.Image;

public class Character extends Actor {
    // Constructor
    public Character(Image image, Vector2D pos, CharacterType type) {
        super(image, pos);
        this.type = type;
    }

    // Variables
    public String characterName = "Jason";
    protected CharacterType type;
    private int uniqueID = -1;
    private Actor target = null;
    private float characterSpeed = 100.f;

    // Methods
    public void update(float delta) {
        super.update(delta);

        characterAction(); // Maybe use a state pattern instead ?
    }

    protected void moveCharacter(Vector2D target, Vector2D self) {
        double angle = target.computeAngle(self);
        double currentX = self.x + characterSpeed * Math.cos(angle) * currentDelta;
        getSprite().setX(currentX);
        double currentY = self.y + characterSpeed * Math.sin(angle) * currentDelta;
        getSprite().setY(currentY);
    }

    protected void gatherResources(Tile targetTile) {
        targetTile.gatherResources(type);
    }

    private void characterAction() {
        if (target == null) {
            return;
        }

        double selfX = getSprite().getX();
        double selfY = getSprite().getY();
        Vector2D v = new Vector2D(selfX, selfY);

        double targetX = target.getSprite().getX();
        double targetY = target.getSprite().getY();
        Vector2D t = new Vector2D(targetX, targetY);

        if (t.computeDistance(v) < SpriteManager.SPRITE_SIZE_PX) {
            if (target instanceof Tile)
            {
                ((Tile) target).revealTile();
                gatherResources((Tile) target);
            }
            return;
        }
        moveCharacter(t, v);
    }


    // Clickable
    @Override
    protected void setClickable() {
        sprite.setPickOnBounds(true);
        sprite.setOnMouseClicked(mouseEvent -> selectSelf());
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
    public Actor getTarget() {
        return target;
    }

    public void setTarget(Actor target) {
        this.target = target;
    }

    public void removeTarget() {
        target = null;
    }
}
