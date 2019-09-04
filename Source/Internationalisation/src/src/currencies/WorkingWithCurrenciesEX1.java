package src.currencies;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class WorkingWithCurrenciesEX1 {

    public static void main(String[] args) {
        NumberFormat ukFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        ukFormat.setCurrency(Currency.getInstance("GBP"));
        System.out.println(ukFormat.format(123456789.10));
        
        ukFormat.setCurrency(Currency.getInstance("USD"));
        System.out.println(ukFormat.format(123456789.10));
        
        ukFormat.setCurrency(Currency.getInstance("EUR"));
        System.out.println(ukFormat.format(123456789.10));
        
        System.out.println("");
        
        NumberFormat itaFormat = NumberFormat.getCurrencyInstance(Locale.ITALY);
        itaFormat.setCurrency(Currency.getInstance("GBP"));
        System.out.println(itaFormat.format(123456789.10));
        
        itaFormat.setCurrency(Currency.getInstance("USD"));
        System.out.println(itaFormat.format(123456789.10));
        
        itaFormat.setCurrency(Currency.getInstance("EUR"));
        System.out.println(itaFormat.format(123456789.10));
    }
    
}
