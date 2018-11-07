package basics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Example4 {

 
    public static void main(String[] args)  {

        String str = new String("The quick brown fox jumps over the lazy dog");

        try {
            
            Class c = str.getClass();
            
            Method m = c.getMethod("length", null);
            System.out.println("String length = " + m.invoke(str));
            
            m = c.getMethod("startsWith", String.class);
            System.out.println("String starts with \"The\"? "   + m.invoke(str, "The"));
            System.out.println("String starts with \"quick\"? " + m.invoke(str, "quick"));
            
            m = c.getMethod("indexOf", String.class, Integer.TYPE);
            System.out.println("First occurrence of \"fox\" in the string is at char " + m.invoke(str, "fox", 0));
        } catch (Exception ex) {
            System.out.println(ex);
        }
      
        
        
        
    }

   
}
