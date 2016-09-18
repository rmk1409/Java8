/**
 * Created by Roma on 18.09.2016.
 *
 * Function interface can have only one abstract method
 * (SAM - Single Abstract Method)
 */
public class SAMTypes {
}

@FunctionalInterface
interface MyInterface1{
    void doMore();
}

@FunctionalInterface
interface MyInterface2{
    void doMore();
//    void doMore2(); //compile error
}


