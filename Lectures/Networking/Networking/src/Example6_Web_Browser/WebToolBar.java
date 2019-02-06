package Example6_Web_Browser;

// WebToolBar.java
// WebToolBar is a JToolBar subclass that contains components
// for navigating a WebBrowserPane. WebToolBar includes back
// and forward buttons and a text field for entering URLs.

import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

public class WebToolBar extends JToolBar implements HyperlinkListener {
   
   private WebBrowserPane webBrowserPane;
   private JButton backButton;
   private JButton forwardButton;
   private JTextField urlTextField;
   
   // WebToolBar constructor
   public WebToolBar( WebBrowserPane browser ) {
      super( "Web Navigation" );
      
      // register for HyperlinkEvents
      webBrowserPane = browser;
      webBrowserPane.addHyperlinkListener( this );

      // create JTextField for entering URLs
      urlTextField = new JTextField( 25 );      
      urlTextField.addActionListener(
         new ActionListener() {
            
            // navigate webBrowser to user-entered URL
            public void actionPerformed( ActionEvent event ) {
               // attempt to load URL in webBrowserPane
               try {
                  URL url = new URL( urlTextField.getText() ); 
                  System.out.println("URL = " + url);
                  webBrowserPane.goToURL( url );
               }

               // handle invalid URL
               catch ( MalformedURLException urlException ) {
                  urlException.printStackTrace();
               }
            }
         }
      );
      
      // create JButton for navigating to previous history URL
      backButton = new JButton(new ImageIcon(getClass().getResource("images/back.gif")));
      
      backButton.addActionListener(
         new ActionListener() {
            
            public void actionPerformed( ActionEvent event )
            {
               // navigate to previous URL
               URL url = webBrowserPane.back();
               
               // display URL in urlTextField
               urlTextField.setText( url.toString() );
            }
         }
      );
      
      // create JButton for navigating to next history URL
      forwardButton = new JButton(new ImageIcon(getClass().getResource("images/forward.gif")));
      
      forwardButton.addActionListener(
         new ActionListener() {
            
            public void actionPerformed( ActionEvent event )
            {
               // navigate to next URL
               URL url = webBrowserPane.forward();
               
               // display new URL in urlTextField
               urlTextField.setText( url.toString() );
            }
         }
      );      

      // add JButtons and JTextField to WebToolBar
      add( backButton );
      add( forwardButton );
      add( urlTextField );
     
   } // end WebToolBar constructor
   
   // listen for HyperlinkEvents in WebBrowserPane
   public void hyperlinkUpdate( HyperlinkEvent event )
   {
      // if hyperlink was activated, go to hyperlink's URL
      if ( event.getEventType() == 
         HyperlinkEvent.EventType.ACTIVATED ) {
            
         // get URL from HyperlinkEvent
         URL url = event.getURL();
         
         // navigate to URL and display URL in urlTextField
         webBrowserPane.goToURL( url );
         urlTextField.setText( url.toString() );
      }
   }   
}