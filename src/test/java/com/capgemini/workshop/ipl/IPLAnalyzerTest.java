package com.capgemini.workshop.ipl;

import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyzerTest {
    @Test
    public void topBattingAverageInIPL() {
        IPLAnalyzer iplAnalyzer=new IPLAnalyzer();
        IPLPlayer[] iplPlayers= iplAnalyzer.getTopBattingAverage();
        Assert.assertEquals(iplPlayers[0].getName(), "David Warner");
    }
    
}
