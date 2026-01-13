package System;

public class DatabaseOperator {
    private String url;
    private String username;
    private String password;


    public void setUrl(String url) {
        this.url = url;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void saveData(Vehicle vehicle) {
       System.out.println("Saving data for Vehicle brand: " + vehicle.getBrand());

    }

    public void connectToDatabase(){
        System.out.println("connection to database established ……");
    }
    public void disconnectFromDatabase(){
        System.out.println("connection to database closed…… " );
    }
}
