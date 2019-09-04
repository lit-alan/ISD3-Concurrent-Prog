package src.collation;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class CollationEX2 {

    public static void main(String[] args) {

        String[] words = {"San José", "San Jose", "SAN JOSE"};

        Collator coll = Collator.getInstance(Locale.UK);
        
        coll.setStrength(Collator.PRIMARY);

        Arrays.sort(words, coll);

        System.out.println("Primary  " + Arrays.toString(words));
        
        coll.setStrength(Collator.SECONDARY);

        Arrays.sort(words, coll);

        System.out.println("Secondary  " + Arrays.toString(words));
        
        coll.setStrength(Collator.TERTIARY);

        Arrays.sort(words, coll);

        System.out.println("Tertiary  " + Arrays.toString(words));
        
        
    }

}
