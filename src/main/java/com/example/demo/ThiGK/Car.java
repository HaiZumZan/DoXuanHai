package com.example.demo.ThiGK;

public class Car extends ICar {

    private int slots;
    private String engineType;

    public Car(int id, String brand, int publishYear, double price, String color, int slots, String engineType) {
        super(id, brand, publishYear, price, color);
        this.slots = slots;
        this.engineType = engineType;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return super.toString() + " Slots " + slots +" EngineType " + engineType;
    }
}


