package com.example.f1_viewer.Classes;

public class Vozac {
    private String name;
    private String surname;
    private String number;
    private String team;

    public Vozac(String name, String surname, String number, String team) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
