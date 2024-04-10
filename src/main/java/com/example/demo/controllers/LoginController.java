package com.example.demo.controllers;

import com.example.demo.MainLogin;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;
    @FXML
    private RadioButton ntButton, nctButton;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void onClickCancel(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void initialize() {
        // Bắt sự kiện khi phím tắt được nhấn trong TextField
        txtUsername.setOnKeyPressed(this::handleKeyPress);
        pwPassword.setOnKeyPressed(this::handleKeyPress);

        // Bắt sự kiện khi phím tắt được nhấn trong nút Login
        btnLogin.setOnKeyPressed(this::handleKeyPress);
    }

    public void onClickLogin(ActionEvent event) throws IOException {
        String username = txtUsername.getText();
        String password = pwPassword.getText();
        if (username.isEmpty() || password.isEmpty()) {
            showErrorAlert("Tài khoản hoặc mật khẩu không được để trống");
            return;
        }

        if (username.equals("Hai") && password.equals("Hai1702")) {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            MainLogin mainLogin = new MainLogin();
            mainLogin.showUserScene(stage);
        } else {
            showErrorAlert("Sai thông tin đăng nhập!");

        }
    }

    private void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            // Xử lý khi phím Enter được nhấn
            try {
                onClickLogin(null); // Gọi phương thức xử lý đăng nhập
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi Đăng Nhập");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void luachon(ActionEvent actionEvent) {
    }
    public void initialize(Stage primaryStage) {
    }
}

