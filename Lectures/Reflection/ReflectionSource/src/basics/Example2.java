package basics;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;


public class Example2 {

 
    public static void main(String[] args) {

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
        printMethodSignatures(AnObject);
    }

    private static void printMethodSignatures(Object AnObject) {

        Class c = AnObject.getClass();
        System.out.println("Methods of the " + c.getName() + " class");
        
        for (Method method : c.getDeclaredMethods()) {
            System.out.println(Modifier.toString((method.getModifiers())) + " "
                    + method.getReturnType().getCanonicalName() + " "
                    + method.getName()
                    + Arrays.toString(method.getParameters()));
        }
    }
    
}
