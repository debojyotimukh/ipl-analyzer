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

	public IPLPlayer[] getTopStrikingRates(int limit) {
		
		final List<IPLPlayer> sortedByStrikeRate = sortBy(batsman.getPlayerList(),
				Comparator.comparing(IPLPlayer::getStrikingRate).reversed(), limit);

		return sortedByStrikeRate.toArray(new IPLPlayer[0]);
	}

}
