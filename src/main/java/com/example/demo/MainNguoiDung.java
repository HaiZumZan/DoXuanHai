package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.application.HostServices;
import java.io.IOException;
import java.sql.Connection;

public class MainNguoiDung extends Application {

    public static HostServices hostServices;
    private static Scene scene;
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        hostServices = getHostServices();
        scene = scene;
        stage = stage;
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("NguoiDung.fxml"));

        // Set up the primary stage
        primaryStage.setTitle("QUẢN LÝ");
        primaryStage.setScene(new Scene(root, 1340, 625));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }


}