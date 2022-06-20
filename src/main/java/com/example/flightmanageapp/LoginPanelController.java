package com.example.flightmanageapp;

import entitiesAndMappings.User;
import entitiesAndMappings.UserMapping;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.EntityManager;

import java.io.IOException;

public class LoginPanelController {

    @FXML
    private Button exitButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField enterUsernameTextField;

    @FXML
    private PasswordField enterPasswordTextField;

    @FXML
    private Label loginMessageLabel;


    public void loginButtonOnAction(ActionEvent event) throws IOException {

        String username = enterUsernameTextField.getText();
        String password = enterPasswordTextField.getText();

        if (username.isBlank() || password.isBlank()) {
            loginMessageLabel.setText("Enter username and password");
            return;
        }

        //Query query = new Query();
        //boolean logged = query.checkIfLogged(username, password);

        EntityManager entityManager = new EntityManager();
        entityManager.setConnection();
        entityManager.setUserMapping(new UserMapping(new User(username, password)));
        boolean logged = entityManager.userMapping.checkIfLogged(entityManager.getConnection());

        if (!logged)
        {
            loginMessageLabel.setText("Wrong username or password");
            return;
        }

        loginMessageLabel.setText("Successfully logged!");

        Parent registerPanelParent = FXMLLoader.load(getClass().getResource( "main_screen.fxml"));
        Scene registerPanelScene = new Scene(registerPanelParent);

        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(registerPanelScene);
        window.show();

    }

    public void registerButtonOnAction(ActionEvent event) throws IOException {

        Parent registerPanelParent = FXMLLoader.load(getClass().getResource( "register_panel.fxml"));
        Scene registerPanelScene = new Scene(registerPanelParent);

        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(registerPanelScene);
        window.show();

    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}