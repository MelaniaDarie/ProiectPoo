package com.example.proiectpoo.controller;

import com.example.proiectpoo.Ticket;
import com.example.proiectpoo.Userlog;
import com.example.proiectpoo.sevice.TicketService;
import com.example.proiectpoo.sevice.UserlogService;
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

public class AfterlogController implements Initializable {

    private TicketService ticketService;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> choice1;
    @FXML
    private ChoiceBox<String> choice2;
    @FXML
    private ChoiceBox<String> choice3;

    private String[] area1={"Centrul Istoric","Poiana Brasov"};
    private String[] area2={"Centrul Nou","Astra","Valea Cetatii","Scriitorilor","Florilor","Tractorul","Schei","Bartolomeu","Craiter"};
    private String[] area3={"Bartolomeu Nord","Noua-Darste","Triaj","Stupini"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choice1.getItems().addAll(area1);
        choice2.getItems().addAll(area2);
        choice3.getItems().addAll(area3);
    }

    @FXML
    public void switchTimeSelection(ActionEvent event) throws IOException {

        ticketService = new TicketService();

        try {
            Ticket ticket = new Ticket();
            ticket.setName(choice1.getValue());
            ticket.setName(choice2.getValue());
            ticket.setName(choice3.getValue());
            ticketService.addClient(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add area to Ticket!");
        }


        try{
            URL url = new File("src/main/resources/TimeSelection.fxml").toURI().toURL();
            // FXMLLoader loader  = new FXMLLoader(getClass().getResource("/resources/hello-view.fxml"));
            root = FXMLLoader.load(url);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene((scene));
            stage.show();
        }  catch (Exception e){
            System.out.println("Not found TimeSelection!");
        }

    }

    @FXML
    public void logout(ActionEvent event) throws IOException{

        URL url = new File("src/main/resources/hello-view.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
