package basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Example5 {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Integer i = 5;
        Class c1 = i.getClass();
        Constructor con1 = c1.getConstructor(int.class);
        Object obj1 = con1.newInstance(2);
        System.out.println("Class Type: " + obj1.getClass() + "\tValue: " + obj1.toString());

        String str = "The quick brown fox jumps over the lazy dog";
        Class c2 = str.getClass();
        Constructor con2 = c2.getConstructor(String.class);
        Object obj2 = con2.newInstance("Hello World");
        System.out.println("Class Type: " + obj2.getClass() + "\tValue: " + obj2.toString());

        Constructor[] contructors = c2.getConstructors();
        for (Constructor aConstructor : contructors) {
            System.out.println(aConstructor.toString());
        }

    }

}
