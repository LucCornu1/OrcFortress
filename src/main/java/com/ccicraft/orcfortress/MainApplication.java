package com.ccicraft.orcfortress;

import com.ccicraft.gamedev.*;
import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.gamedev.tiles.TileMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static int SCREEN_WIDTH = 1600;
    public static int SCREEN_HEIGHT = 900;

    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Level root = new Level();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setTitle("OrcFortress");
        stage.setScene(scene);
        stage.show();

        TileMap tm = new TileMap();
        for (int i = 0; i < 377; i++) {
            tm.placeTile("Forest", SpriteManager.cropSprite(2, 2), new ResourceType());
        }
        root.getChildren().add(tm);
        root.startTimer();
        tm.startTimer();
    }

    public static void main(String[] args) {
        launch();
    }
}