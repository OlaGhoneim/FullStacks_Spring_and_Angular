package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
@Setter
public class DatabaseOperations {

    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;


    Connection con;

    @PostConstruct
    public void connectToDatabase(){

        try{
            con=DriverManager.getConnection(url, username, password);
            System.out.println("connecting to database established.....\n");
        }catch (SQLException ex) {
            System.err.println("Failed to connect to database");
            System.err.println(ex.getMessage());
        }
    }

    @PreDestroy
    public void disconnectFromDatabase(){
        try {
            if(con!= null && !con.isClosed()){
                con.close();
                System.out.println("connecting to database closed.....");
            }
        }catch(SQLException ex){
            System.err.println("Failed to disconnect from database");
            System.err.println(ex.getMessage());
        }
    }



    public void saveVehicle(Vehicle vehicle){
        String sql = "INSERT INTO vehicles (model, vehicle_type) VALUES (?, ?)";

        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, vehicle.getModel());
            st.setString(2, vehicle.getType().name());

            st.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to save vehicle", ex);
        }

    }



    public void updateVehicle(Vehicle vehicle){
        String sql = "UPDATE vehicles SET model = ? , vehicle_type = ?  WHERE id= ? ";
        try(PreparedStatement st = con.prepareStatement(sql)){
            st.setString(1, vehicle.getModel());
            st.setString(2, vehicle.getType().name());
            st.setInt(3, vehicle.getId());
            st.executeUpdate();
            System.out.println("Vehicle updated successfully!");
        }catch(SQLException ex){
            throw new RuntimeException("Failed to update vehicle", ex);
        }

    }




    public Vehicle searchById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String type = rs.getString("vehicle_type");
                Vehicle vehicle;

                if (type.equals("CAR")) {
                    vehicle = new Car();
                } else if (type.equals("Plane")) {
                    vehicle = new Plane();
                } else {
                    vehicle = new Bike();
                }
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));

                return vehicle;
            }} catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }




    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (PreparedStatement st=con.prepareStatement(sql)){
            ResultSet rs = st.executeQuery();


            while(rs.next()){
                String type=rs.getString("vehicle_type");
                Vehicle vehicle;

                if (type.equals("CAR")) {
                    vehicle = new Car();
                } else if (type.equals("Plane")) {
                    vehicle = new Plane();
                } else {
                    vehicle = new Bike();
                }

                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return vehicles;
    }



    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Vehicle deleted ");
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to delete ", ex);
        }
    }


}
