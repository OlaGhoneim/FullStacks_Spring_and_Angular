package com.vehiclesSystem.controllers;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BikeController implements com.vehiclesSystem.controllers.VehicleController {


    @Autowired
    private DatabaseOperations dao;


    @Override
    public void addVehicle(String model) {
        Bike bike=new Bike();
        bike.setModel(model);
        dao.saveVehicle(bike);
    }

    @Override
    public void deleteVehicle(int id) {
        dao.deleteVehicle(id);
    }

    @Override
    public void updateVehicle(int id, String model) {
        Bike bike=new Bike();
        bike.setId(id);
        bike.setModel(model);
        dao.updateVehicle(bike);
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
