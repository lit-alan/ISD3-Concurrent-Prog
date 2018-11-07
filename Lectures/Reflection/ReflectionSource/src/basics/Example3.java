package basics;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;


public class Example3 {

 
    public static void main(String[] args) throws SecurityException, NoSuchFieldException {

        JButton btn = new JButton("Click ME");
        Integer i = new Integer(10);
        String str = new String("The quick brown fox jumps over the lazy dog");
        File f = new File("c:\temp.txt");
        
        Object[] arr = new Object[5];
        arr[0] = btn;
        arr[1] = i;
        arr[2] = str;
        arr[3] = f;
        arr[4] = 23;
        
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        
        Object AnObject = arr[randomNum]; //if randomNum == 4 the int value is converted to an Integer
        
        try {
        printFieldContents(AnObject);
        }
        catch(IllegalArgumentException iae) {
            System.out.println(iae);
        }
        catch(IllegalAccessException iae) {
            System.out.println(iae);
        }
    }

    private static void printFieldContents(Object AnObject) throws IllegalAccessException, SecurityException, NoSuchFieldException {

        Class c = AnObject.getClass();
        System.out.println("Contents of the fields for " + c.getName() + " class");

        for (Field f : c.getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(AnObject);
            System.out.println(f.getName() + ": " + value);
        }
        
    }
    
}
