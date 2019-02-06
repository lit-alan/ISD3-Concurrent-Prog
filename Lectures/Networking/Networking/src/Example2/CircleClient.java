// CircleClient.java: The client sends the input to the server and receives
// result back from the server
import java.io.*;
import java.net.*;
import javax.swing.*;

public class CircleClient
{
  /**Main method*/
  public static void main(String[] args)
  {
    try
    {
      // Create a socket to connect to the server
      // Socket connectToServer = new Socket("130.254.32.8", 8000);
      Socket connectToServer = new Socket("localhost", 8000);

      // Create an input stream to receive data from the server
      DataInputStream isFromServer = new DataInputStream(
        connectToServer.getInputStream());

      // Create an output stream to send data to the server
      DataOutputStream osToServer =
        new DataOutputStream(connectToServer.getOutputStream());

      // Continuously send radius and receive area from the server
      while (true)
      {
        // Read the radius from the keyboard
        String input = JOptionPane.showInputDialog("Please enter a radius: ");
        double radius = Double.parseDouble(input);

        // Send the radius to the server
        osToServer.writeDouble(radius);
        osToServer.flush();

        // Get area from the server
        double area = isFromServer.readDouble();

        // Print area on the console
        JOptionPane.showMessageDialog(null,"Area received from the server is " + area);
      }
    }
    catch (IOException ex)
    {
      System.err.println(ex);
    }
  }
}
