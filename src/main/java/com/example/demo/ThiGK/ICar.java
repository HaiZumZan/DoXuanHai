package com.example.demo.ThiGK;

public class ICar {
    private int id;
    private String brand;
    private int publishYear;
    private double price;
    private String color;

    public ICar(int id, String brand, int publishYear, double price, String color) {
        this.id = id;
        this.brand = brand;
        this.publishYear = publishYear;
        this.price = price;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void showInfo(){

    }

    @Override
    public String toString() {
        return "ICar{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", publishYear=" + publishYear +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
