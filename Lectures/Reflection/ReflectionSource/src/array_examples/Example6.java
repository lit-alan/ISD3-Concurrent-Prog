package array_examples;

import java.lang.reflect.Array;

public class Example6 {

    public static void main(String[] args) {
        
        String arr1[] = {"A", "B", "C", "D", "E", "F"};
        System.out.println("arr1 length: " + arr1.length);
        System.out.println("arr1 type: " + arr1.getClass().getCanonicalName());
        for (String s : arr1) {
            System.out.print(s + ", ");
        }
        System.out.println("\n");
        
        Object[] arr2 = badCopyOf(arr1, 10);
        //String[] arr2 = (String[]) badCopyOf(arr1, 10); //throws a ClassCastException
        System.out.println("arr2 Length: " + arr2.length);
        System.out.println("arr2 type: " + arr2.getClass().getCanonicalName());
        for (Object o : arr2) {
            System.out.print(o + ", ");
        }
        
        System.out.println("\n");

        String[] arr3 = (String[]) goodCopyOf(arr1, 10);

        System.out.println("arr3 length: " + arr3.length);
        System.out.println("arr3 type: " + arr3.getClass().getCanonicalName());
        for (String s : arr3) {
            System.out.print(s + ", ");
        }

        System.out.println("");
    }//end main

    public static Object goodCopyOf(Object array, int newLength) {
        Class<?> cl = array.getClass();

        if (!cl.isArray()) {
            return null;
        }

        Class<?> componentType = cl.getComponentType();

        int length = Array.getLength(array);
        Object newArray = Array.newInstance(componentType, newLength);

        for (int i = 0; i < Math.min(length, newLength); i++) {
            Array.set(newArray, i, Array.get(array, i));
        }

        return newArray;

    }//end method

    public static Object[] badCopyOf(Object[] array, int newLength) {

        Object[] newArray = new Object[newLength];

        for (int i = 0; i < Math.min(array.length, newLength); i++) {
            newArray[i] = array[i];
        }

        return newArray;

    }//end method
}
