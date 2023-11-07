/*
package com.comp2059.snakegame.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private Button startButton;
    @FXML
    private Button optionsButton;
    @FXML
    private Button infoButton;

    @FXML
    private void initialize() {
        // Initialization if needed
    }

    @FXML
    private void showGameScreen() {
        // Logic to switch to Game Screen
    }

    @FXML
    private void showOptions() {
        // Logic to show options within the main screen
    }

    @FXML
    private void showInfo() {
        // Logic to show game information within the main screen
    }
}
*/

package com.comp2059.snakegame.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainController {
    @FXML
    private Button startButton;
    @FXML
    private Button optionsButton;
    @FXML
    private Button infoButton;
    @FXML
    private ImageView imageView;
    @FXML
    private VBox buttonsContainer; // 确保FXML中的VBox有这个fx:id

    @FXML
    private void initialize() {
        // 绑定ImageView的宽度和高度属性到StackPane的宽度和高度属性
        imageView.fitWidthProperty().bind(((StackPane) imageView.getParent()).widthProperty());
        imageView.fitHeightProperty().bind(((StackPane) imageView.getParent()).heightProperty());

        // 绑定按钮的宽度和高度属性到StackPane的宽度和高度属性
        buttonsContainer.widthProperty().addListener((obs, oldVal, newVal) -> {
            // 根据窗口宽度调整按钮宽度
            double width = newVal.doubleValue() * 0.2; // 按钮宽度为窗口宽度的30%
            startButton.setPrefWidth(width);
            optionsButton.setPrefWidth(width);
            infoButton.setPrefWidth(width);
        });

        buttonsContainer.heightProperty().addListener((obs, oldVal, newVal) -> {
            // 根据窗口高度调整按钮高度
            double buttonHeight = newVal.doubleValue() / 8; // 按钮高度为窗口高度的三分之一
            startButton.setPrefHeight(buttonHeight);
            optionsButton.setPrefHeight(buttonHeight);
            infoButton.setPrefHeight(buttonHeight);
        });
    }

    @FXML
    private void showGameScreen() {
        // Logic to switch to Game Screen
    }

    @FXML
    private void showOptions() {
        // Logic to show options within the main screen
    }

    @FXML
    private void showInfo() {
        // Logic to show game information within the main screen
    }
}