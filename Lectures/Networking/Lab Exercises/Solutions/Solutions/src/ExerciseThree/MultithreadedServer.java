package ExerciseThree;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultithreadedServer {

    private static ServerSocket server;
    private static Socket connection;

    public static void main(String args[]) {
        try {
            
            System.out.println("Server started at " + new Date() + " and is awaiting connections");
            //create server socket
            server = new ServerSocket(8080);
            
            //continually handle client requests
            while (true) {
                
                //accept client connection
                connection = server.accept();
                
                //create and start a thread for every connected client
                HandleAClient thread = new HandleAClient(connection);
                thread.start();
            }//end while
        
        }//end try
        
        catch (Exception ex) {
            System.out.println(ex.toString());
        }//end catch

    } // end main

} //end class MultithreadedServer

class HandleAClient extends Thread {

    private final Socket connectToClient;

    /**
     * Construct a thread
     */
    public HandleAClient(Socket socket) {
        connectToClient = socket;
    }

    @Override
    public void run() {
        try {
            // set up streams
            DataInputStream isFromClient = 
                    new DataInputStream(connectToClient.getInputStream());
            DataOutputStream osToClient = 
                    new DataOutputStream(connectToClient.getOutputStream());
            
            // Continuously serve the client
            while (true) {
                
                // Receive values from the client
                int n1 = isFromClient.readInt();
                int n2 = isFromClient.readInt();
                
                // determine if amicable
                boolean flag = determineIfAmicable(n1, n2);

                // Send flag back to the client
                osToClient.writeBoolean(flag);
                
            }//end while
        }//end try
        catch (IOException ex) {
            System.err.println(ex);
        }//end catch
    }//end run

    private boolean determineIfAmicable(int n1, int n2) {
        int sum1 = 0, sum2 = 0;

        for (int i = 1; i <= (n1 / 2); i++) {
            if (n1 % i == 0) {
                sum1 += i;
            }
        }

        for (int i = 1; i <= (n2 / 2); i++) {
            if (n2 % i == 0) {
                sum2 += i;
            }//end if
        }//end for
        
        return sum1 == n2 && sum2 == n1;

    }//end method
}//end thread class
