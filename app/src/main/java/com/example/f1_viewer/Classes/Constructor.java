package com.example.f1_viewer.Classes;

public class Constructor {

    public String constructorId,
            name,
            nationality,
            url;

    public Constructor() {
    }

    public Constructor(String constructorId, String name, String nationality, String url) {
        this.constructorId = constructorId;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
