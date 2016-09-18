import java.io.Serializable;

/**
 * Created by Roma on 18.09.2016.
 */
public class TypeIntersection {
    //old style
    public Runnable getInstance() {
        class SomeClass implements Serializable, Cloneable, Runnable {

            @Override
            public void run() {
                System.out.println(10);
            }
        }

        return new SomeClass();
    }


    //java8
    public Runnable getInstanceJava8() {
        return (Runnable & Serializable & Cloneable) (() -> System.out.println(10));
    }
}
