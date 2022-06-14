package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements Reader{

    @Override
    public List<String[]> readAll(String filePath) {
        List<String[]> allLines = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                allLines.add(line.replace(" ", "_").split(","));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return allLines;
    }
}
