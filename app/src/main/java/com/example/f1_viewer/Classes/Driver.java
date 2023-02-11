package com.example.f1_viewer.Classes;
public class Driver {

    private String code;                                // VER
    private String constructorId;                  // Red Bull Racing
    private String dateOfBirth;                    // 30.09.1997
    private String familyName;                   // Verstappen
    private String givenName;                    // Max
    private String nationality;                     // Belgium
    private int permanentNumber;            // 1
    private String picture;                         // gs://f1-viewer-a9c2a.appspot.com/drivers/verstappen.png

    public Driver(String code, String constructorId, String dateOfBirth, String familyName, String givenName, String nationality, int permanentNumber, String picture) {
        this.code = code;
        this.constructorId = constructorId;
        this.dateOfBirth = dateOfBirth;
        this.familyName = familyName;
        this.givenName = givenName;
        this.nationality = nationality;
        this.permanentNumber = permanentNumber;
        this.picture = picture;
    }

    public Driver() {
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

    public int getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(int permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}