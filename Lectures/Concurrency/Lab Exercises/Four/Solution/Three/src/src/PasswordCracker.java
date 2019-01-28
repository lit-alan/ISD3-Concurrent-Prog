package src;

import com.sun.rowset.JdbcRowSetImpl;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.sql.RowSet;

/**
 *
 * @author Alan.Ryan
 * Passwords for this app are as follows (in plaintext)
 * 
 *       alan.ryan         => thursday
 *       des.ocarroll      => darkness
 *       ita.kavanagh      => appropriate 
 *       carol.rainsford   => type
 *       ken.oakley        => limerick
 *       lorraine.callanan => surplus
 *       willie.ward       => william
 *       oliver.hyde       => pld34DrRRtf33sas
 *       seamus.doyle      => p6ufMTmc36RD
 *       mike.oconnell     => password1
 *       elizabeth.bourke  => pps3DFeBN4Fddfs
 *       lindy.farmer      => 9dEerDacb452Sasa
 *       brendan.watson    => cloudy
 *       neil.higgins      => hardenability
 *       suzanne.ogorman   => planning
 *       john.jennings     => asq257GtrFase3D
 *       gerry.guinane     => frequent
 * 
 * 
 */
public class PasswordCracker {

    JdbcRowSetImpl rowSet;
    List<String> passwordList;

    
    public static void main(String[] args) {
     
        new PasswordCracker();
        
    }
    
    public PasswordCracker() {
    
     
        //connect to the DB
        rowSet = connectToDB("jdbc:mysql://localhost:3306/isd3exam", "root", "");
        
        //read the words from the file
        passwordList = readPlaintextPasswords("dictionary.txt");
        
        //output how many potential passwords are in the list
        System.out.println("# of passwords in file " + passwordList.size());
        
        //create thread to search the file
        CrackIt thread = new CrackIt(rowSet, passwordList);
        
        //start the thread
        thread.start();

    }//end const

    /////////////////////////////////////////////////////////////////////////////////
    
    private static String hashPassword(String algorithm, String password) {

        StringBuilder sb = new StringBuilder();

        try {

            MessageDigest messaged = MessageDigest.getInstance(algorithm);
            messaged.update(password.getBytes());
            byte[] mdArray = messaged.digest();
            sb = new StringBuilder(mdArray.length * 2);

            for (byte b : mdArray) {
                int v = b & 0xff;
                if (v < 16) {
                    sb.append('0');
                }//end if
                sb.append(Integer.toHexString(v));
            }//end for

        }//end for
        catch (NoSuchAlgorithmException nsae) {
            System.out.println(nsae);
        }//end catch

        return sb.toString();
    }//end hashPassword()

///////////////////////////////////////////////////////////////////////////////////////////////
    
    private static JdbcRowSetImpl connectToDB(String url, String username, String password) {

        JdbcRowSetImpl rowSet = new JdbcRowSetImpl();

        try {
            rowSet.setUrl(url);
            rowSet.setUsername(username);
            rowSet.setPassword(password);
            rowSet.setCommand("SELECT * FROM users");
            rowSet.execute();
        }//end try
        catch(Exception ex)  {
            System.out.println(ex);
        }//end catch
        
        return rowSet;

    }//end connectToDB()

    ///////////////////////////////////////////////////////////////////////
    private static List<String> readPlaintextPasswords(String file) {
        
        Path path = Paths.get(file);
        
        List<String> passwords = null;
        
        try {
            
            passwords  = Files.readAllLines(path, Charset.forName("UTF-8"));
             
            
        }//end try
        catch (IOException ioe) {
            System.out.println(ioe);
        }//end catch
   
        return passwords;
        
    }//end readPlaintextPasswords()
    
    class CrackIt extends Thread {

        JdbcRowSetImpl rowSet;
        List<String> wordList;
        
        public CrackIt(JdbcRowSetImpl rowSet, List<String> wordList) {
            
            this.rowSet = rowSet;
            this.wordList = wordList;
        
        }//end const
        
        @Override
        public void run() {
            
            try {
            while (rowSet.next()) {
                
                for (String aWord : wordList) {
                    if (rowSet.getString("Password").equals(hashPassword("MD5", aWord))) {
                        System.out.println("password for " +  rowSet.getString("Username") + " is " + aWord );
                    }//end if
                }//end for
                
                
            }//end while
        }//end try//end try
        catch (SQLException ex) {
            System.out.println(ex);
        }//end catch
           
        }//end run
        
        
    }//end class CrackIt

}//end class PasswordCracker