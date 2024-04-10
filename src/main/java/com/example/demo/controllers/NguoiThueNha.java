package com.example.demo.controllers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class NguoiThueNha {
    private static int sttCounter = 1;
    private int stt;
    private String id;
    private String name;
    private int sdt;
    private int socccd;
    private LocalDate ngayThue;
    private String kieuNha;
    private String khuVuc;
    private String thoihanThue;



    public NguoiThueNha( String id, String name, int sdt, int socccd, LocalDate ngayThue, String kieuNha, String khuVuc, String thoihanThue) {
        this.stt = sttCounter++;
        this.id=id;
        this.name = name;
        this.sdt = sdt;
        this.socccd = socccd;
        this.ngayThue = ngayThue;
        this.kieuNha = kieuNha;
        this.khuVuc = khuVuc;
        this.thoihanThue = thoihanThue;
    }

    public NguoiThueNha() {
        this.stt=sttCounter++;
    }

    public int getStt() {
        return this.stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public int getSocccd() {
        return socccd;
    }

    public LocalDate getNgaythue() {
        return ngayThue;
    }

    public void setNgaythue(LocalDate ngaythue) {
        this.ngayThue = ngaythue;
    }
public String getFormattedNgayThue(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return ngayThue.format(formatter);
}
    public void setSocccd(int socccd) {
        this.socccd = socccd;
    }

    public String getKieuNha() {
        return kieuNha;
    }

    public void setKieuNha(String kieuNha) {
        this.kieuNha = kieuNha;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getThoihanThue() {
        return thoihanThue;
    }

    public void setThoihanThue(String thoihanThue) {
        this.thoihanThue = thoihanThue;
    }
}