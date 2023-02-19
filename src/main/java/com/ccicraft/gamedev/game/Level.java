package com.ccicraft.gamedev.game;

import com.ccicraft.gamedev.buildings.Building;
import com.ccicraft.gamedev.buildings.BuildingFactory;
import com.ccicraft.gamedev.buildings.BuildingType;
import com.ccicraft.gamedev.characters.Character;
import com.ccicraft.gamedev.characters.CharacterFactory;
import com.ccicraft.gamedev.characters.CharacterManager;
import com.ccicraft.gamedev.characters.CharacterType;
import com.ccicraft.gamedev.resources.ResourceFactory;
import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.gamedev.tiles.Tile;
import com.ccicraft.gamedev.tiles.TileFactory;
import com.ccicraft.gamedev.tiles.TileType;
import com.ccicraft.maths.Vector2D;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/***
 * The use of an AnimationTimer for game logic is not optimal
 * But due to lack of time, I settled for this solution
 * ***/

public class Level implements DeltaTime {
    // Constructor
    public Level() {
    }

    // Variables
    protected ArrayList<GameObject> children = new ArrayList<>();

    // Interface implementation
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            update();
        }
    };
    private long previousTime = System.nanoTime();

    public float computeDeltaTime() {
        long time = System.nanoTime();
        float deltaTime = (float) ((time - previousTime) / 1000000000.0);
        previousTime = time;

        return deltaTime * GameManager.getCurrentSpeedAsInteger();
    }

    public void update() {
        float deltaTime = computeDeltaTime();

        if (GameManager.root == null) {
            GameManager.GAME_ON = false;
            return;
        }

        GameManager.root.clearRenderedActors();
        ArrayList<Actor> newList = new ArrayList<>();

        for (GameObject child: getChildren()) {
            child.update(deltaTime);

            if (child instanceof Actor) {
                Actor actor = (Actor) child;
                newList.add(actor);
            }
        }

        GameManager.root.setRenderedActors(newList);
    }

    public void startTimer() {
        timer.start();
        GameManager.root.startTimer();

        init();
    }

    public void stopTimer() {
        timer.stop();
        GameManager.root.stopTimer();
        getChildren().clear();
    }

    // Methods
    private void init() {
        // Use a builder pattern to avoid long constructors ?
        CharacterType DWARF = CharacterFactory.getCharacterType(GameManager.DWARF,
                SpriteManager.cropSprite(1, 1),
                0.5f,
                0.5f,
                1.2f,
                1.2f);

        CharacterType ORC = CharacterFactory.getCharacterType(GameManager.ORC,
                SpriteManager.cropSprite(2, 4),
                1.2f,
                1.2f,
                0.5f,
                0.5f);

        ResourceType WOOD = ResourceFactory.getResourceType("WOOD",
                GameManager.EGatherMethod.CHOPPING,
                0.05f);
        ResourceType IRON = ResourceFactory.getResourceType("IRON",
                GameManager.EGatherMethod.MINING,
                0.045f);
        ResourceType FRUIT = ResourceFactory.getResourceType("FRUIT",
                GameManager.EGatherMethod.GATHERING,
                0.1f);
        ResourceType MEAT = ResourceFactory.getResourceType("MEAT",
                GameManager.EGatherMethod.HUNTING,
                0.09f);

        Map<ResourceType, Float> dwarfCost = new HashMap<ResourceType, Float>();
        dwarfCost.put(IRON, 10.f);

        Map<ResourceType, Float> orcCost = new HashMap<ResourceType, Float>();
        orcCost.put(IRON, 10.f);

        Building SAWMILL = new Building(
                new Vector2D(0.0, 0.0),
                BuildingFactory.getBuildingType(
                        "Sawmill",
                        SpriteManager.cropSprite(1, 0),
                        1.15f,
                        dwarfCost,
                        orcCost
                )
        );
        getChildren().add(SAWMILL);

        TileType FOREST = TileFactory.getTileType("Forest", SpriteManager.cropSprite(5, 5), WOOD, SAWMILL);
        TileType MINE = TileFactory.getTileType("Mine", SpriteManager.cropSprite(4, 5), IRON, SAWMILL);
        TileType ORCHARD = TileFactory.getTileType("Orchard", SpriteManager.cropSprite(6, 5), FRUIT, SAWMILL);
        TileType MEADOW = TileFactory.getTileType("Meadow", SpriteManager.cropSprite(5, 5), MEAT, SAWMILL);

        getChildren().add(
                new Tile(
                        new Vector2D(400.0, 400.0),
                        FOREST
                )
        );
        getChildren().add(
                new Tile(
                        new Vector2D(800.0, 20.0),
                        MINE
                )
        );

        getChildren().add(
                new Character(
                        new Vector2D(10.0, 400.0),
                        DWARF
                )
        );
        getChildren().add(
                new Character(
                        new Vector2D(50.0, 320.0),
                        DWARF
                )
        );
    }

    // Getters & Setters
    public ArrayList<GameObject> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<GameObject> children) {
        this.children = children;
    }

}
