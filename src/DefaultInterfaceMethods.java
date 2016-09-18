/**
 * Created by Roma on 18.09.2016.
 * We can make no-abstract methods in interface using the key word 'default'.
 *
 * ! If class implements two interfaces that have method/s with the same signature
 * we have to override these method/s
 */
public class DefaultInterfaceMethods implements MyInt1{
    @Override
    public void doSomething1(Object obj) {
        System.out.println("! override behavior: " + obj);
    }

    public static void main(String[] args) {
        DefaultInterfaceMethods defaultInterfaceMethods = new DefaultInterfaceMethods();

        defaultInterfaceMethods.doSomething1("String");
        defaultInterfaceMethods.doSomething2("String2");
    }
}

interface MyInt1{
    default void doSomething1(Object obj){
        System.out.println("default behavior: "+obj);
    }

    default void doSomething2(Object obj){
        System.out.println("default behavior: "+obj);
    }
}

