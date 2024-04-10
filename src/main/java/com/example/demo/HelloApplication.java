//package com.example.demo;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.chart.StackedAreaChart;
//import javafx.scene.control.Dialog;
//import javafx.stage.Stage;
//import javafx.scene.image.ImageView;
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    private static Scene scene;
//    private static Stage stage;
//
//
//
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        stage = stage;
//
//        Parent root =  loadFXML("LoginFrm");
//        scene = new Scene(root);
//        stage.setTitle("ĐĂNG NHẬP");
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
//        return loader.load();
//    }
//
//    public static void setRoot(String fxml) throws IOException {
//        Parent root = loadFXML(fxml);
//        scene.setRoot(root);
////
////        stage.setWidth(root.prefWidth(600));
////       stage.setHeight(root.prefHeight(480));
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//
//
//}