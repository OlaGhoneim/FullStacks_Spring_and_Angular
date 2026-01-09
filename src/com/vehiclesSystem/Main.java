package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controllers.BikeController;
import com.vehiclesSystem.controllers.CarController;
import com.vehiclesSystem.controllers.PlaneController;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        CarController carController = context.getBean(CarController.class);
        BikeController bikeController = context.getBean(BikeController.class);
        PlaneController planeController = context.getBean(PlaneController.class);


        carController.addVehicle("Toyota");
        bikeController.addVehicle("Yamaha");
        planeController.addVehicle("Boeing");



        List<Vehicle> allVehicles = carController.getAllVehicles();

        System.out.println("Stored Vehicles ");

        allVehicles.forEach(vehicle -> {
            System.out.println(
                    "ID -> " + vehicle.getId()
                            + " | Model -> " + vehicle.getModel()
                            + " | Type -> " + vehicle.getType()
            );
        });
        context.close();
    }
}
