package src.working_with_locales;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class LocaleEX2 {

    
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar();
        
        Locale  locales[] = GregorianCalendar.getAvailableLocales();
        
       
        for (Locale locale : locales) {
            
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
            System.out.println(locale + "\t" + formatter.format(cal.getTime()));
        }
        
    }
    
}
