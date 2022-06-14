package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattenList {

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

    public static List<Object> flattenListUsingStream(List<Object> nestedList){
        return nestedList.stream().flatMap(FlattenList::flatMapRecursive).collect(Collectors.toList());
    }

    public static Stream<Object> flatMapRecursive(Object object) {
        if (!(object instanceof List))
            return Stream.of(object);
        return ((List<?>) object).stream().flatMap(FlattenList::flatMapRecursive);
    }

}
