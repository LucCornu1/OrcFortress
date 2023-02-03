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

    public static void initGame() {
        // Use a builder pattern to avoid long constructors ?
        CharacterFactory.getCharacterType(GameManager.DWARF,
                SpriteManager.cropSprite(1, 1),
                0.5f,
                0.5f,
                1.2f,
                1.2f);

        CharacterFactory.getCharacterType(GameManager.ORC,
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

        TileFactory.getTileType("Forest", SpriteManager.cropSprite(5, 5), WOOD);
        TileFactory.getTileType("Mine", SpriteManager.cropSprite(4, 5), IRON);
        TileFactory.getTileType("Orchard", SpriteManager.cropSprite(6, 5), FRUIT);
        TileFactory.getTileType("Meadow", SpriteManager.cropSprite(5, 5), MEAT);
    }

    public static void main(String[] args) {
        initGame();
        launch();
    }
}