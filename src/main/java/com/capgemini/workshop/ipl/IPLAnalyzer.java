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

	private static <T> List<T> sortBy(String filepath, Comparator<T> comparator, Class<T> clazz)
			throws IPLAnalyzerException {

		try (Reader reader = Files.newBufferedReader(Paths.get(filepath));) {
			ICSVBuilder<T> csvBuilder = CSVBuilderFactory.createCSVBuilder();
			List<T> list = csvBuilder.getLst(reader, clazz);
			List<T> sortedList = list.stream().sorted(comparator).distinct().collect(Collectors.toList());

			return sortedList;

		} catch (IOException ioe) {
			throw new IPLAnalyzerException(ioe.getMessage());
		} catch (CSVBuilderException e) {
			throw new IPLAnalyzerException(e.getMessage());
		}
	}

	public IPLPlayer[] getTopFiveBattingAverage() {
		List<IPLPlayer> sortedByAverage = null;
		try {
			sortedByAverage = sortBy(csvPath, Comparator.comparing(IPLPlayer::getAverage).reversed(), IPLPlayer.class)
					.stream().limit(5).collect(Collectors.toList());

		} catch (IPLAnalyzerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sortedByAverage.toArray(new IPLPlayer[0]);
	}

	public void loadBattingData(String filepath) {
		this.csvPath = filepath;
	}

}
