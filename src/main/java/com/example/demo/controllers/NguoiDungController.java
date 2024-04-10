package com.example.demo.controllers;

import com.example.demo.MainNguoiDung;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

import javafx.application.HostServices;
import java.io.File;
import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.scene.control.DatePicker;




public class NguoiDungController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private TableView<NguoiThueNha> table;

@FXML
private TableColumn<NguoiThueNha, Integer> sttColumn;
@FXML
private TableColumn<NguoiThueNha, String> idColumn;
    @FXML
    private TableColumn<NguoiThueNha, String> nameColumn;
    @FXML
    private TableColumn<NguoiThueNha, Integer> phoneColumn;
    @FXML
    private TableColumn<NguoiThueNha, Integer> cccdColumn;
    @FXML
    private TableColumn<NguoiThueNha, LocalDate> ngaythueColumn;
    @FXML
    private TableColumn<NguoiThueNha, String> housetypeColumn;
    @FXML
    private TableColumn<NguoiThueNha, String> areaColumn;
    @FXML
    private TableColumn<NguoiThueNha, String> durationColumn;
    private ObservableList<NguoiThueNha> personList = FXCollections.observableArrayList();


    @FXML
    private TextField idText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField phoneText;
    @FXML
    private TextField cccdText;
    @FXML
    private DatePicker mydatePicker;
    @FXML
    private ChoiceBox<String> housetypeBtn;
    @FXML
    private ChoiceBox<String> areaBtn;
    @FXML
    private ChoiceBox<String> durationBtn;

    private HostServices hostServices;
    private Set<String> idSet = new HashSet<>();
    private Stage primaryStage; // Lưu trữ đối tượng Stage chính

    // Phương thức setter cho đối tượng Stage chính
    public void initialize(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
    }
private Connection connection;
public NguoiDungController(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quanlynhachothue?user=root&password=123456789");
        System.out.println("Kết nối thành công");
    }catch (Exception e){
        e.printStackTrace();
    }
}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        // Thêm kiểu nhà cho housetypeBtn
        housetypeBtn.getItems().addAll("", "Nhà mặt tiền", "Căn hộ cao cấp", "Nhà trong hẻm", "Phòng trọ");
        housetypeBtn.setValue("Kiểu nhà");
        // Thêm quận cho areaBtn
        areaBtn.getItems().addAll("", "Quận Thanh Khê", "Quận Hải Châu", "Quận Sơn Trà", "Quận Liên Chiểu", "Quận Ngũ Hành Sơn", "Quận Cẩm Lệ");
        areaBtn.setValue("Khu vực");
        // Thêm thời hạn thuê cho durationBtn
        durationBtn.getItems().addAll("", "3 tháng", "6 tháng", "1 năm", "2 năm", "3 năm", "5 năm");
        durationBtn.setValue("Thời hạn thuê");

        // Bắt sự kiện cho housetypeBtn
        housetypeBtn.setOnAction(event -> handleChoiceBoxSelection(housetypeBtn));

        // Bắt sự kiện cho areaBtn
        areaBtn.setOnAction(event -> handleChoiceBoxSelection(areaBtn));

        // Bắt sự kiện cho durationBtn
        durationBtn.setOnAction(event -> handleChoiceBoxSelection(durationBtn));

        table.setOnMouseClicked(mouseEvent -> showSelectedUserInfo());
        sttColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha,Integer>("stt"));
        idColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, String>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, Integer>("sdt"));
        cccdColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, Integer>("socccd"));
        ngaythueColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, LocalDate>("formattedNgayThue"));
        housetypeColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, String>("kieuNha"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, String>("khuVuc"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<NguoiThueNha, String>("thoihanThue"));

        showCSDL();

        table.setItems(personList);
    }


    @FXML
    private void themVaoBang(ActionEvent event) {
        if (nameText.getText().isEmpty() || phoneText.getText().isEmpty() || cccdText.getText().isEmpty() ||
                housetypeBtn.getValue().isEmpty() || areaBtn.getValue().isEmpty() || durationBtn.getValue().isEmpty()) {
            hienThongBaoLoi("Vui lòng điền đầy đủ thông tin.");
            return;
        }
        String newID = idText.getText();
        if (idSet.contains(newID)) {
            hienThongBaoLoi("Mã người thuê đã tồn tại. Vui lòng nhập mã khác.");
            return;
        }
        NguoiThueNha newNguoiThueNha = new NguoiThueNha();


        newNguoiThueNha.setId(newID);
        newNguoiThueNha.setId((idText.getText()));
        newNguoiThueNha.setName(nameText.getText());
        newNguoiThueNha.setSdt(Integer.parseInt(phoneText.getText()));
        newNguoiThueNha.setSocccd(Integer.parseInt(cccdText.getText()));
        newNguoiThueNha.setKieuNha(housetypeBtn.getValue());
        newNguoiThueNha.setKhuVuc(areaBtn.getValue());
        newNguoiThueNha.setThoihanThue(durationBtn.getValue());
        LocalDate ngayThue = mydatePicker.getValue();

        newNguoiThueNha.setNgaythue(ngayThue);
        try {
            // Insert data into the database
            String sql = "INSERT INTO danhsachnguoithue (MaNguoiThue, HoTen, SoDienThoai, SoCCCD, NgayThue, KieuNha, KhuVucThue, ThoiHanThue) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, newNguoiThueNha.getId());
                statement.setString(2, newNguoiThueNha.getName());
                statement.setInt(3, newNguoiThueNha.getSdt());
                statement.setInt(4, newNguoiThueNha.getSocccd());
                statement.setDate(5, Date.valueOf(newNguoiThueNha.getNgaythue()));
                statement.setString(6, newNguoiThueNha.getKieuNha());
                statement.setString(7, newNguoiThueNha.getKhuVuc());
                statement.setString(8, newNguoiThueNha.getThoihanThue());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            int phone = Integer.parseInt(phoneText.getText());
            newNguoiThueNha.setSdt(phone);
        } catch (NumberFormatException e) {
            hienThongBaoLoi("Vui lòng nhập số điện thoại là một số nguyên.");
            return;
        }

        // Kiểm tra và xử lý số CCCD
        try {
            int cccd = Integer.parseInt(cccdText.getText());
            newNguoiThueNha.setSocccd(cccd);
        } catch (NumberFormatException e) {
            hienThongBaoLoi("Vui lòng nhập số CCCD là một số nguyên.");
            return;
        }
        idSet.add(newID);
        // Tạo một đối tượng Person mới và thêm vào danh sách

        personList.add(newNguoiThueNha);


        updateTableView();
    }

    public void xoaBang(ActionEvent event) {
        NguoiThueNha selected = table.getSelectionModel().getSelectedItem();
        personList.remove(selected);
        try {
            String sql = "DELETE FROM danhsachnguoithue WHERE MaNguoiThue = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, selected.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }


    private void hienThongBaoLoi(String thongbao) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(thongbao);
        alert.showAndWait();
    }

    private void updateTableView() {
        showCSDL();
        table.setItems(personList);
        table.refresh();
    }

    private void handleChoiceBoxSelection(ChoiceBox<String> choiceBox) {
        String selectedValue = choiceBox.getValue();
        if (selectedValue == null || selectedValue.isEmpty()) {
            choiceBox.setValue("Kiểu nhà");
            if (choiceBox == areaBtn) {
                choiceBox.setValue("Khu vực");
            } else if (choiceBox == durationBtn) {
                choiceBox.setValue("Thời hạn thuê");
            }
        } else {
        }
    }

    private void showSelectedUserInfo() {
        NguoiThueNha selectedUser = table.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            // Hiển thị thông tin trong các controls

            idText.setText(selectedUser.getId());
            nameText.setText(selectedUser.getName());
            phoneText.setText(String.valueOf(selectedUser.getSdt()));
            cccdText.setText(String.valueOf(selectedUser.getSocccd()));
            mydatePicker.setValue(selectedUser.getNgaythue());
            housetypeBtn.setValue(selectedUser.getKieuNha());
            areaBtn.setValue(selectedUser.getKhuVuc());
            durationBtn.setValue(selectedUser.getThoihanThue());
        }
    }


    public void capnhatUser(ActionEvent event) {
// Lấy người dùng được chọn từ bảng
        NguoiThueNha selectedUser = table.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            // Cập nhật thông tin của người dùng được chọn với các giá trị mới từ các controls
            selectedUser.setId((idText.getText()));
            selectedUser.setName(nameText.getText());
            selectedUser.setSdt(Integer.parseInt(phoneText.getText()));
            selectedUser.setSocccd(Integer.parseInt(cccdText.getText()));
            selectedUser.setNgaythue(mydatePicker.getValue());
            selectedUser.setKieuNha(housetypeBtn.getValue());
            selectedUser.setKhuVuc(areaBtn.getValue());
            selectedUser.setThoihanThue(durationBtn.getValue());
            int rowsUpdate;
            String sql = "UPDATE danhsachnguoithue SET MaNguoiThue = ?, HoTen = ?, SoDienThoai = ?, SoCCCD = ?, NgayThue = ?, KieuNha = ?, KhuVucThue = ?, ThoiHanThue = ? WHERE MaNguoiThue = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, selectedUser.getId());
                statement.setString(2, selectedUser.getName());
                statement.setInt(3, selectedUser.getSdt());
                statement.setInt(4,selectedUser.getSocccd());
                statement.setDate(5, Date.valueOf(selectedUser.getNgaythue()));
                statement.setString(6, selectedUser.getKieuNha());
                statement.setString(7, selectedUser.getKhuVuc());
                statement.setString(8, selectedUser.getThoihanThue());
                statement.setString(9, selectedUser.getId()); // WHERE condition

rowsUpdate = statement.executeUpdate();
                if (rowsUpdate > 0) {
                    System.out.println("Thông tin người dùng đã được cập nhật thành công.");
                } else {
                    System.out.println("Không có thông tin người dùng nào được cập nhật.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            table.refresh();
        } else {
            // Xử lý trường hợp khi không có người dùng nào được chọn
            hienThongBaoLoi("Vui lòng chọn một người dùng để cập nhật thông tin.");
        }
        }
        // Xuất hợp đồng
        public void xuatHopDong(ActionEvent event){
            Stage stage = (Stage)ap.getScene().getWindow();
            String contractFilePath = "C:\\Users\\ASUS\\IdeaProjects\\BTLCuoiKy\\src\\main\\resources\\com\\example\\demo\\Hop_dong_thue_nha.doc";
            File contractFile = new File(contractFilePath);
            if (contractFile.exists()){
                String fileURL = contractFile.toURI().toString();
                MainNguoiDung.hostServices.showDocument(fileURL);
            }else{
            }
        }
        public void showCSDL(){
            try {
                personList.clear(); // Xóa dữ liệu hiện tại để tránh trùng lặp

                String sql = "SELECT * FROM danhsachnguoithue";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        NguoiThueNha nguoiThueNha = new NguoiThueNha();
                        nguoiThueNha.setId(resultSet.getString("MaNguoiThue"));
                        nguoiThueNha.setName(resultSet.getString("HoTen"));
                        nguoiThueNha.setSdt(resultSet.getInt("SoDienThoai"));
                        nguoiThueNha.setSocccd(resultSet.getInt("SoCCCD"));
                        nguoiThueNha.setNgaythue(resultSet.getDate("NgayThue").toLocalDate());
                        nguoiThueNha.setKieuNha(resultSet.getString("KieuNha"));
                        nguoiThueNha.setKhuVuc(resultSet.getString("KhuVucThue"));
                        nguoiThueNha.setThoihanThue(resultSet.getString("ThoiHanThue"));

                        personList.add(nguoiThueNha);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}
