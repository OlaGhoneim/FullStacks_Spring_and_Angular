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
public class Car implements Vehicle {

    private int id;
    private String model;
    private Type type =Type.CAR;



    @Override
    public void setId(int id){
        this.id=id;
    }
    @Override
    public void setModel(String model){
        this.model=model;
    }
}
