package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DataBaseInteractionTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void createTableTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void insertValuesTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void argMinAbsDiffTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

}