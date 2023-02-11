package com.example.f1_viewer.Classes;

import java.util.List;

public class Team {

    private int constructorId;                                  // 1
    private List<String> drivers;                           // [0]-> Max Verstappen,  [1]-> Sergio Perez
    private String name;                                    // Red Bull Racing
    private String nationality;                             // Milton Keynes, United Kingdom
    private double points;                                  // 10
    private String teamCarImg;                          // gs://f1-viewer-a9c2a.appspot.com/cars/redbull.png
    private String teamLogoImg;                          //  gs://f1-viewer-a9c2a.appspot.com/logos/redbull_logo.png

    public Team() {
    }
    public Team(int constructorId, List<String> drivers, String name, String nationality, double points, String teamCarImg, String teamLogoImg) {
        this.constructorId = constructorId;
        this.drivers = drivers;
        this.name = name;
        this.nationality = nationality;
        this.points = points;
        this.teamCarImg = teamCarImg;
        this.teamLogoImg = teamLogoImg;
    }



    public int getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(int constructorId) {
        this.constructorId = constructorId;
    }

    public List<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<String> drivers) {
        this.drivers = drivers;
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

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getTeamCarImg() {
        return teamCarImg;
    }

    public void setTeamCarImg(String teamCarImg) {
        this.teamCarImg = teamCarImg;
    }

    public String getTeamLogoImg() {
        return teamLogoImg;
    }

    public void setTeamLogoImg(String teamLogoImg) {
        this.teamLogoImg = teamLogoImg;
    }
}

