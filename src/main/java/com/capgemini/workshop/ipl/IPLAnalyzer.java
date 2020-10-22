package com.capgemini.workshop.ipl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyzer {
	private PlayerRepository<IPLBatsman> batsman;

	private static <T> List<T> sortBy(final List<T> playersList, final Comparator<T> comparator, final int limit) {

		return playersList.stream().sorted(comparator).distinct().limit(limit).collect(Collectors.toList());

	}

	public IPLBatsman[] getTopBattingAverage(final int limit) {

		final List<IPLBatsman> sortedByAverage = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLBatsman::getAverage).reversed(), limit);

		return sortedByAverage.toArray(new IPLBatsman[0]);
	}

	public void loadBattingData(final String filepath) {
		this.batsman = new PlayerRepository<>();
		try {
			this.batsman.build(filepath, IPLBatsman.class);
		} catch (final IPLAnalyzerException e) {
			e.getMessage();
		}
	}

	public IPLBatsman[] getTopStrikingRates(final int limit) {

		final List<IPLBatsman> sortedByStrikeRate = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLBatsman::getStrikingRate).reversed(), limit);

		return sortedByStrikeRate.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getHighestFours(final int limit) {
		final List<IPLBatsman> sortedByFours = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLBatsman::getNoOfFours).reversed(), limit);

		return sortedByFours.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getHighestSixes(final int limit) {
		final List<IPLBatsman> sortedBySixes = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLBatsman::getNoOfSixes).reversed(), limit);

		return sortedBySixes.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getHighestStrikeRateWithFoursAndSixes(final int limit) {
		final Comparator<IPLBatsman> comparator = Comparator.comparing(IPLBatsman::getNoOfSixes)
				.thenComparing(IPLBatsman::getNoOfFours).thenComparing(IPLBatsman::getStrikingRate).reversed();

		final List<IPLBatsman> sortedBySixes = sortBy(batsman.getPlayerList(), comparator, limit);

		return sortedBySixes.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getBestAverageWithBestStrikeRate(int limit) {
		final Comparator<IPLBatsman> comparator = Comparator.comparing(IPLBatsman::getAverage)
				.thenComparing(IPLBatsman::getStrikingRate).reversed();

		final List<IPLBatsman> sortedBySixes = sortBy(batsman.getPlayerList(), comparator, limit);

		return sortedBySixes.toArray(new IPLBatsman[0]);
	}

	public IPLBatsman[] getMaximumRunWithBestAvg(int limit) {
		final Comparator<IPLBatsman> comparator = Comparator.comparing(IPLBatsman::getRunScored)
				.thenComparing(IPLBatsman::getAverage).reversed();

		final List<IPLBatsman> sortedBySixes = sortBy(batsman.getPlayerList(), comparator, limit);

		return sortedBySixes.toArray(new IPLBatsman[0]);
	}

}
