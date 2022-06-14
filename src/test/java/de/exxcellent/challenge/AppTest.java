package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @Test
    void runWeather() {
        App.main("weather", "./src/main/resources/de/exxcellent/challenge/weather.csv");
    }

    @Test
    void runFootball() {
        App.main("football", "./src/main/resources/de/exxcellent/challenge/football.csv");
    }

}