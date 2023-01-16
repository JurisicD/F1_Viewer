package com.example.f1_viewer.Classes;

public class Driver {

    public String code,
            constructorId,
            dateOfBirth,
            driverId,
            familyName,
            givenName,
            nationality,
            permanentNumber,
            url;

    public Driver(){

    }

    public Driver(String code, String constructorId, String dateOfBirth, String driverId, String familyName,
                  String givenName, String nationality, String permanentNumber, String url) {
        this.code = code;
        this.constructorId = constructorId;
        this.dateOfBirth = dateOfBirth;
        this.driverId = driverId;
        this.familyName = familyName;
        this.givenName = givenName;
        this.nationality = nationality;
        this.permanentNumber = permanentNumber;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
