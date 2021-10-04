package com.teambeta.bloodbank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage.setScene(new Scene(root,630,522));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setResizable(true);
        stage.setTitle("Login");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}