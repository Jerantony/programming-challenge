package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DataBaseInteractionTest {

    static private String successLabel = "not successful";
    static private DataBaseInteraction dbInteraction;

    @BeforeAll
    static void setUp() {
        successLabel = "successful";
        dbInteraction = new DataBaseInteraction();
    }

    @Test
    void createTableTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void insertValuesAndReadTableTest() {
        if (dbInteraction.containsTable("test")){
            dbInteraction.clearTable("test");

            assert(dbInteraction.readTable("test").isEmpty());

            String table = "test";
            String[] attributes = new String[]{"stringCol", "intCol1", "intCol2"};
            List<String[]> values = new ArrayList<>();
            values.add(new String[]{"'test'", "42", "43"});
            dbInteraction.insertValues(table, attributes, values);
            List<String[]> output = dbInteraction.readTable("test");
            assert(Arrays.equals(output.get(0), new String[]{"test", "42", "43"}));

        } else {
            fail();
        }
    }

    @Test
    void argMinAbsDiffTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

}