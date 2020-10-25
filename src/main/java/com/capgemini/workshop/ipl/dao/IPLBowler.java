package com.capgemini.workshop.ipl.dao;

import com.opencsv.bean.CsvBindByName;

public class IPLBowler extends IPLPlayer {
	@CsvBindByName(column = "Player", required = true)
	private String name;

	@CsvBindByName(column = "Inns", required = true)
	private int innings;

	@CsvBindByName(column = "Runs", required = true)
	private int runs;

	@CsvBindByName(column = "Wkts", required = true)
	private int wicketsScored;

	@CsvBindByName(column = "Avg", required = true)
	private String average;

	@CsvBindByName(column = "Econ", required = true)
	private double economyRate;

	@CsvBindByName(column = "SR", required = true)
	private String strikingRate;

	@CsvBindByName(column = "4w", required = true)
	private int noOf4wTaken;

	@CsvBindByName(column = "5w", required = true)
	private int noOf5wTaken;

	public IPLBowler() {
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public Double getAverage() {
		if (!average.equals("-"))
			return Double.parseDouble(average);
		return Double.POSITIVE_INFINITY;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public int getWicketsScored() {
		return wicketsScored;
	}

	public void setWicketsScored(int wicketsScored) {
		this.wicketsScored = wicketsScored;
	}

	public double getEconomyRate() {
		return economyRate;
	}

	public void setEconomyRate(double economyRate) {
		this.economyRate = economyRate;
	}

	public Double getStrikingRate() {
		if (!strikingRate.equals("-"))
			return Double.parseDouble(strikingRate);
		return Double.POSITIVE_INFINITY;
	}

	public void setStrikingRate(String strikingRate) {
		this.strikingRate = strikingRate;
	}

	public int getNoOf4wTaken() {
		return noOf4wTaken;
	}

	public void setNoOf4wTaken(int noOf4wTaken) {
		this.noOf4wTaken = noOf4wTaken;
	}

	public int getNoOf5wTaken() {
		return noOf5wTaken;
	}

	public void setNoOf6wTaken(int noOf6wTaken) {
		this.noOf5wTaken = noOf6wTaken;
	}

}
