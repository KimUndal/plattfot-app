package com.example.plattfotapp.server;
import com.example.plattfotapp.model.Medlem;

import java.sql.*;
import java.util.List;
import java.util.Objects;

public class Main{
    private static final String CREATE_KI = "CREATE TABLE IF NOT EXISTS KontigentInnbetaling(" +
            "id varchar(250) PRIMARY KEY NOT NULL," +
            "fornavn varchar(250)," +
            "etternavn varchar(250)," +
            "adresse varchar(250)," +
            "telefon varchar(250)," +
            "epost varchar(250))";
    private static final String CREATE_TD = "CREATE TABLE IF NOT EXISTS Turdeltagelse(" +
            "id varchar(250) PRIMARY KEY NOT NULL," +
            "fornavn varchar(250)," +
            "etternavn varchar(250)," +
            "adresse varchar(250)," +
            "telefon varchar(250)," +
            "epost varchar(250))";
    private static Connection connection = null;
    private static Statement statement = null;

    private static final String CREATE_MEDLEM = "CREATE TABLE IF NOT EXISTS Medlem(" +
            "id varchar(250) PRIMARY KEY NOT NULL," +
            "fornavn varchar(250)," +
            "etternavn varchar(250)," +
            "adresse varchar(250)," +
            "telefon varchar(250)," +
            "epost varchar(250))";



    private void createTabeller(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = connect();
            System.out.println("Database Openened... \n");

            statement = Objects.requireNonNull(connect()).createStatement();

            List<String> tables =List.of(CREATE_MEDLEM);
            for (String table: tables
                 ) {
                statement.executeUpdate(table);
                System.out.println("Tables that have been created!");
            }
            statement.close();
            connection.close();
            System.out.println("TABLE CREATED: " + Class.class.getName().toLowerCase());
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Connection connect() throws SQLException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        // db parameters
        // create a connection to the database
        return connection();

    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:plattfot.sqlite");
    }
}
