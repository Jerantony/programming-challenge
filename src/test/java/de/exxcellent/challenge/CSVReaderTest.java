package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CSVReaderTest {

    private String filePath = "C:\\Users\\Jeremy\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";
    CSVReader reader;

    @BeforeEach
    void setUp() {
        reader = new CSVReader();
    }

    @Test
    void readAllTest() {
        List<String[]> allLines = reader.readAll(filePath);
        String[] attributes = allLines.get(0);
        List<String[]> values = allLines.subList(1, allLines.size());
        assertEquals("Day", attributes[0]);
        assertEquals("1HrP_TPcpn", attributes[5]);
        assertEquals(88, Integer.parseInt(values.get(0)[1]));
    }

}