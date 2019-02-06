/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example5_Working_With_URLs;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestURLConnection {

    public static void main(String[] args) {

        URL url = null;
        try {
            url = new URL("http://www.lit.ie");
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }//end catch

        URLConnection urlConnection = null;
        try {
            urlConnection = url.openConnection();

            InputStream input = urlConnection.getInputStream();
            int data = input.read();
            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }//end while

        } catch (IOException ex) {
            System.out.println(ex);
        }//end catch
    }

}
