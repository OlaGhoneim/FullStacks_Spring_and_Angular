package com.vehiclesSystem.controllers;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vehiclesSystem.controllers.VehicleController;
import java.util.List;

@Component
public class PlaneController implements VehicleController {

    private final DatabaseOperations dao;

    @Autowired
    public PlaneController(DatabaseOperations dao) {
        this.dao = dao;
    }

    @Override
    public Vehicle searchById(int id) {
        System.out.println(" Searching car...");
        return dao.searchById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return dao.getAllVehicles();
    }



    @Override
    public void addVehicle(String model){
        Plane plane=new Plane();
        plane.setModel(model);
        dao.saveVehicle(plane);
    }

    @Override
    public void deleteVehicle(int id) {
        System.out.println(" Deleting car...");
        dao.deleteVehicle(id);
    }

    @Override
    public void updateVehicle(int id, String model) {
        Plane plane=new Plane();
        plane.setId(id);
        plane.setModel(model);
        dao.updateVehicle(plane);
    }
}
