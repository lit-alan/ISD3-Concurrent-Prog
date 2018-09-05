package src.working_with_locales;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class LocaleEX1 {

    
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar();
        
        Locale  locales[] = new Locale[4];
        
        //English-Ireland
        locales[0] = new Locale("en", "IE");
        
        //Spanish-USA
        locales[1] = new Locale("es", "US");
       
        //German-Switzerland
        locales[2] = Locale.forLanguageTag("de-CH");
        
        locales[3] = Locale.ITALIAN;
        
        for (Locale locale : locales) {
            
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
            System.out.println(locale + "\t" + formatter.format(cal.getTime()));
        }
        
    }
    
}
