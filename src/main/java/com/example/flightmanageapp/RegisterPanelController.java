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

public class RegisterPanelController {

    @FXML
    private Button backButton;

    @FXML
    private TextField enterUsernameTextField;

    @FXML
    private PasswordField enterPasswordTextField;

    @FXML
    private PasswordField confirmPasswordTextField;

    @FXML
    private Label registerMessageLabel;

    public void registerButtonOnAction(ActionEvent event) throws IOException {

        String username = enterUsernameTextField.getText();
        String password = enterPasswordTextField.getText();
        String confirmedPassword = confirmPasswordTextField.getText();

        if (username.isBlank() || password.isBlank() || confirmedPassword.isBlank()) {
            registerMessageLabel.setText("Enter username and password");
            return;
        }

        if (!password.equals(confirmedPassword)) {
            registerMessageLabel.setText("Passwords must match!");
            return;
        }

        EntityManager entityManager = new EntityManager();
        entityManager.setConnection();
        entityManager.setUserMapping(new UserMapping(new User(username, password)));
        boolean registered = entityManager.userMapping.checkIfRegistered(entityManager.getConnection());

        if (!registered)
        {
            registerMessageLabel.setText("Error in connecting to the database");
            return;
        }

        registerMessageLabel.setText("Successfully registered!");

    }


    public void backButtonOnAction(ActionEvent event) throws IOException {

        Parent registerPanelParent = FXMLLoader.load(getClass().getResource( "login_panel.fxml"));
        Scene registerPanelScene = new Scene(registerPanelParent);

        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(registerPanelScene);
        window.show();
    }
}
