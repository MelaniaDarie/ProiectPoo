package com.example.proiectpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;


public class AppInterface extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            URL url = new File("src/main/resources/Afterlog.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            Image iconPng = new Image("logo.png");
            primaryStage.getIcons().add(iconPng);
            primaryStage.show();
            primaryStage.setTitle("Parking App");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
