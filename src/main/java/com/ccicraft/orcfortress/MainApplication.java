package com.ccicraft.orcfortress;

import com.ccicraft.gamedev.*;
import com.ccicraft.gamedev.characters.CharacterManager;
import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.gamedev.tiles.TileMap;
import com.ccicraft.gamedev.characters.Character;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static int SCREEN_WIDTH = 1600;
    public static int SCREEN_HEIGHT = 900;
    public static final String DWARF = "Dwarf";
    public static final String ORC = "Orc";
    public static final int MAP_SIZE = 377;

    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Level root = new Level();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setTitle("OrcFortress");
        stage.setScene(scene);
        stage.show();

        TileMap tm = new TileMap();
        for (int i = 0; i < MAP_SIZE; i++) {
            tm.placeTile("Forest", SpriteManager.cropSprite(2, 2), new ResourceType());
        }
        root.getChildren().add(tm);

        for (int i = 0; i < 5; i++) {
            root.getChildren().add(
                    CharacterManager.createCharacter(DWARF,
                    SpriteManager.cropSprite(15, 8),
                    1.25f,
                    1.15f,
                    1.f,
                    1.f)
            );
        }

        root.startTimer();
        tm.startTimer();
    }

    public static void main(String[] args) {
        launch();
    }
}