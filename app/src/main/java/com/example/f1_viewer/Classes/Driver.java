package com.example.f1_viewer.Classes;
public class Driver {

    public String code,constructorId ,dateOfBirth, driverId, familyName, givenName, nationality,permanentNumber;

    public Driver() {
    }

    public Driver(String code, String constructorId, String dateOfBirth, String driverId, String familyName, String givenName, String nationality, String permanentNumber) {
        this.code = code;
        this.dateOfBirth = dateOfBirth;
        this.driverId = driverId;
        this.familyName = familyName;
        this.givenName = givenName;
        this.nationality = nationality;
        this.permanentNumber = permanentNumber;
        this.constructorId = constructorId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(String permanentNumber) {
        this.permanentNumber = permanentNumber;
    }


    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }
}
