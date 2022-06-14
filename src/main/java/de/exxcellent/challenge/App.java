package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * The entry class for your solution. This class is only aimed as starting
 * point and not intended as baseline for your implementation.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static final List<Object> EXAMPLE_NESTED_LIST_INTEGERS = Collections.unmodifiableList(
            asList(1, asList(2, 3), asList(4, asList(5, 6)))
    );
    public static final List<Object> EXAMPLE_NESTED_LIST_STRINGS = Collections.unmodifiableList(
            asList(asList("a", asList("b", "c")), "d", asList("e", "f"))
    );

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        List<Object> result = FlattenList.flattenList(EXAMPLE_NESTED_LIST_INTEGERS);

        System.out.print(EXAMPLE_NESTED_LIST_INTEGERS);
        System.out.print(" -> ");
        System.out.println(result);

        result = FlattenList.flattenListUsingStream(EXAMPLE_NESTED_LIST_STRINGS);

        System.out.print(EXAMPLE_NESTED_LIST_STRINGS);
        System.out.print(" -> ");
        System.out.println(result);
    }
}
