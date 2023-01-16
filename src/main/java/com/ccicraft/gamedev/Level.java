package com.ccicraft.gamedev;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Level extends Pane implements DeltaTime {
    // Constructor
    public Level() {
        super();
    }

    public Level(int x, int y, int height, int width) {
        super();
        relocate(x, y);
        setPrefSize(height, width);
    }

    public Level(Node... children) {
        super(children);
    }

    // Variables

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

        for (Node child: getChildren()) {
            if (child instanceof GameObject) {
                GameObject go = (GameObject) child;
                go.update(deltaTime);
            }
        }
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
        getChildren().removeAll();
    }

}
