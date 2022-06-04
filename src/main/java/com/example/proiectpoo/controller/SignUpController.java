package com.example.proiectpoo.controller;

import com.example.proiectpoo.Userlog;
import com.example.proiectpoo.sevice.UserlogService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;



public class SignUpController{

    private UserlogService userlogService;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private TextField phone;
    @FXML
    private Label errorEmail;
    @FXML
    private Label errorPhone;
    @FXML
    private Label errorPassword;

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/hello-view.fxml").toURI().toURL();
       // FXMLLoader loader  = new FXMLLoader(getClass().getResource("/resources/hello-view.fxml"));
        root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene((scene));
        stage.show();
    }

    @FXML
    public void signUp(ActionEvent actionEvent) {
        boolean formValid = true;

        userlogService = new UserlogService();

        errorEmail.setVisible(false);
        if (!emailValid(email.getText())) {
            String errorMsg = "Email not valid!";
            errorEmail.setText(errorMsg);
            errorEmail.setVisible(true);
            System.out.println(errorMsg);
            formValid = false;
        }

        errorPhone.setVisible(false);
        if (!phoneValid(phone.getText())) {
            String errorMsg = "Phone number not valid!";
            errorPhone.setText(errorMsg);
            errorPhone.setVisible(true);
            System.out.println(errorMsg);
            formValid = false;
        }

        errorPassword.setVisible(false);
        if (!passwordValid(password.getText())) {
            String errorMsg = "Password not valid!";
            errorPassword.setText(errorMsg);
            errorPassword.setVisible(true);
            System.out.println(errorMsg);
            formValid = false;
        }

        if (!formValid) {
            return;
        }

        try{
            userlogService.findClient(email.getText(),password.getText());
            errorEmail.setText("Client already exists!");
            errorEmail.setVisible(true);
            return;
        } catch (Exception e){
            System.out.println("We can add client!");
        }

        try {
           Userlog userlog = new Userlog();
           userlog.setEmail(email.getText());
           userlog.setPassword(password.getText());
           userlog.setPhone(phone.getText());
           userlogService.addClient(userlog);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add user!");
        }

        try{
            URL url = new File("src/main/resources/Afterlog.fxml").toURI().toURL();
            // FXMLLoader loader  = new FXMLLoader(getClass().getResource("/resources/hello-view.fxml"));
            root = FXMLLoader.load(url);
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene((scene));
            stage.show();
        }  catch (Exception e){
            System.out.println("Not found Afterlog!");
        }

    }
    //Regex check
    public boolean emailValid(String email) {
        //ceva@ceva.ceva
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regexEmail);
        return email != null && pattern.matcher(email).matches();
    }

    public boolean phoneValid(String phone) {
        // 07xxxxxxxx
        String regexNumber = "^(4|)?(07[0-8]{1}[0-9]{1}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$";
        Pattern pattern = Pattern.compile(regexNumber);
        return phone != null && pattern.matcher(phone).matches();
    }

    public boolean passwordValid(String password) {
        //	minim 8 caractere,o majuscula,o cifra
        String regexPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
        Pattern pattern = Pattern.compile(regexPassword);
        return password != null && pattern.matcher(password).matches();
    }

}