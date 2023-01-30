package com.ccicraft.gamedev.game;

import javafx.animation.AnimationTimer;

import java.util.ArrayList;

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
        int deltaTime = (int) ((time - previousTime) / 1000000);
        previousTime = time;

        return deltaTime;
    }

    public void update() {
        float deltaTime = computeDeltaTime();

        if (GameManager.root == null) {
            GameManager.GAME_ON = false;
            return;
        }

        GameManager.root.renderedActors.clear();

        for (GameObject child: getChildren()) {
            child.update(deltaTime);

            if (child instanceof Actor) {
                Actor actor = (Actor) child;
                GameManager.root.renderedActors.add(actor);
            }
        }
    }

    public void startTimer() {
        getChildren().add(new Actor(SpriteManager.cropSprite(0,1)));
        timer.start();
        GameManager.root.startTimer();
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
