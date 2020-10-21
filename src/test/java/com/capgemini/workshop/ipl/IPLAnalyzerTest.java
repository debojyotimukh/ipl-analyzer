package com.capgemini.workshop.ipl;

import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyzerTest {
    private static final String IPL_BATTING_DATA = "src/test/java/com/capgemini/workshop/ipl/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void topBattingAverageInIPL() {
        IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
        iplAnalyzer.loadBattingData(IPL_BATTING_DATA);
        IPLPlayer[] iplPlayers = iplAnalyzer.getTopFiveBattingAverage();
        Assert.assertEquals(iplPlayers[0].getName(), "MS Dhoni");
    }

}
