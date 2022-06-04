package com.example.proiectpoo.controller;

import com.example.proiectpoo.exceptions.EmailNotFoundException;
import com.example.proiectpoo.exceptions.PassNotFoundException;
import com.example.proiectpoo.sevice.UserlogService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.java.Log;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Log
public class LoginController {


    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongEmail;
    @FXML
    private Label wrongPassword;

    private UserlogService userlogService = new UserlogService();

    public void switchToSignUp(ActionEvent event) throws IOException{

        URL url = new File("src/main/resources/SignUp.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void login(ActionEvent actionEvent) throws Exception {

        boolean validClient = true;

        wrongEmail.setVisible(false);
        wrongPassword.setVisible(false);
        try{
            userlogService.findClient(email.getText(), password.getText());
        } catch (EmailNotFoundException em) {
            validClient = false;
            wrongEmail.setText(em.getMessage());
            wrongEmail.setVisible(true);
        } catch (PassNotFoundException pe){
            validClient = false;
            wrongPassword.setText(pe.getMessage());
            wrongPassword.setVisible(true);
        }
        if(!validClient){
            return;
        }
        try{
            URL url = new File("src/main/resources/Afterlog.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }  catch (Exception e){
            System.out.println("Not found Afterlog!");
        }
    }

}

