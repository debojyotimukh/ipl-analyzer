package com.capgemini.workshop.ipl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLAnalyzerTest {
    private static final String IPL_BATTING_DATA = "src/test/java/com/capgemini/workshop/ipl/resources/IPL2019FactsheetMostRuns.csv";

    public IPLAnalyzer iplAnalyzer;

    @Before
    public void init() {
        iplAnalyzer = new IPLAnalyzer();
        iplAnalyzer.loadBattingData(IPL_BATTING_DATA);
    }

    @Test
    public void topBattingAverageInIPL() {
        IPLBatsman[] iplPlayers = iplAnalyzer.getTopBattingAverage(5);
        Assert.assertEquals(iplPlayers[0].getName(), "MS Dhoni");
    }

    @Test
    public void batsmanWithTopStrikeRate() {
        IPLBatsman[] iplPlayers = iplAnalyzer.getTopStrikingRates(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Ishant Sharma");
    }

    @Test
    public void batsmanWithHighestFours() {
        IPLBatsman[] iplPlayers = iplAnalyzer.getHighestFours(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Shikhar Dhawan");
    }

    @Test
    public void bastsmanWithHighestSixes() {
        IPLBatsman[] iplPlayers = iplAnalyzer.getHighestSixes(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Andre Russell");
    }

    @Test
    public void batsmanWithHighestStrikeRateWithFoursAndSixes(){
        IPLBatsman[] iplPlayers = iplAnalyzer.getHighestStrikeRateWithFoursAndSixes(5);
        Assert.assertEquals(iplPlayers[0].getName(), "Andre Russell");
    }

    @Test
    public void batsmanWithBestAverageWithBestStrikingRate(){
        IPLBatsman[] iplPlayers = iplAnalyzer.getBestAverageWithBestStrikeRate(5);
        Assert.assertEquals(iplPlayers[0].getName(), "MS Dhoni");
    }

    @Test
    public void batsmanWithMaximumRunsWithBestAverage() {
        IPLBatsman[] iplPlayers = iplAnalyzer.getMaximumRunWithBestAvg(5);
        Assert.assertEquals(iplPlayers[0].getName(), "David Warner");        
    }

}
