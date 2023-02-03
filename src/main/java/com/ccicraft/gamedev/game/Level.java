package com.ccicraft.gamedev.game;

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

        return deltaTime;
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

        getChildren().add(
                new Tile(
                    new Vector2D(400.0, 400.0),
                    TileFactory.getTileType("Forest")
                )
        );
        getChildren().add(
                new Tile(
                    new Vector2D(800.0, 20.0),
                    TileFactory.getTileType("Mine")
                )
        );
        getChildren().add(
                new Character(
                    SpriteManager.cropSprite(0,1),
                    new Vector2D(10.0, 400.0),
                    CharacterManager.getSpecies(GameManager.DWARF)
                )
        );
        getChildren().add(
                new Character(
                    SpriteManager.cropSprite(0,1),
                    new Vector2D(50.0, 320.0),
                    CharacterManager.getSpecies(GameManager.DWARF)
                )
        );
    }

    public void stopTimer() {
        timer.stop();
        GameManager.root.stopTimer();
        getChildren().clear();
    }

    // Methods

    // Getters & Setters
    public ArrayList<GameObject> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<GameObject> children) {
        this.children = children;
    }

}
