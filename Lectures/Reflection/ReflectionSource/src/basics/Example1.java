package basics;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;


public class Example1 {

 
    public static void main(String[] args) {
        
        String AnObject = "";
        
        Class c = AnObject.getClass();
        
        Method[] methods = c.getMethods();
        Field[] fields = c.getFields();
        Constructor[] constructors = c.getConstructors();
      
        System.out.println(methods[1]); System.out.println(fields[1]); System.out.println(constructors);
        
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
        
        Object AnotherObject = arr[randomNum]; //if randomNum == 4 the int value is converted to an Integer
        printMethodNames(AnotherObject);
    }

    private static void printMethodNames(Object AnObject) {
       
        Class c = AnObject.getClass();
        Method[] methods   =c.getMethods();
        
        System.out.println("Methods of the " + c.getName() + " class");
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }
    
}
