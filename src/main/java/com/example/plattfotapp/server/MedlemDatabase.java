package com.example.plattfotapp.server;

import com.example.plattfotapp.model.Medlem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedlemDatabase{
    private String select_sql = "SELECT * FROM MEDLEM ";
    private String addMember = "insert into Medlem(id, fornavn, etternavn, adresse, telefon, epost) values(?, ?, ?, ?, ?, ?)";
    private String deleteMember = "delete from medlem where id=?";
    private String endreMedlem = "update medlem set fornavn = ?, etternavn= ?, adresse = ?, telefon= ?, epost = ? where id=?";

    private final Main main;
    public MedlemDatabase(Main main) {
        this.main = main;
    }

    public void addMedlem(Medlem medlem){

        try {
            PreparedStatement pstm = main.connect().prepareStatement(addMember);
            pstm.setString(1, medlem.getId());
            pstm.setString(2, medlem.getFornavn());
            pstm.setString(3, medlem.getEtternavn());
            pstm.setString(4, medlem.getAdresse());
            pstm.setString(5, medlem.getTelefon());
            pstm.setString(6, medlem.getEpost());
            pstm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Medlem> getAllMedlem(){
        List<Medlem> allMedlem = new ArrayList<>();
        try {
            ResultSet rs = main.connect().prepareStatement(select_sql).executeQuery();
            while(rs.next()){
                allMedlem.add(
                        new Medlem(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6)
                        )
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return allMedlem;
    }

    public void deleteMedlem(String id){
        try {
             PreparedStatement pstm = main.connect().prepareStatement(deleteMember);
             pstm.setString(1, id);
             pstm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void editMedlem(Medlem medlem){
        try {
            PreparedStatement rs = main.connect().prepareStatement(endreMedlem);
            rs.setString(1, medlem.getFornavn());
            rs.setString(2, medlem.getEtternavn());
            rs.setString(3, medlem.getAdresse());
            rs.setString(4, medlem.getTelefon());
            rs.setString(5, medlem.getEpost());
            rs.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public Medlem sokByMedlem(Medlem medlem){
        Medlem hentMedlem = null;
        try {
            PreparedStatement preparedStatement = main.connect().prepareStatement(select_sql+ "where id = ?");
            preparedStatement.setString(1, medlem.getId());

            ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    hentMedlem = new Medlem(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)
                    );
                }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return hentMedlem;
    }
}
