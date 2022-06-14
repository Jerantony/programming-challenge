package de.exxcellent.challenge;

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

        String table = args[0];
        String filePath = args[1];

        DataBaseInteraction dbInteraction = new DataBaseInteraction();
        CSVReader reader = new CSVReader();

        List<String[]> data = reader.readAll(filePath);

        String[] attributes = data.get(0);
        List<String[]> values = data.subList(1, data.size());

        dbInteraction.clearTable(table);
        dbInteraction.insertValues(table, attributes, values);
        if (table.equals("weather")){
            String dayWithSmallestTempSpread = dbInteraction.argMinAbsDiff(table, "Day", "MxT", "MnT");
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } else {
            String teamWithSmallestGoalSpread = dbInteraction.argMinAbsDiff(table, "Team", "Wins", "Losses");
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        }
    }
}
