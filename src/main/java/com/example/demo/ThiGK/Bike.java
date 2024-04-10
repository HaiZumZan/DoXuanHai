package com.example.demo.ThiGK;

public class Bike  extends ICar {
    private double capacity;

    public Bike(int id, String brand, int publishYear, double price, String color, double capacity) {
        super(id, brand, publishYear, price, color);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return super.toString() + " Capacity: " + capacity;
    }
}
