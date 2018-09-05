package src.formatting_numbers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbersEX2 {

    public static void main(String[] args) {

        //English-Ireland
        Locale l = new Locale("en", "IE");

        NumberFormat frmt = NumberFormat.getNumberInstance(l);
        DecimalFormat df = (DecimalFormat) frmt;
        System.out.println(df.format(30.983));
        System.out.println(df.format(3000.9856));
        System.out.println(df.format(3.9));

    }
}