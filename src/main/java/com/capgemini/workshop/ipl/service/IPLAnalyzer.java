package com.capgemini.workshop.ipl.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.workshop.ipl.dao.IPLBatsman;
import com.capgemini.workshop.ipl.dao.IPLBowler;
import com.capgemini.workshop.ipl.dao.IPLPlayer;
import com.capgemini.workshop.ipl.dao.PlayerRepository;
import com.capgemini.workshop.ipl.exception.IPLAnalyzerException;

public class IPLAnalyzer {
	private PlayerRepository<IPLBatsman> batsmanRepo;
	private PlayerRepository<IPLBowler> bowlerRepo;

	private static <T> List<T> sortBy(final List<T> playersList, final Comparator<T> comparator, final int limit) {

		return playersList.stream().sorted(comparator).distinct().limit(limit).collect(Collectors.toList());

	}

	public IPLBatsman[] getTopBattingAverage(final int limit) {

		final List<IPLBatsman> sortedByAverage = sortBy(batsmanRepo.getPlayerList(),
				Comparator.comparing(IPLBatsman::getAverage).reversed(), limit);

		return sortedByAverage.toArray(new IPLBatsman[0]);
	}

	public void loadBattingData(final String filepath) throws IPLAnalyzerException {
		this.batsmanRepo = new PlayerRepository<>();
		try {
			this.batsmanRepo.build(filepath, IPLBatsman.class);
		} catch (final IPLAnalyzerException e) {
			throw new IPLAnalyzerException(e.getMessage());
		}
	}

	public IPLBatsman[] getTopStrikingRates(final int limit) {

		final List<IPLBatsman> sortedByStrikeRate = sortBy(batsmanRepo.getPlayerList(),
				Comparator.comparing(IPLBatsman::getStrikingRate).reversed(), limit);

		return sortedByStrikeRate.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getHighestFours(final int limit) {
		final List<IPLBatsman> sortedByFours = sortBy(batsmanRepo.getPlayerList(),
				Comparator.comparing(IPLBatsman::getNoOfFours).reversed(), limit);

		return sortedByFours.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getHighestSixes(final int limit) {
		final List<IPLBatsman> sortedBySixes = sortBy(batsmanRepo.getPlayerList(),
				Comparator.comparing(IPLBatsman::getNoOfSixes).reversed(), limit);

		return sortedBySixes.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getHighestStrikeRateWithFoursAndSixes(final int limit) {
		final Comparator<IPLBatsman> comparator = Comparator.comparing(IPLBatsman::getNoOfSixes)
				.thenComparing(IPLBatsman::getNoOfFours).thenComparing(IPLBatsman::getStrikingRate).reversed();

		final List<IPLBatsman> sortedList = sortBy(batsmanRepo.getPlayerList(), comparator, limit);

		return sortedList.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getBestAverageWithBestStrikeRate(final int limit) {
		final Comparator<IPLBatsman> comparator = Comparator.comparing(IPLBatsman::getAverage)
				.thenComparing(IPLBatsman::getStrikingRate).reversed();

		final List<IPLBatsman> sortedList = sortBy(batsmanRepo.getPlayerList(), comparator, limit);

		return sortedList.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getMaximumRunWithBestAvg(final int limit) {
		final Comparator<IPLBatsman> comparator = Comparator.comparing(IPLBatsman::getRunScored)
				.thenComparing(IPLBatsman::getAverage).reversed();

		final List<IPLBatsman> sortedList = sortBy(batsmanRepo.getPlayerList(), comparator, limit);

		return sortedList.toArray(new IPLBatsman[0]);
	}

	public void loadBowlingData(final String filepath) throws IPLAnalyzerException {
		this.bowlerRepo = new PlayerRepository<>();
		try {
			this.bowlerRepo.build(filepath, IPLBowler.class);
		} catch (final IPLAnalyzerException e) {
			throw new IPLAnalyzerException(e.getMessage());
		}
	}

	public IPLBowler[] getTopBowlingAvg(final int limit) {
		final List<IPLBowler> sortedList = sortBy(bowlerRepo.getPlayerList(),
				Comparator.comparing(IPLBowler::getAverage), limit);
		return sortedList.toArray(new IPLBowler[0]);
	}

	public IPLBowler[] getTopBowlingStrikingRate(final int limit) {
		final List<IPLBowler> sortedList = sortBy(bowlerRepo.getPlayerList(),
				Comparator.comparing(IPLBowler::getStrikingRate), limit);
		return sortedList.toArray(new IPLBowler[0]);
	}

	public IPLBowler[] getTopEconomyRate(final int limit) {
		final List<IPLBowler> sortedList = sortBy(bowlerRepo.getPlayerList(),
				Comparator.comparing(IPLBowler::getEconomyRate), limit);
		return sortedList.toArray(new IPLBowler[0]);
	}

	public IPLBowler[] getBestStrikeRateWith4wOr5w(final int limit) {
		final List<IPLBowler> filteredList = bowlerRepo.getPlayerList().stream()
				.filter(p -> p.getNoOf4wTaken() != 0 && p.getNoOf5wTaken() != 0).collect(Collectors.toList());
		final List<IPLBowler> sortedList = sortBy(filteredList, Comparator.comparing(IPLBowler::getStrikingRate),
				limit);
		return sortedList.toArray(new IPLBowler[0]);
	}

	public IPLBowler[] getBestStrikeRateWithGreatAvg(final int limit) {
		final Comparator<IPLBowler> comparator = Comparator.comparing(IPLBowler::getStrikingRate)
				.thenComparing(IPLBowler::getAverage);
		final List<IPLBowler> bowlerList = sortBy(bowlerRepo.getPlayerList(), comparator, limit);
		return bowlerList.toArray(new IPLBowler[0]);
	}

	public IPLBowler[] getMaxWktsAndBestAvg(final int limit) {
		final Comparator<IPLBowler> comparator = Comparator.comparing(IPLBowler::getWicketsScored).reversed()
				.thenComparing(IPLBowler::getAverage);
		final List<IPLBowler> bowlerList = sortBy(bowlerRepo.getPlayerList(), comparator, limit);
		return bowlerList.toArray(new IPLBowler[0]);
	}

	public IPLPlayer[] getBestBattingBowlingAvg(final int limit) {
		final List<IPLPlayer> allRounders = getAllRounders(batsmanRepo.getPlayerList(), bowlerRepo.getPlayerList());

		final Comparator<IPLPlayer> comparator = Comparator.comparing(IPLPlayer::getAverage).reversed()
				.thenComparing(IPLPlayer::getAverage);
		final List<IPLPlayer> sortedAllRounders = sortBy(allRounders, comparator, limit);
		return sortedAllRounders.toArray(new IPLPlayer[0]);
	}

	private List<IPLPlayer> getAllRounders(final List<IPLBatsman> batsmans, final List<IPLBowler> bowlers) {
		final Set<IPLPlayer> iplBatsman = new HashSet<>(batsmans);
		final Set<IPLPlayer> iplBowlers = new HashSet<>(bowlers);
		iplBatsman.retainAll(iplBowlers); // intersection
		final List<IPLPlayer> allRounders = new ArrayList<>(iplBatsman);
		return allRounders;
	}

	public IPLPlayer[] getBestAllRounders() {
		final List<IPLBatsman> sortedByRunBatsmans = sortBy(batsmanRepo.getPlayerList(),
				Comparator.comparing(IPLBatsman::getRunScored).reversed(), 20);

		final List<IPLBowler> sortedByWktsBowlers = sortBy(bowlerRepo.getPlayerList(),
				Comparator.comparing(IPLBowler::getWicketsScored).reversed(), 20);

		final List<IPLPlayer> allRounders = getAllRounders(sortedByRunBatsmans, sortedByWktsBowlers);

		return allRounders.toArray(new IPLPlayer[0]);
	}

	public IPLBatsman[] getMaxHundredsBestAvg() {
		final Comparator<IPLBatsman> comparator = Comparator.comparing(IPLBatsman::getHundredsScored)
				.thenComparing(IPLBatsman::getAverage).reversed();

		final List<IPLBatsman> sortedBatsmanList = sortBy(batsmanRepo.getPlayerList(), comparator, 5);
		return sortedBatsmanList.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getBestAvgWithZeroFiftiesAndHundreds() {
		final List<IPLBatsman> filteredList = batsmanRepo.getPlayerList().stream()
				.filter(p -> (p.getFiftiesScored() == 0 && p.getHundredsScored() == 0)).collect(Collectors.toList());

		final List<IPLBatsman> sortedList = sortBy(filteredList,
				Comparator.comparing(IPLBatsman::getAverage).reversed(), 5);
		return sortedList.toArray(new IPLBatsman[0]);
	}

};