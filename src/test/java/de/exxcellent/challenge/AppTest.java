package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @Test
    void flattenListTest() {
        List<Object> flattenedList = App.flattenList(App.EXAMPLE_NESTED_LIST_INTEGERS);
        List<Integer> goal = asList(1, 2, 3, 4, 5, 6);
        assertEquals(goal, flattenedList, "My expectations were not met");
    }

    @Test
    void flattenListTest2() {
        List<Object> flattenedList = App.flattenList(App.EXAMPLE_NESTED_LIST_STRINGS);
        List<String> goal = asList("a", "b", "c", "d", "e", "f");
        assertEquals(goal, flattenedList, "My expectations were not met");
    }

    @Test
    void flattenListUsingStreamTest() {
        List<Object> flattenedList = App.flattenListUsingStream(App.EXAMPLE_NESTED_LIST_INTEGERS);
        List<Integer> goal = asList(1, 2, 3, 4, 5, 6);
        assertEquals(goal, flattenedList, "My expectations were not met");
    }

    @Test
    void flattenListUsingStreamTest2() {
        List<Object> flattenedList = App.flattenListUsingStream(App.EXAMPLE_NESTED_LIST_STRINGS);
        List<String> goal = asList("a", "b", "c", "d", "e", "f");
        assertEquals(goal, flattenedList, "My expectations were not met");
    }

    @Test
    void runApp() {
        App.main();
    }
}