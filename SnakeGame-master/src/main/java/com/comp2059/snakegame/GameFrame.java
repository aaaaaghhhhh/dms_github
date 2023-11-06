package com.comp2059.snakegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameFrame extends Application {

    @Override
    public void start(Stage primaryStage) {
        GamePanel gamePanel = new GamePanel();
        Scene scene = new Scene(gamePanel, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
