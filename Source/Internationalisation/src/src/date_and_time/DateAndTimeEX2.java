package src.date_and_time;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateAndTimeEX2 {

    public static void main(String[] args) {
      
       for(Month m: Month.values()) {
           //TextStyle.FULL = January... TEXTStyle.SHORT = Jan...   TextStyle.NARROW = J
           System.out.print(m.getDisplayName(TextStyle.FULL, Locale.UK)  + ", ");
       }
       
        System.out.println("");
         
        for(DayOfWeek d: DayOfWeek.values()) {
           //TextStyle.FULL = Monday... TEXTStyle.SHORT = Mon...   TextStyle.NARROW = M
           System.out.print(d.getDisplayName(TextStyle.FULL, Locale.UK)  + ", ");
       }
    }
    
}
