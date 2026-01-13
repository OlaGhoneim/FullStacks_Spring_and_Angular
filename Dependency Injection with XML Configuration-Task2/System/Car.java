package System;

public class Car implements Vehicle {

    private DatabaseOperator database;
    private String name;
    private String brand;

    public Car(DatabaseOperator databaseOperator) {
        database = databaseOperator;
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
