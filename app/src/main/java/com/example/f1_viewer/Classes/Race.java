package com.example.f1_viewer.Classes;

import android.media.Image;

import java.util.List;

public class Race {

    private String trackImg;            // Slika staze
    private String country;             // Bahrain
    private String circuitName;         // Bahrain International Circuit
    private String raceDistance;        // 3.550 km
    private String round;               // Round 1 // Round 2 // Round 3...
    private String dateFromTo;          // 18-20 March
    private String numberOfLaps;        // 52
    private String lapRecorde;          // Lap Record: 1.35.455 Charles Leclerk(2018)
    private List<String> raceResult;    // 01 Lec,02 Sainz.....


    public Race(String trackImg, String country, String circuitName, String raceDistance, String round, String dateFromTo, String numberOfLaps, String lapRecorde, List<String> raceResult) {
        this.trackImg = trackImg;
        this.country = country;
        this.circuitName = circuitName;
        this.raceDistance = raceDistance;
        this.round = round;
        this.dateFromTo = dateFromTo;
        this.numberOfLaps = numberOfLaps;
        this.lapRecorde = lapRecorde;
        this.raceResult = raceResult;
    }


    public String getTrackImg() {
        return trackImg;
    }

    public void setTrackImg(String trackImg) {
        this.trackImg = trackImg;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public String getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(String raceDistance) {
        this.raceDistance = raceDistance;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getDateFromTo() {
        return dateFromTo;
    }

    public void setDateFromTo(String dateFromTo) {
        this.dateFromTo = dateFromTo;
    }

    public String getNumberOfLaps() {
        return numberOfLaps;
    }

    public void setNumberOfLaps(String numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    public String getLapRecorde() {
        return lapRecorde;
    }

    public void setLapRecorde(String lapRecorde) {
        this.lapRecorde = lapRecorde;
    }

    public List<String> getRaceResult() {
        return raceResult;
    }

    public void setRaceResult(List<String> raceResult) {
        this.raceResult = raceResult;
    }
}
