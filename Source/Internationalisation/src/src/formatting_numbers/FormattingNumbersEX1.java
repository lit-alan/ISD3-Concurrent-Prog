package src.formatting_numbers;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbersEX1 {

    public static void main(String[] args) {
        
        double aMoneyValue = 123456789.10;
        double aNumberValue = 98765432.10;
        double aPercentValue = .15;
        
        Locale  locales[] = new Locale[4];
        
        //English-Ireland
        locales[0] = new Locale("en", "IE");
        
        //Spanish-USA
        locales[1] = new Locale("es", "US");
       
        //German-Switzerland
        locales[2] = Locale.forLanguageTag("de-CH");
        
        locales[3] = Locale.ITALIAN;
        
        for (Locale locale : locales) {
            NumberFormat currencyFrmt = NumberFormat.getCurrencyInstance(locale);
            NumberFormat numberFrmt = NumberFormat.getNumberInstance(locale);
            NumberFormat percentFrmt = NumberFormat.getPercentInstance(locale);
            System.out.println(locale.getDisplayName());
            System.out.println(currencyFrmt.format(aMoneyValue));
            System.out.println(numberFrmt.format(aNumberValue));
            System.out.println(percentFrmt.format(aPercentValue));
            System.out.println("-----");
        }
    
    }

}
