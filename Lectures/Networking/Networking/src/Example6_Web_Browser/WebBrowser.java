package Example6_Web_Browser;

// WebBrowser.java
// WebBrowser is an application for browsing Web sites using
// a WebToolBar and WebBrowserPane.


// Java core packages
import java.awt.*;


// Java extension packages
import javax.swing.*;

public class WebBrowser extends JFrame {
   
   private WebToolBar toolBar;
   private WebBrowserPane browserPane;
   
   // WebBrowser constructor
   public WebBrowser()
   {     
      super( "Basic Web Browser" );
      
      // create WebBrowserPane and WebToolBar for navigation
      browserPane = new WebBrowserPane();      
      toolBar = new WebToolBar( browserPane );
      //themenuBar = new FileMenubar(browserPane);
      //setJMenuBar(themenuBar.bar);
      
      // lay out WebBrowser components
      Container contentPane = getContentPane();
      contentPane.add( toolBar, BorderLayout.NORTH );  
      contentPane.add( new JScrollPane( browserPane ), 
         BorderLayout.CENTER );
   }
   
   // execute application
   public static void main( String args[] )
   {
      WebBrowser browser = new WebBrowser();
      browser.setDefaultCloseOperation( EXIT_ON_CLOSE );
      browser.setSize( 640, 480 );
      browser.setVisible( true );
   }
}