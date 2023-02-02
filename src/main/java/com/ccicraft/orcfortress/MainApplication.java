package com.ccicraft.orcfortress;

import com.ccicraft.gamedev.characters.CharacterFactory;
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

        // Use a builder pattern to avoid long constructors ?
        CharacterFactory.getCharacterType(GameManager.DWARF,
                SpriteManager.cropSprite(1, 1),
                0.5f,
                0.5f,
                1.2f,
                1.2f);

        Level currentLevel = new Level();
        currentLevel.startTimer();
    }

    public static void main(String[] args) {
        launch();
    }
}