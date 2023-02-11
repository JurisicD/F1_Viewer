package com.example.f1_viewer.Classes;

import android.media.Image;

import java.util.List;

public class Race {

    private String circuitName;                        // FORMULA 1 GULF AIR BAHRAIN GRAND PRIX
    private String country;                               // Bahrain
    private String dateFromTo;                       // 03-05 MAR
    private String lapRecord;                          // 1:31.447 Pedro de la Rosa (2005)
    private int numberOfLaps;                       // 57
    private double raceDistance;                   // 308.238  --> km
    private String round;                               // Round 1
    private double trackDistance;                 // 5.412  --> km
    private String trackImg;                          // gs://f1-viewer-a9c2a.appspot.com/races/bahrain_international_circuit.png
    private String trackName;                       // Bahrain International Circuit

    public Race() {
    }

    public Race(String circuitName, String country, String dateFromTo, String lapRecord, int numberOfLaps, double raceDistance, String round, double trackDistance, String trackImg, String trackName) {
        this.circuitName = circuitName;
        this.country = country;
        this.dateFromTo = dateFromTo;
        this.lapRecord = lapRecord;
        this.numberOfLaps = numberOfLaps;
        this.raceDistance = raceDistance;
        this.round = round;
        this.trackDistance = trackDistance;
        this.trackImg = trackImg;
        this.trackName = trackName;
    }


    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateFromTo() {
        return dateFromTo;
    }

    public void setDateFromTo(String dateFromTo) {
        this.dateFromTo = dateFromTo;
    }

    public String getLapRecord() {
        return lapRecord;
    }

    public void setLapRecord(String lapRecord) {
        this.lapRecord = lapRecord;
    }

    public int getNumberOfLaps() {
        return numberOfLaps;
    }

    public void setNumberOfLaps(int numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    public double getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(double raceDistance) {
        this.raceDistance = raceDistance;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public double getTrackDistance() {
        return trackDistance;
    }

    public void setTrackDistance(double trackDistance) {
        this.trackDistance = trackDistance;
    }

    public String getTrackImg() {
        return trackImg;
    }

    public void setTrackImg(String trackImg) {
        this.trackImg = trackImg;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}
