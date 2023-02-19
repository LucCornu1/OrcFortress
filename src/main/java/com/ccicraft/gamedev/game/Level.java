package com.ccicraft.gamedev.game;

import com.ccicraft.gamedev.buildings.Building;
import com.ccicraft.gamedev.buildings.BuildingFactory;
import com.ccicraft.gamedev.buildings.BuildingType;
import com.ccicraft.gamedev.characters.Character;
import com.ccicraft.gamedev.characters.CharacterManager;
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
 * The use of an AnimationTimer for game logic is not optimal, as it runs for each frame of the application
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
        ResourceType WOOD = ResourceFactory.getResourceType("WOOD", ResourceType.EGatherMethod.CHOPPING, 0.05f);
        ResourceType IRON = ResourceFactory.getResourceType("IRON", ResourceType.EGatherMethod.MINING, 0.04545f);

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

        getChildren().add(
                new Tile(
                        new Vector2D(400.0, 400.0),
                        TileFactory.getTileType(
                                "Forest",
                                SpriteManager.cropSprite(1, 5),
                                WOOD,
                                SAWMILL
                        )
                )
        );
        getChildren().add(
                new Tile(
                        new Vector2D(800.0, 20.0),
                        TileFactory.getTileType(
                                "Mine",
                                SpriteManager.cropSprite(1, 5),
                                IRON,
                                SAWMILL
                        )
                )
        );

        getChildren().add(
                new Character(
                        new Vector2D(10.0, 400.0),
                        CharacterManager.getSpecies(GameManager.DWARF)
                )
        );
        getChildren().add(
                new Character(
                        new Vector2D(50.0, 320.0),
                        CharacterManager.getSpecies(GameManager.DWARF)
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
