package com.example.demo.DAO2;

import com.example.demo.ThiGK.Bike;

import java.sql.*;


public class DAO2 {
    private Connection connection;
    public DAO2(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/khachhang?user=root&password=123456789");
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addBike(Bike bike) {
        String query = "INSERT INTO Bike (id, brand, publishYear, price, color, capacity)" +"VALUES (?,?,?,?,?,?)";

    }

    public static void main(String[] args) {
        new DAO2();
    }

}
