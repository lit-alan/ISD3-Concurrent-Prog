package lambdas.basic;

import java.util.Random;

public class TestMathOperation {

    public static void main(String[] args) {
        new TestMathOperation();
    }

    public TestMathOperation() {
         MathOperation addition = (int a, int b) -> a + b;
         System.out.println("10 + 20 = " + operate(10, 20, addition));
         
         MathOperation subtraction = (a, b) -> b - a;
         System.out.println("\n20 - 10 = " + operate(10, 20, subtraction));
         
         MathOperation multiplication = (int a, int b) -> { return a * b; };
         System.out.println("\n10 * 20 = " + operate(10, 20, multiplication));
         
         MathOperation division  = (int a, int b) -> b / a;
         System.out.println("\n20 / 10  = " + operate(10, 20, division));
    
         MathOperation remainder  = (int a, int b) -> b % a;
         System.out.println("\n20 % 3  = " + operate(3, 20, remainder));
    
         Random r = new Random();
         MathOperation rand = (int min, int max) -> { return r.nextInt((max - min) + 1 ) + min; }; 
         System.out.println("\nRand Number between 3 and 20 = " + operate(3, 20, rand));
    
         System.out.println("\nAddition of 3, 4 and 5 = " + operate(operate(3,4,addition),5,addition));
         
    }//end method
    
    public int operate(int a, int b, MathOperation math) {
        
        return math.operation(a, b);
    }//end method

}//end class
