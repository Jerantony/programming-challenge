package de.exxcellent.challenge;

import java.util.Arrays;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        DataBaseInteraction dbInteraction = new DataBaseInteraction();
        csvReader reader = new csvReader();

        List<String[]> weatherData = reader.readAll("C:\\Users\\Jeremy\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");

        String table = "weather";
        String[] attributes = weatherData.get(0);
        List<String[]> values = weatherData.subList(1, weatherData.size());

        dbInteraction.clearTable(table);
        dbInteraction.insertValues(table, attributes, values);
        String dayWithSmallestTempSpread = dbInteraction.argMinAbsDiff(table, "Day", "MxT", "MnT");
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);


        List<String[]> footballData = reader.readAll("C:\\Users\\Jeremy\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv");

        table = "football";
        attributes = footballData.get(0);
        values = footballData.subList(1, footballData.size());

        dbInteraction.clearTable(table);
        dbInteraction.insertValues(table, attributes, values);
        String teamWithSmallestGoalSpread = dbInteraction.argMinAbsDiff(table, "Team", "Wins", "Losses");
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
