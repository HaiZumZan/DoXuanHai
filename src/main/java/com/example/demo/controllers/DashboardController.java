package com.example.demo.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
public class DashboardController implements Initializable {
@FXML
private Label lbChonkieunha;
@FXML
private ChoiceBox<String> btnChonKieunha;
@FXML
private ChoiceBox<String> btnThoihanthue;
private String[] kieunha = {" ", "Nhà mặt tiền","Phòng trọ"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
     btnChonKieunha.getItems().addAll(kieunha);
        btnKhuvuc.getItems().addAll(khuvuc);
        btnThoihanthue.getItems().addAll(thoihanthue);
        // Chọn lựa chọn đầu tiên là lựa chọn rỗng
        btnChonKieunha.getSelectionModel().selectFirst();
        btnKhuvuc.getSelectionModel().selectFirst();
        btnThoihanthue.getSelectionModel().selectFirst();
    }
    @FXML
    private ChoiceBox <String> btnKhuvuc;
    private String[]khuvuc={" ", "Quận Hải Châu", "Quận Thanh Khê", "Quận Ngũ Hành Sơn", "Quận Liên Chiểu", "Quận Cẩm Lệ","Quận Sơn Trà","Huyện đảo Hoàng Sa"};
private String[] thoihanthue = {" ", "3 tháng","6 tháng","1 năm","3 năm","5 năm"};

}

