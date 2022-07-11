package com.example.plattfotapp.view;

import com.example.plattfotapp.controller.MedlemController;
import com.example.plattfotapp.model.Medlem;
import com.example.plattfotapp.server.Main;
import com.example.plattfotapp.server.MedlemDatabase;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddMedlem {
    public VBox addMedlem(){
        MedlemController medlemController = new MedlemController(new MedlemDatabase(new Main()));
        TextField fornavnTxt = new TextField();
        fornavnTxt.setPromptText("fornavn");
        TextField etternavnTxt = new TextField();
        etternavnTxt.setPromptText("etternavn");
        TextField adresseTxt = new TextField();
        adresseTxt.setPromptText("adresse");
        TextField telefonTxt = new TextField();
        telefonTxt.setPromptText("telefon");
        TextField epostTxt = new TextField();
        epostTxt.setPromptText("epost");
        Button add = new Button("add");
        add.setOnAction(e->
                medlemController
                        .addMedlem(
                                new Medlem(
                                        java.util.UUID.randomUUID().toString(),
                                        fornavnTxt.getText(),
                                        etternavnTxt.getText(),
                                        adresseTxt.getText(),
                                        telefonTxt. getText(),
                                        epostTxt.getText()
                                )
                        )
        );
        VBox vBox = new VBox();
        vBox.getChildren().addAll(fornavnTxt, etternavnTxt, adresseTxt,telefonTxt, epostTxt, add);
        return vBox;
    }
}
