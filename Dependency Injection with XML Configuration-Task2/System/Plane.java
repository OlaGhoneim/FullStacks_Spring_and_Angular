package System;

public class Plane implements Vehicle {

    private DatabaseOperator database;
    private String name;
    private String brand;

    public void setDatabase(DatabaseOperator database) {
        this.database = database;
    }

    @Override
    public void saveData() {
        database.saveData(this);
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }
}
