package com.vehiclesSystem.controllers;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarController implements com.vehiclesSystem.controllers.VehicleController {

    private DatabaseOperations dao;


    @Autowired
    public CarController(DatabaseOperations dao){
        this.dao=dao;
    }


    @Override
    public void addVehicle(String model) {
        Car car=new Car();
        car.setModel(model);
        dao.saveVehicle(car);
    }

    @Override
    public void deleteVehicle(int id) {
        dao.deleteVehicle(id);
    }

    @Override
    public void updateVehicle(int id, String model) {
        Car car=new Car();
        car.setId(id);
        car.setModel(model);
        dao.updateVehicle(car);
    }

    @Override
    public Vehicle searchById(int id) {
        return dao.searchById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return dao.getAllVehicles();
    }

}
