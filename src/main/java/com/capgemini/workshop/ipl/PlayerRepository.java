package com.capgemini.workshop.ipl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.capgemini.training.iohelper.CSVBuilderException;
import com.capgemini.training.iohelper.CSVBuilderFactory;
import com.capgemini.training.iohelper.ICSVBuilder;

public class PlayerRepository<T> {
    private List<T> playerList;

    public void build(final String filepath, final Class<T> clazz) throws IPLAnalyzerException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filepath));) {
            final ICSVBuilder<T> csvBuilder = CSVBuilderFactory.createCSVBuilder();
            this.setPlayerList(csvBuilder.getLst(reader, clazz));

        } catch (final IOException ioe) {
            throw new IPLAnalyzerException(ioe.getMessage());
        } catch (final CSVBuilderException e) {
            throw new IPLAnalyzerException(e.getMessage());
        }
    }

    public List<T> getPlayerList() {
        return playerList;
    }

    private void setPlayerList(final List<T> playerList) {
        this.playerList = playerList;
    }

}
