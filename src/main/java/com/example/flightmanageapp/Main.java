package com.example.flightmanageapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    final int SCENE_WIDTH = 520;
    final int SCENE_HEIGHT = 400;
    Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login_panel.fxml"));
        scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }}