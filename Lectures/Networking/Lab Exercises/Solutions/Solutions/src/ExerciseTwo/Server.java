package ExerciseTwo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        System.out.println("Server started....awaiting connections");
        try {
            ServerSocket server = new ServerSocket(8008);
            while (true) {
                Socket connection = server.accept();
                HandleAClient thread = new HandleAClient(connection);
                thread.start();
            }//end while
        }//end try
        catch (Exception ex) {
            System.out.println(ex.toString());
        }//end catch

    } // end main

} //end class MultiThreadedMorseServer

class HandleAClient extends Thread {

    private Socket connectToClient;
    private Path targetFile;

    /**
     * Construct a thread
     */
    public HandleAClient(Socket socket) {
        connectToClient = socket;
        targetFile = Paths.get("afile.txt");
    }

    public void run() {
        String output = "";
        try {
            // set up input stream
            DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());

            while(true) {
                // Receive encrypted int from the client
                int number = isFromClient.readInt();

                System.out.println("number from client>>>> " + number);
                //isolate each digit
                int digit1 = number / 1000;
                int digit2 = number % 1000 / 100;
                int digit3 = number % 1000 % 100 / 10;
                int digit4 = number % 1000 % 100 % 10;

                //swap digits
                int temp = (digit1 + 3) % 10;
                digit1 = (digit3 + 3) % 10;
                digit3 = temp;

                temp = (digit2 + 3) % 10;
                digit2 = (digit4 + 3) % 10;
                digit4 = temp;

                //reassemble digit
                int decryptedNumber;
                decryptedNumber = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;

                //prepare string to write to file
                String outputString = new Date() + " Number from Client " + decryptedNumber + "\n";

                //write info to file
                Files.write(targetFile, outputString.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}//end class HandleAClient

