module com.example.plattfotapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.plattfotapp to javafx.fxml;
    exports com.example.plattfotapp;
}