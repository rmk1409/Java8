import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Roma on 18.09.2016.
 * We can proceed collection elements on multiple threads with stream api:
 * filter: we can filter elements
 * map: change elements
 * match: check whether a certain predicate matches the stream
 * count: count elements
 * reduce-like: get information from elements
 */
public class BulkDataOperatios {
    private static List<String> list = new ArrayList<>(Arrays.asList("aa", "ab", "bb", "ba", "cc"));

    public static void showFilter(){
        list
                //for parallel treating
                .parallelStream()
                //to sort
                .sorted()
                //predicate
                .filter(el -> el.startsWith("b"))
                .forEach(System.out::println);
    }

    public static void showMap(){
        List<String> collect = list
                .stream()
                .map(el -> el + " 1")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("unchanged: " + list);
        System.out.println("changed: " + collect);
    }

    public static void showMatch(){
        boolean anyStartWithC = list
                .parallelStream()
                .anyMatch(el -> el.startsWith("c"));
        System.out.println("whether any element starts with c: " + anyStartWithC);

        boolean allStartsWithC = list
                .parallelStream()
                .allMatch(el -> el.startsWith("c"));
        System.out.println("whether all elements start with c: " + allStartsWithC);

        boolean noneStartsWithP = list
                .parallelStream()
                .noneMatch(el -> el.startsWith("p"));
        System.out.println("whether none starts with p: " + noneStartsWithP);
    }

    public static void showCount(){
        long count = list
                .parallelStream()
                .count();

        System.out.println("amount of all elements: " + count);

        count = list
                .parallelStream()
                .filter(el -> el.startsWith("b"))
                .count();

        System.out.println("amount of elements that starts with b: " + count);
    }

}
