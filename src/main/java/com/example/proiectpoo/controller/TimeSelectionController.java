package com.example.proiectpoo.controller;

import com.example.proiectpoo.enumeration.TimeTicket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimeSelectionController implements  Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<TimeTicket> timeChoice;


   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeChoice.getItems().setAll(TimeTicket.values());
    }

    @FXML
    public void backToArea(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/Afterlog.fxml").toURI().toURL();
        // FXMLLoader loader  = new FXMLLoader(getClass().getResource("/resources/hello-view.fxml"));
        root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    @FXML
    public void lastStep(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/last-page.fxml").toURI().toURL();
        // FXMLLoader loader  = new FXMLLoader(getClass().getResource("/resources/hello-view.fxml"));
        root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }
}
