package com.example.demo;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class MainQuanLy extends Application {
    private static Scene scene;
    private static Stage stage;


    @Override
    public void start(Stage stage) throws Exception {
        stage = stage;

        Parent root =  loadFXML("DashboardFrm");
        scene = new Scene(root);
        stage.setTitle("QUẢN LÝ NHÀ CHO THUÊ");
        stage.setScene(scene);
        stage.show();

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainLogin.class.getResource(fxml + ".fxml"));
        return loader.load();
    }

    public static void setRoot(String fxml) throws IOException {
        Parent root = loadFXML(fxml);
        scene.setRoot(root);

//        stage.setWidth(root.prefWidth(600));
//       stage.setHeight(root.prefHeight(480));
    }

    public static void main(String[] args) {
        launch();
    }


}