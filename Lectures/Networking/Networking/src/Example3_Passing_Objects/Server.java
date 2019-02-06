package Example3_Passing_Objects;
// Server.java: The server accepts data from the client, processes it
// and returns the result back to the client

import java.io.*;
import java.net.*;

public class Server {

    /**
     * Main method
     */
    public static void main(String[] args) {
        try {

            System.out.println("Server started and awaiting connections....");
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8111);

            // Start listening for connections on the server socket
            Socket connectToClient = serverSocket.accept();

            // Create an input stream to get data from the client
            ObjectInputStream isFromClient = new ObjectInputStream(connectToClient.getInputStream());

            Student student = (Student) isFromClient.readObject();

            System.out.println("Student Details");
            System.out.println(student);
            
            
        }//end try
        catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }
}
