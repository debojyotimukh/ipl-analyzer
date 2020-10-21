package com.capgemini.workshop.ipl;

import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyzerTest {
    @Test
    public void topBattingAverageInIPL() {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        iplAnalyzer.loadBattingData("src/test/java/com/capgemini/workshop/ipl/resources/IPL2019FactsheetMostRuns.csv");
        IPLPlayer[] iplPlayers= iplAnalyzer.getTopBattingAverage();
        Assert.assertEquals(iplPlayers[0].getName(), "David Warner");
    }
    
}
