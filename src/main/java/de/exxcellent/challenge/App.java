package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * The entry class for your solution. This class is only aimed as starting
 * point and not intended as baseline for your implementation.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static final List<Object> EXAMPLE_NESTED_LIST = Collections.unmodifiableList(
            asList(1, asList(2, 3), asList(4, asList(5, 6)))
    );
    public static final List<Object> EXAMPLE_NESTED_LIST_2 = Collections.unmodifiableList(
            asList(asList("a", asList("b", "c")), "d", asList("e", "f"))
    );

    public static List<Object> flattenList(List<Object> nestedList){
        return flattenListHelper(nestedList, new ArrayList<>());
    }

    public static List<Object> flattenListHelper(List<Object> nestedList, List<Object> log){
        if (nestedList.isEmpty())
                return log;

        if (!(nestedList.get(0) instanceof List)){
            log.add(nestedList.get(0));
            return flattenListHelper(nestedList.subList(1, nestedList.size()), log);
        }

        log = flattenListHelper((List<Object>) nestedList.get(0), log);
        return flattenListHelper(nestedList.subList(1,nestedList.size()), log);
    }

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        List<Object> result = flattenList(EXAMPLE_NESTED_LIST);

        System.out.print(EXAMPLE_NESTED_LIST);
        System.out.print(" -> ");
        System.out.println(result);
    }
}
