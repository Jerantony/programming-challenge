package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DataBaseInteractionTest {

    static private DataBaseInteraction dbInteraction;
    static private String table;
    static private String[] attributes;
    static private List<String[]> values;

    @BeforeAll
    static void setUp() {
        dbInteraction = new DataBaseInteraction();
        table = "test";
        attributes = new String[]{"stringCol", "intCol1", "intCol2"};
    }

    @BeforeEach
    void setUpEach(){
        values = new ArrayList<>();
        if (dbInteraction.containsTable("test")){
            dbInteraction.clearTable("test");
            assert(dbInteraction.readTable("test").isEmpty());
        } else {
            fail();
        }
    }

    @Test
    void insertValuesAndReadTableTest() {
        values.add(new String[]{"'test'", "42", "43"});
        dbInteraction.insertValues(table, attributes, values);
        List<String[]> output = dbInteraction.readTable("test");
        assert(Arrays.equals(output.get(0), new String[]{"test", "42", "43"}));
    }

    @Test
    void argMinAbsDiffTest() {
        values.add(new String[]{"'entry1'", "42", "50"});  // diff=8
        values.add(new String[]{"'entry2'", "25", "13"});  // diff=12
        values.add(new String[]{"'entry3'", "23", "19"});  // diff=4
        values.add(new String[]{"'entry4'", "40", "3"});   // diff=37
        values.add(new String[]{"'entry5'", "43", "57"});  // diff=14
        dbInteraction.insertValues(table, attributes, values);
        String argmin = dbInteraction.argMinAbsDiff(table, attributes[0], attributes[1], attributes[2]);
        assertEquals("entry3", argmin);
    }

}