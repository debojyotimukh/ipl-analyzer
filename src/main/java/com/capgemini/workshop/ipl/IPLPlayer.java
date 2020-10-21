package com.capgemini.workshop.ipl;

import com.opencsv.bean.CsvBindByName;

public class IPLPlayer {
    @CsvBindByName(column = "Player",required = true)
    private String playerName;

    @CsvBindByName(column = "Inns",required = true)
    private int innings;

    @CsvBindByName(column="Runs",required = true)
    private int runs;

    @CsvBindByName(column="Avg")
    private String average;

    public IPLPlayer() {
    }

    public IPLPlayer(String playerName, int innings, int runs, String average) {
        this.playerName = playerName;
        this.innings = innings;
        this.runs = runs;
        this.average = average;
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
        if(!average.equals("-"))
            return Double.parseDouble(average);
        return 0.0;
    }

    public void setAverage(String average) {
        this.average=average;
    }

}
