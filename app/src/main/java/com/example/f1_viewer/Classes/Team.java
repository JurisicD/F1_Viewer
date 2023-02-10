package com.example.f1_viewer.Classes;

import java.util.List;

public class Team {

    private String constructorId;
    private String name;
    private String nationality;
    private String points;
    public List<String> drivers;


    public Team(String constructorId, String name, String nationality, String points,List<String> drivers) {
        this.constructorId = constructorId;
        this.name = name;
        this.nationality = nationality;
        this.points = points;
        this.drivers = drivers;
    }


    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public List<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<String> drivers) {
        this.drivers = drivers;
    }
}

