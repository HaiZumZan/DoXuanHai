module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires wagon.provider.api;


    opens com.example.demo to javafx.fxml;
    opens com.example.demo.controllers to javafx.fxml;

    exports com.example.demo;
    exports com.example.demo.controllers;
    exports com.example.demo.ThiGK;
    opens com.example.demo.ThiGK to javafx.fxml;
}