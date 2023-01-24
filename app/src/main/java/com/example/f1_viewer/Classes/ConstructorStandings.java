package com.example.f1_viewer.Classes;

import java.util.List;

public class ConstructorStandings {

    public List<Constructor> teamList;
    public String points, position, positionText, wins;

    public ConstructorStandings() {
    }

    public ConstructorStandings(List<Constructor> teamList, String points, String position, String positionText, String wins) {
        this.teamList = teamList;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
    }

    public List<Constructor> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Constructor> teamList) {
        this.teamList = teamList;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }
}
