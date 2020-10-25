package com.capgemini.workshop.ipl;

import com.capgemini.workshop.ipl.dao.IPLBatsman;
import com.capgemini.workshop.ipl.dao.IPLBowler;
import com.capgemini.workshop.ipl.dao.IPLPlayer;
import com.capgemini.workshop.ipl.exception.IPLAnalyzerException;
import com.capgemini.workshop.ipl.service.IPLAnalyzer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLAnalyzerTest {
    private static final String TEST_RESOURCES = "src/test/java/com/capgemini/workshop/ipl/resources/";
    private static final String IPL_BATTING_DATA = TEST_RESOURCES + "IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BOWLING_DATA = TEST_RESOURCES + "IPL2019FactsheetMostWkts.csv";

    public IPLAnalyzer iplAnalyzer;

    @Before
    public void init() throws IPLAnalyzerException {
        iplAnalyzer = new IPLAnalyzer();
        iplAnalyzer.loadBattingData(IPL_BATTING_DATA);
        iplAnalyzer.loadBowlingData(IPL_BOWLING_DATA);
    }

    @Test
    public void topBattingAverageInIPL() {
        final IPLBatsman[] iplPlayers = iplAnalyzer.getTopBattingAverage(5);
        Assert.assertEquals(iplPlayers[0].getName(), "MS Dhoni");
    }

    @Test
    public void batsmanWithTopStrikeRate() {
        final IPLBatsman[] iplPlayers = iplAnalyzer.getTopStrikingRates(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Ishant Sharma");
    }

    @Test
    public void batsmanWithHighestFours() {
        final IPLBatsman[] iplPlayers = iplAnalyzer.getHighestFours(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Shikhar Dhawan");
    }

    @Test
    public void bastsmanWithHighestSixes() {
        final IPLBatsman[] iplPlayers = iplAnalyzer.getHighestSixes(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Andre Russell");
    }

    @Test
    public void batsmanWithHighestStrikeRateWithFoursAndSixes() {
        final IPLBatsman[] iplPlayers = iplAnalyzer.getHighestStrikeRateWithFoursAndSixes(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Andre Russell");
    }

    @Test
    public void batsmanWithBestAverageWithBestStrikingRate() {
        final IPLBatsman[] iplPlayers = iplAnalyzer.getBestAverageWithBestStrikeRate(5);
        Assert.assertEquals(iplPlayers[0].getName(), "MS Dhoni");
    }

    @Test
    public void batsmanWithMaximumRunsWithBestAverage() {
        final IPLBatsman[] iplPlayers = iplAnalyzer.getMaximumRunWithBestAvg(5);
        Assert.assertEquals(iplPlayers[0].getName(), "David Warner");
    }

    @Test
    public void bowlerWithTopBowlingAvg() {
        final IPLBowler[] iplBowlers = iplAnalyzer.getTopBowlingAvg(5);
        Assert.assertEquals(iplBowlers[0].getName(), "Anukul Roy");
    }

    @Test
    public void bowlerWithTopStrikingRates() {
        final IPLBowler[] iplBowlers = iplAnalyzer.getTopBowlingStrikingRate(5);
        Assert.assertEquals(iplBowlers[0].getName(), "Alzarri Joseph");
    }

    @Test
    public void bowlerWithTopEconomyRate() {
        final IPLBowler[] iplBowlers = iplAnalyzer.getTopEconomyRate(5);
        Assert.assertEquals(iplBowlers[0].getName(), "Shivam Dube");
    }

    @Test
    public void bowlerWithBestStrikeRateWith4wAnd5w() {
        final IPLBowler[] iplBowlers = iplAnalyzer.getBestStrikeRateWith4wOr5w(5);
        Assert.assertEquals(0, iplBowlers.length);
    }

    @Test
    public void bowlerWithBestStrikeRateAndGreatAvg() {
        final IPLBowler[] iplBowlers = iplAnalyzer.getBestStrikeRateWithGreatAvg(5);
        Assert.assertEquals(iplBowlers[0].getName(), "Alzarri Joseph");
    }

    @Test
    public void bowlerWithMaximumWktsAndWithBestAvg() {
        final IPLBowler[] iplBowlers = iplAnalyzer.getMaxWktsAndBestAvg(5);
        Assert.assertEquals(iplBowlers[0].getName(), "Imran Tahir");
    }

    @Test
    public void getBestBattingAndBowlingAvgforAllRounders() {
        final IPLPlayer[] iplAllRounders = iplAnalyzer.getBestBattingBowlingAvg(5);
        Assert.assertEquals(iplAllRounders[0].getName(), "Andre Russell");
    }

    @Test
    public void getBestAllRounderWithMostRunsAndMostWickets() {
        final IPLPlayer[] bestAllRounders = iplAnalyzer.getBestAllRounders();
        Assert.assertEquals(bestAllRounders[0].getName(), "Hardik Pandya");
    }

    @Test
    public void getBatsmanWithMaximumHundredsWithBestAverage() {
        final IPLBatsman[] batsmans = iplAnalyzer.getMaxHundredsBestAvg();
        Assert.assertEquals(batsmans[0].getName(), "David Warner");

    }

    @Test
    public void getBatsmanWithZeroFiftiesAndHundredsWithBestAverage() {
        final IPLBatsman[] batsmans = iplAnalyzer.getBestAvgWithZeroFiftiesAndHundreds();
        Assert.assertEquals(batsmans[0].getName(), "Marcus Stoinis");

    }
}
