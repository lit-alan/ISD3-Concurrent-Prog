package src.formatting_numbers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbersEX3 {

    public static void main(String[] args) {
        
        //UK
        Locale l = Locale.UK;

        NumberFormat frmt = NumberFormat.getNumberInstance(l);
        DecimalFormat df = (DecimalFormat) frmt;
        df.applyPattern("000.00");
        System.out.println(df.format(30.983));
        System.out.println(df.format(3000.9856));
        System.out.println(df.format(3.9));
    }

}
