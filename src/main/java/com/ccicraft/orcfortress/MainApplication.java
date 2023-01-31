package com.ccicraft.orcfortress;

import com.ccicraft.gamedev.characters.CharacterManager;
import com.ccicraft.gamedev.game.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    // Variables

    // Methods
    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(GameManager.root.getScreen(), GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT);
        stage.setTitle("OrcFortress");
        stage.setScene(scene);
        stage.show();

        CharacterManager.createSpecies(GameManager.DWARF, SpriteManager.cropSprite(1, 1), 0.5f, 0.5f, 1.2f, 1.2f);

        Level currentLevel = new Level();
        currentLevel.startTimer();

        /*ScreenMap tm = new ScreenMap();
        root.getChildren().add(new Rectangle(0, 0, 1920, 1080));
        for (int i = 0; i < MAP_SIZE; i++) {
            tm.placeTile("Forest", SpriteManager.cropSprite(2, 2), new ResourceType());
        }
        root.getChildren().add(tm);

        for (int i = 0; i < 5; i++) {
            tm.getScreen().getChildren().add(
                    CharacterManager.createCharacter(DWARF,
                    SpriteManager.cropSprite(15, 8),
                    1.25f,
                    1.15f,
                    1.f,
                    1.f)
            );
        }

        // root.startTimer();
        tm.startTimer();*/
    }

    public static void main(String[] args) {
        launch();
    }
}