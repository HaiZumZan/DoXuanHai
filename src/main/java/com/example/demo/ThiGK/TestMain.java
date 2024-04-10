package com.example.demo.ThiGK;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestMain {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            PrintWriter printWriter = new PrintWriter("C:/Users/ASUS/IdeaProjects/BTLCuoiKy/src/main/java/com/example/demo/ThiGK/GhiFile.txt");
            Bike bike = new Bike(1, "Nokia", 2020, 5.5, "red", 798);
            printWriter.println(bike.toString());
            printWriter.println();
            printWriter.flush();

            Car car = new Car(2,"Toyota",2024,555.5,"blue",4,"Max");
            printWriter.println(car.toString());
            printWriter.println();
            printWriter.flush();

            Truck truck = new Truck(3,"Suzuki", 2023,555.6,"black", 22.4);
            printWriter.println(truck.toString());
            printWriter.println();
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
