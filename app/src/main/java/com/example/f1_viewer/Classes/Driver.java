package com.example.f1_viewer.Classes;
public class Driver {

    private String code;
    private String constructorId;
    private String dateOfBirth;
    private String familyName;
    private String givenName;
    private String nationality;
    private int permanentNumber;
    private int wins;
    private int podiums;
    private int poles;
    private String firstEntry;
    private String firstWin;
    private int numberOfTitles;
    private String picture;


    public Driver() {
    }

    public Driver(String code, String constructorId, String dateOfBirth, String familyName, String givenName, String nationality, int permanentNumber, int wins, int podiums, int poles, String firstEntry, String firstWin, int numberOfTitles, String picture) {
        this.code = code;
        this.constructorId = constructorId;
        this.dateOfBirth = dateOfBirth;
        this.familyName = familyName;
        this.givenName = givenName;
        this.nationality = nationality;
        this.permanentNumber = permanentNumber;
        this.wins = wins;
        this.podiums = podiums;
        this.poles = poles;
        this.firstEntry = firstEntry;
        this.firstWin = firstWin;
        this.numberOfTitles = numberOfTitles;
        this.picture = picture;
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPodiums() {
        return podiums;
    }

    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }

    public int getPoles() {
        return poles;
    }

    public void setPoles(int poles) {
        this.poles = poles;
    }

    public String getFirstEntry() {
        return firstEntry;
    }

    public void setFirstEntry(String firstEntry) {
        this.firstEntry = firstEntry;
    }

    public String getFirstWin() {
        return firstWin;
    }

    public void setFirstWin(String firstWin) {
        this.firstWin = firstWin;
    }

    public int getNumberOfTitles() {
        return numberOfTitles;
    }

    public void setNumberOfTitles(int numberOfTitles) {
        this.numberOfTitles = numberOfTitles;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}