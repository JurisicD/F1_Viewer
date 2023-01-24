package com.example.f1_viewer.Classes;

import java.util.List;

public class Race {

    public List<Races> racesList;

    private class Races{
        private List<Circuit> CircuitsList;
        private List<FirstPractice> firstPracticeList;
        private List<SecondPractice> secondPracticeList;
        private List<ThirdPractice> thirdPracticeList;
        private List<Qualifying> qualifyingList;
        private String date,
                raceName,
                round,season,
                time,
                url;

    }

    private class Circuit{
        private List<Location> locationList;
        private String circuitId,
                circuitName,
                url;
    }

    private class Location{
        private String country,
                lat,
                locality,
                _long;
    }

    private class FirstPractice{
        private String date,
                time;
    }

    private class SecondPractice{
        private String date,
                time;
    }

    private class ThirdPractice{
        private String date,
                time;
    }

    private class Qualifying{
        private String date,
                time;
    }


    public Race(List<Races> racesList) {
        this.racesList = racesList;
    }


    public List<Races> getRacesList() {
        return racesList;
    }

    public void setRacesList(List<Races> racesList) {
        this.racesList = racesList;
    }
}
