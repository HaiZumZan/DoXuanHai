package com.example.demo;

import com.example.demo.controllers.LoginController;
import com.example.demo.controllers.NguoiDungController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        showLoginScene(primaryStage);
    }

    private void showLoginScene(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            LoginController loginController = loader.getController();

            loginController.initialize(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Đăng nhập");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showUserScene(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NguoiDung.fxml"));
            Parent root = loader.load();
            NguoiDungController nguoiDungController = loader.getController();

            // Đặt đối tượng Stage cho Controller (nếu cần)
            nguoiDungController.initialize(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
