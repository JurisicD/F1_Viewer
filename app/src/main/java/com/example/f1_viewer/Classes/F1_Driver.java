package com.example.f1_viewer.Classes;

import java.util.Date;

public class F1_Driver {

    private String driverId;
    private Integer carNumber;
    private String code; // VER- prezime u 3 slova
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String nationality;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public F1_Driver(String driverId, Integer carNumber, String code, String name, String surname, Date dateOfBirth, String nationality) {
        this.driverId = driverId;
        this.carNumber = carNumber;
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }
}
