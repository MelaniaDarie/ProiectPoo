package com.example.proiectpoo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LastPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void exitAction(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/hello-view.fxml").toURI().toURL();
        // FXMLLoader loader  = new FXMLLoader(getClass().getResource("/resources/hello-view.fxml"));
        root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
}
