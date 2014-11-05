/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customeventmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.xml.bind.JAXBException;


/**
 *
 * @author TomTr
 */
public class CustomEventManager {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, IOException, JAXBException {
        
        Form1JFrame customEventManagerMainJFrame = new Form1JFrame();
        customEventManagerMainJFrame.setVisible(true);

    }
}
