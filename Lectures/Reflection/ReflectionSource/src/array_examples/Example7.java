/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_examples;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 *
 * @author Alan.Ryan
 */
public class Example7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[] arr = new Object[5];

        arr[0] = "hello";
        arr[1] = "world";
        arr[2] = 2018;
        arr[3] = 10.9;
        arr[4] = false; //mixed content in an array is not desireable

        Class<?> cl = arr.getClass();
        
        if (cl.isArray()) {
            
            Field[] fields = cl.getDeclaredFields();
            System.out.println(fields.length);
            for (Object field : fields) {
                System.out.println(field);
            }
            int length = Array.getLength(arr);
            
            for(int i = 0; i < length; i++) {
                Object element = Array.get(arr, i);
                Class cls = element.getClass();
                
                System.out.println("Index: "  + i + "\t" + cls + "\tValue " + element);
            }
        
            
        
        }
        

    }

}
 