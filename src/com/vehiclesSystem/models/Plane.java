package com.vehiclesSystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.vehiclesSystem.dao.DatabaseOperations;
@Component
@Scope("prototype")
@Getter
@Setter
@ToString
public class Plane implements Vehicle {

    private int id;
    private String model;
    private Type type = Type.PLANE;



    public void setId(int id){
        this.id=id;
    }
    public void setModel(String model){
        this.model=model;
    }
}
