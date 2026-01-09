package com.vehiclesSystem.controllers;

import com.vehiclesSystem.models.Vehicle;

import java.util.List;

public interface VehicleController {
    void addVehicle(String model);
    void deleteVehicle(int id);
    void updateVehicle(int id, String model);
    Vehicle searchById(int id);
    List<Vehicle> getAllVehicles();
}
