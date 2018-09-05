package src.collation;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class CollationEX1 {

    public static void main(String[] args) {

        String[] words = {"Zulu", "Athens", "Ångström", "able", "zebra"};

        Arrays.sort(words);

        System.out.println("Simple Sort " + Arrays.toString(words));

        Collator coll = Collator.getInstance(new Locale("sv", "SE"));

        Arrays.sort(words, coll);

        System.out.println("Swedish Sort " + Arrays.toString(words));
        
        coll = Collator.getInstance(new Locale("en", "IE"));

        Arrays.sort(words, coll);

        System.out.println("Irish Sort " + Arrays.toString(words));
    }

}
