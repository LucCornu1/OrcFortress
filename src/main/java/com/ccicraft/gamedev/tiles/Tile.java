package com.ccicraft.gamedev.tiles;

import com.ccicraft.gamedev.characters.CharacterManager;
import com.ccicraft.gamedev.characters.Character;
import com.ccicraft.gamedev.characters.CharacterType;
import com.ccicraft.gamedev.game.Actor;
import com.ccicraft.maths.Vector2D;

import java.util.concurrent.ThreadLocalRandom;

public class Tile extends Actor {
    // Constructor
    public Tile(Vector2D pos, TileType type) {
        super(TileType.getHiddenSprite(), pos);
        this.type = type;
    }

    // Variables
    public enum STATE{
        HIDDEN,
        DISCOVERED
    };
    protected TileType type;
    protected float tileResources = ThreadLocalRandom.current().nextInt(9000) + 1000;
    protected STATE CURRENT_STATE = STATE.HIDDEN;

    // Methods
    @Override
    public void update(float delta) {
        super.update(delta);
    }

    public void revealTile() {
        if (CURRENT_STATE == STATE.DISCOVERED) {
            return;
        }
        CURRENT_STATE = STATE.DISCOVERED;
        sprite.setImage(type.tileSprite);
    }

    public void interact(CharacterType species) {
        if (tileResources <= 0) { // Need to take into account that you cannot gather more resources than there is left
            return;
        }

        float gatheringSpeed = getType().getResourceGathered().getGatheringSpeed();

        float gatherAmount = switch(getType().getResourceGathered().getGatherMethod()) {
            case MINING -> (float) (species.getMiningSpeed() * gatheringSpeed * currentDelta);
            case GATHERING -> (float) (species.getGatheringSpeed() * gatheringSpeed * currentDelta);
            case HUNTING -> (float) (species.getHuntingSpeed() * gatheringSpeed * currentDelta);
            case CHOPPING -> (float) (species.getChoppingSpeed() * gatheringSpeed * currentDelta);
            case NONE -> (float) (0.1f * currentDelta);
        };

        if (type.building.getScaledBonus() <= 0.99f) {
            gatherAmount *= type.building.getScaledBonus();
        }

        type.getResourceGathered().addResource(gatherAmount);
        setTileResources(tileResources - gatherAmount);
        /*System.out.println(type.getResourceGathered().name
        + " count : "
        + (int) type.getResourceGathered().getResourceCount());*/
    }

    @Override
    protected void setClickable() {
        sprite.setPickOnBounds(true);
        sprite.setOnMouseClicked(mouseEvent -> {
            if (CURRENT_STATE == STATE.DISCOVERED) {
                System.out.println("This tile is a : " + type.name);
                System.out.println("It has : " + tileResources + " resources left");
            }

            if (CharacterManager.isAnySelected()) {
                CharacterManager.getSelectedWorker().setTarget(this);
            }
        });
    }

    // Getters & Setters
    public float getTileResources() {
        return tileResources;
    }

    public void setTileResources(float tileResources) {
        this.tileResources = Math.max(0.f, tileResources);
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }
}
