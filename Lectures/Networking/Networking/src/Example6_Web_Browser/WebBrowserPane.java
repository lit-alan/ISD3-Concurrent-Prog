package Example6_Web_Browser;
// WebBrowserPane.java
// WebBrowserPane is a simple Web-browsing component that 
// extends JEditorPane and maintains a history of visited URLs.

import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class WebBrowserPane extends JEditorPane {
   
   private List history = new ArrayList();
   private int historyIndex;
   
   // WebBrowserPane constructor
   public WebBrowserPane()  {
       // disable editing to enable hyperlinks
      setEditable( false );
   }
   
   // display given URL and add it to history
   public void goToURL( URL url ) { 
      displayPage( url );
      history.add( url ); 
      historyIndex = history.size() - 1;
    }
   
   // display next history URL in editorPane
   public URL forward()  {
      historyIndex++;
      
      // do not go past end of history
      if ( historyIndex >= history.size() )
         historyIndex = history.size() - 1;
      
      URL url = ( URL ) history.get( historyIndex );
      displayPage( url );
         
      return url;
   }
   
   // display previous history URL in editorPane
   public URL back() {
      historyIndex--;
      
      // do not go past beginning of history
      if ( historyIndex < 0 )
         historyIndex = 0;
      
      // display previous URL
      URL url = ( URL ) history.get( historyIndex );
      displayPage( url );

      return url;      
   }
   
   // display given URL in JEditorPane
   private void displayPage( URL pageURL ) {
      
    
      
      // display URL
      try {
      	  setPage( pageURL );
      }

      // handle exception reading from URL
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }
   }     
}