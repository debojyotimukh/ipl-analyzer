package com.capgemini.workshop.ipl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyzer {
	private PlayerRepository<IPLPlayer> batsman;

	private static <T> List<T> sortBy(final List<T> playersList, final Comparator<T> comparator, final int limit) {

		return playersList.stream().sorted(comparator).distinct().limit(limit).collect(Collectors.toList());

	}

	public IPLPlayer[] getTopBattingAverage(final int limit) {

		final List<IPLPlayer> sortedByAverage = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLPlayer::getAverage).reversed(), limit);

		return sortedByAverage.toArray(new IPLPlayer[0]);
	}

	public void loadBattingData(final String filepath) {
		this.batsman = new PlayerRepository<>();
		try {
			this.batsman.build(filepath, IPLPlayer.class);
		} catch (final IPLAnalyzerException e) {
			e.getMessage();
		}
	}

	public IPLPlayer[] getTopStrikingRates(final int limit) {

		final List<IPLPlayer> sortedByStrikeRate = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLPlayer::getStrikingRate).reversed(), limit);

		return sortedByStrikeRate.toArray(new IPLPlayer[0]);
	}

	public IPLPlayer[] getHighestFours(final int limit) {
		final List<IPLPlayer> sortedByFours = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLPlayer::getNoOfFours).reversed(), limit);

		return sortedByFours.toArray(new IPLPlayer[0]);
	}

	public IPLPlayer[] getHighestSixes(final int limit) {
		final List<IPLPlayer> sortedBySixes = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLPlayer::getNoOfSixes).reversed(), limit);

		return sortedBySixes.toArray(new IPLPlayer[0]);
	}

	public IPLPlayer[] getHighestStrikeRateWithFoursAndSixes(final int limit) {
		final Comparator<IPLPlayer> comparator = Comparator.comparing(IPLPlayer::getNoOfSixes)
				.thenComparing(IPLPlayer::getNoOfFours).thenComparing(IPLPlayer::getStrikingRate).reversed();

		final List<IPLPlayer> sortedBySixes = sortBy(batsman.getPlayerList(), comparator, limit);

		return sortedBySixes.toArray(new IPLPlayer[0]);
	}

	public IPLPlayer[] getBestAverageWithBestStrikeRate(int limit) {
		final Comparator<IPLPlayer> comparator = Comparator.comparing(IPLPlayer::getAverage)
				.thenComparing(IPLPlayer::getStrikingRate).reversed();

		final List<IPLPlayer> sortedBySixes = sortBy(batsman.getPlayerList(), comparator, limit);

		return sortedBySixes.toArray(new IPLPlayer[0]);
	}

	public IPLPlayer[] getMaximumRunWithBestAvg(int limit) {
		final Comparator<IPLPlayer> comparator = Comparator.comparing(IPLPlayer::getRunScored)
				.thenComparing(IPLPlayer::getAverage).reversed();

		final List<IPLPlayer> sortedBySixes = sortBy(batsman.getPlayerList(), comparator, limit);

		return sortedBySixes.toArray(new IPLPlayer[0]);
	}

}
