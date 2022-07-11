package com.example.plattfotapp;

import com.example.plattfotapp.controller.MedlemController;
import com.example.plattfotapp.model.Medlem;
import com.example.plattfotapp.server.Main;
import com.example.plattfotapp.server.MedlemDatabase;
import com.example.plattfotapp.view.AddMedlem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = new BorderPane();
        AddMedlem addMedlem = new AddMedlem();
        VBox vBox = addMedlem.addMedlem();
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane,600, 600);
        stage.setTitle("Plattfot turapplikasjon");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}