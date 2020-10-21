package com.capgemini.workshop.ipl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.training.iohelper.CSVBuilderException;
import com.capgemini.training.iohelper.CSVBuilderFactory;
import com.capgemini.training.iohelper.ICSVBuilder;

public class IPLAnalyzer {
	private String csvPath;

	private static <T> List<T> sortBy(final String filepath, final Comparator<T> comparator, final Class<T> clazz)
			throws IPLAnalyzerException {

		try (Reader reader = Files.newBufferedReader(Paths.get(filepath));) {
			final ICSVBuilder<T> csvBuilder = CSVBuilderFactory.createCSVBuilder();
			final List<T> list = csvBuilder.getLst(reader, clazz);
			final List<T> sortedList = list.stream().sorted(comparator).distinct().collect(Collectors.toList());

			return sortedList;

		} catch (final IOException ioe) {
			throw new IPLAnalyzerException(ioe.getMessage());
		} catch (final CSVBuilderException e) {
			throw new IPLAnalyzerException(e.getMessage());
		}
	}

	public IPLPlayer[] getTopFiveBattingAverage() {
		List<IPLPlayer> sortedByAverage = null;
		try {
			sortedByAverage = sortBy(csvPath, Comparator.comparing(IPLPlayer::getAverage).reversed(), IPLPlayer.class)
					.stream().limit(5).collect(Collectors.toList());

		} catch (final IPLAnalyzerException e) {
			e.getMessage();
		}
		return sortedByAverage.toArray(new IPLPlayer[0]);
	}

	public void loadBattingData(final String filepath) {
		this.csvPath = filepath;
	}

}
