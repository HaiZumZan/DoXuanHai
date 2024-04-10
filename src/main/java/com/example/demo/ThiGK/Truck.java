package com.example.demo.ThiGK;

public class Truck extends ICar {
    private double loadWeight;

    public Truck(int id, String brand, int publishYear, double price, String color, double loadWeight) {
        super(id, brand, publishYear, price, color);
        this.loadWeight = loadWeight;
    }

    public double getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(double loadWeight) {
        this.loadWeight = loadWeight;
    }

    @Override
    public String toString() {
        return super.toString() + " LoadWeight " + loadWeight;
    }
}
