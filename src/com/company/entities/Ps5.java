package com.company.entities;

import java.util.List;

public class Ps5 {
    int id;
    int gamesCount;
    List< String > Games;
    String sofa;
    String tvname;
    double resolution;
    int gamepadCount;
    int generation;
    int cost;
    int client_id;
    public Ps5(int id, int gamesCount, List < String > Games, String sofa, String tvname, double resolution, int gamepadCount, int generation, int cost, int client_id){
        this.cost = cost;
        this.client_id = client_id;
        this.id = id;
        this.gamesCount = gamesCount;
        this.Games = Games;
        this.sofa = sofa;
        this.tvname = tvname;
        this.resolution = resolution;
        this.gamepadCount = gamepadCount;
        this.generation = generation;
    }
    public Ps5(int gamesCount, List < String > Games, String sofa, String tvname, double resolution, int gamepadCount, int generation, int cost, int client_id){
        this.cost = cost;
        this.client_id = client_id;
        this.gamesCount = gamesCount;
        this.Games = Games;
        this.sofa = sofa;
        this.tvname = tvname;
        this.resolution = resolution;
        this.gamepadCount = gamepadCount;
        this.generation = generation;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGamepadCount(int gamepadCount) {
        this.gamepadCount = gamepadCount;
    }

    public void setGames(List<String> games) {
        Games = games;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public void setTvname(String tvname) {
        this.tvname = tvname;
    }

    public double getResolution() {
        return resolution;
    }

    public int getId() {
        return id;
    }

    public int getGamepadCount() {
        return gamepadCount;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public int getGeneration() {
        return generation;
    }

    public List<String> getGames() {
        return Games;
    }

    public String getSofa() {
        return sofa;
    }

    public String getTvname() {
        return tvname;
    }

    @Override
    public String toString() {
        return "Ps5 Info: " + '\n' +
                "Id = " + id + '\n' +
                "GamesCount = " + gamesCount + '\n' +
                "Games = " + Games + '\n' +
                "Sofa = " + sofa + '\n' +
                "Tvname = " + tvname + '\n' +
                "Resolution = " + resolution + '\n' +
                "GamepadCount = " + gamepadCount + '\n' +
                "Generation = " + generation + '\n' +
                "Cost = " + cost + '\n' +
                "-----------------------------------" + '\n';
    }
}
