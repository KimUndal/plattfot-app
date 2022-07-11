package com.example.plattfotapp.controller;

import com.example.plattfotapp.model.Medlem;
import com.example.plattfotapp.server.MedlemDatabase;

import java.util.List;

public class MedlemController {
    private final MedlemDatabase medlemDatabase;

    public MedlemController(MedlemDatabase medlemDatabase) {
        this.medlemDatabase = medlemDatabase;
    }

    //add
    public boolean addMedlem(Medlem medlem){
        if(medlem != null){
            medlemDatabase.addMedlem(medlem);
            return true;
        }
        return false;
    }
    //get all

    public List<Medlem> getAllMedlem(){
        return medlemDatabase.getAllMedlem();
    }
}
