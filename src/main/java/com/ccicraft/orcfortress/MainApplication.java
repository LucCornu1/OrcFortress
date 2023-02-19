package com.ccicraft.orcfortress;

import com.ccicraft.gamedev.characters.CharacterFactory;
import com.ccicraft.gamedev.characters.CharacterManager;
import com.ccicraft.gamedev.game.*;
import com.ccicraft.gamedev.resources.ResourceFactory;
import com.ccicraft.gamedev.resources.ResourceType;
import com.ccicraft.gamedev.tiles.TileFactory;
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



        Level currentLevel = new Level();
        currentLevel.startTimer();
    }

    public static void main(String[] args) {
        launch();
    }
}