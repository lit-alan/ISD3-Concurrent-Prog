package ExerciseTwo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args) {
        try {
            Socket connectToServer = new Socket("localhost", 8008);
            DataOutputStream osToServer = new DataOutputStream(connectToServer.getOutputStream());
            
            while (true) {
                String output = "";
                String input = JOptionPane.showInputDialog("Enter Number");

                int number = Integer.parseInt(input.trim());

                //isolate each digit
                int digit1 = (number / 1000 + 7) % 10;
                int digit2 = (number % 1000 / 100 + 7) % 10;
                int digit3 = (number % 1000 % 100 / 10 + 7) % 10;
                int digit4 = (number % 1000 % 100 % 10 + 7) % 10;

                //swap digits
                int temp = digit1;
                digit1 = digit3 * 1000;
                digit3 = temp * 10;
                
                temp = digit2;
                digit2 = digit4 * 100;
                digit4 = temp;

                //reassemble encrypted number
                int encryptedNumber = digit1 + digit2 + digit3 + digit4;
                osToServer.writeInt(encryptedNumber);
                osToServer.flush();
                JOptionPane.showMessageDialog(null, "Number " + encryptedNumber + " Send To Server");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }//end main
}//end class

