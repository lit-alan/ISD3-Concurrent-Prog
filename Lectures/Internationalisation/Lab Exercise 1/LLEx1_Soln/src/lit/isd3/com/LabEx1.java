package lit.isd3.com;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class LabEx1 {

    static Locale locales[] = {null, new Locale("en", "IE"), new Locale("it", "IT"), new Locale("de", "CH"), new Locale("es", "US")};
    static Locale l = null;
    static NumberFormat currencyFormat;
    static NumberFormat numberFormat;
    static NumberFormat percentFormat;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        displayMenu();

        int choice = scanner.nextInt();

        while (choice != -1) {
            
            try {
                l = locales[choice];
            }
            catch (Exception ex) {
                System.out.println("ERROR");
                quit();
            }

            System.out.print("Enter a numeric value: ");
            double value = scanner.nextDouble();

            currencyFormat = NumberFormat.getCurrencyInstance(l);
            numberFormat = NumberFormat.getNumberInstance(l);
            percentFormat = NumberFormat.getPercentInstance(l);

            System.out.println("\n" + value + " formatted for " + l.toString());
            System.out.println(currencyFormat.format(value));
            System.out.println(numberFormat.format(value));
            System.out.println(percentFormat.format(value));

            displayMenu();
            
            choice = scanner.nextInt();

        }//end while

        quit();
    }

    private static void quit() {
        System.out.println("\nGoodbye");
        System.exit(0);
    }
    
    private static void displayMenu() {
        System.out.println("\n\tMain Menu");
        System.out.println("1: English-Ireland");
        System.out.println("2: Italian-Italy");
        System.out.println("3: German-Switzerland");
        System.out.println("4: Spanish-USA");
        System.out.println("-1: Quit");
        System.out.print("Please a selection: ");
    }

}
