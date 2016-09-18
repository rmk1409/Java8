import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Roma on 18.09.2016.
 * Lambda expressions: proceeding collections in multi threading
 */
public class LambdaExpressions {
    private void doSomething(Object obc) {
    }

    public void showLambda() {
        List<Object> list = Arrays.asList(new Object(), "String", 1);

        //old approach
        for (Object obj : list) {
            doSomething(obj);
        }

        //java8
        list.forEach((Object o) -> doSomething(o));
        //or
        list.forEach(o -> doSomething(o));
        //or double colon to give a method link
        list.forEach(this::doSomething);

        //link of method
        list.forEach(System.out::println);

        //anonymous class
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o1 > o2 ? 1 : 0);
            }
        };

        //java8
        Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> o1 < o2 ? -1 : (o1 > o2 ? 1 : 0);
        //the same
        Comparator<Integer> comparator3 = (o1, o2) -> o1 < o2 ? -1 : (o1 > o2 ? 1 : 0);

        //if method doesn't accept any parameters,
        //we just leave empty brackets
        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        };
    }
}
