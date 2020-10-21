package com.capgemini.workshop.ipl;

import com.opencsv.bean.CsvBindByName;

public class IPLPlayer {
    @CsvBindByName(column = "Player", required = true)
    private String playerName;

    @CsvBindByName(column = "Inns", required = true)
    private int innings;

    @CsvBindByName(column = "Runs", required = true)
    private int runs;

    @CsvBindByName(column = "Avg",required = true)
    private String average;

    @CsvBindByName(column = "SR", required = true)
    private double strikingRate;

    public IPLPlayer() {
    }

    public IPLPlayer(String playerName, int innings, int runs, String average, double strikingRate) {
        this.playerName = playerName;
        this.innings = innings;
        this.runs = runs;
        this.average = average;
        this.strikingRate = strikingRate;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public Double getAverage() {
        if (!average.equals("-"))
            return Double.parseDouble(average);
        return 0.0;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public double getStrikingRate() {
        return strikingRate;
    }

    public void setStrikingRate(double strikingRate) {
        this.strikingRate = strikingRate;
    }

}
