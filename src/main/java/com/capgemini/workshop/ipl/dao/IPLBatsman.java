package com.capgemini.workshop.ipl.dao;

import com.opencsv.bean.CsvBindByName;

public class IPLBatsman extends IPLPlayer {
    @CsvBindByName(column = "Player", required = true)
    private String playerName;

    @CsvBindByName(column = "Inns", required = true)
    private int innings;

    @CsvBindByName(column = "Runs", required = true)
    private int runScored;

    @CsvBindByName(column = "Avg", required = true)
    private String average;

    @CsvBindByName(column = "SR", required = true)
    private double strikingRate;

    @CsvBindByName(column = "4s", required = true)
    private int noOfFours;

    @CsvBindByName(column = "6s", required = true)
    private int noOfSixes;

    @CsvBindByName(column = "100", required = true)
    private int hundredsScored;

    @CsvBindByName(column = "50", required = true)
    private int fiftiesScored;

    public IPLBatsman() {
    }

    @Override
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

    @Override
    public Double getAverage() {
        if (!average.equals("-"))
            return Double.parseDouble(average);
        return Double.NEGATIVE_INFINITY;
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

    public int getNoOfFours() {
        return noOfFours;
    }

    public void setNoOfFours(int noOfFours) {
        this.noOfFours = noOfFours;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }

    public void setNoOfSixes(int noOfSixes) {
        this.noOfSixes = noOfSixes;
    }

    public int getRunScored() {
        return runScored;
    }

    public void setRunScored(int runScored) {
        this.runScored = runScored;
    }

    public int getHundredsScored() {
        return hundredsScored;
    }

    public void setHundredsScored(int hundredsScored) {
        this.hundredsScored = hundredsScored;
    }

    public int getFiftiesScored() {
        return fiftiesScored;
    }

    public void setFiftiesScored(int fiftiesScored) {
        this.fiftiesScored = fiftiesScored;
    }

}
