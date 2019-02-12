package ExerciseThree;

 
import java.io.*;
import java.net.*;
import javax.swing.*;
    
public class AmicableClient {

    public static void main(String[] args) {
        try {
            
            // Create a socket to connect to the server
            Socket connectToServer = new Socket("localhost", 8080);
            
            // Create an input stream to receive data from the server
            DataInputStream isFromServer = new DataInputStream(
                    connectToServer.getInputStream());
            
            // Create an output stream to send data to the server
            DataOutputStream osToServer
                    = new DataOutputStream(connectToServer.getOutputStream());

            // Continuously communicate with the server
            while (true) {
                // Read the first num from the keyboard
                String input = JOptionPane.showInputDialog("Enter Number 1");
                int n1 = Integer.parseInt(input);

                // Read the second num from the keyboard
                input = JOptionPane.showInputDialog("Enter Number 2");
                int n2 = Integer.parseInt(input);
            
                // Send the numbers to the server 
                osToServer.writeInt(n1);
                osToServer.writeInt(n2);
                osToServer.flush();
                
                // Get flag from the server
                boolean flag = isFromServer.readBoolean();
                
                //output appropriate message to the end user
                if (flag) {
                    JOptionPane.showMessageDialog(null, n1 + " and " + n2 + " ARE amicable numbers");
                } else {
                    JOptionPane.showMessageDialog(null, n1 + " and " + n2 + " are NOT amicable numbers");
                }
            }//end while

        }//end try
        catch (IOException ex) {
            System.err.println(ex);
        }//end catch
    }//end main
}//end class
