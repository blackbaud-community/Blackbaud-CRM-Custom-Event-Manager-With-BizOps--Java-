/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customeventmanager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author TomTr
 */
public class MessageAdjustments {
    public static void populateSOAPFile (String filePath, String messageFragment) throws IOException {
        String lvFilePath = filePath;
        String lvMessageFragment = messageFragment;
        String top = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
"  <;soap12:Body>\n";         
        String bottom = "  </soap12:Body>\n" +
"</soap12:Envelope>";
        FileWriter soapMessageFile = new FileWriter(lvFilePath);
        PrintWriter out = new PrintWriter(soapMessageFile);
        out.print(top + lvMessageFragment + bottom);
    }

    public static String fixSOAPRequestMessage (String messageFragment) throws IOException {
        String lvMessageFragment = messageFragment.substring(56);
        String top = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
"  <soap12:Body>\n";         
        String bottom = "  </soap12:Body>\n" +
"</soap12:Envelope>";
        String wholeMessage = top + lvMessageFragment + bottom;
        return wholeMessage;
    }
    
    public static String stripSOAPReplyMessage (String messageFragment) throws IOException {
        String strippedMessage = messageFragment;
        //two levels of escaping RegEx and Java
        //handle nulls?
        String badString = "xsi:nil=\"true\"";
        strippedMessage = strippedMessage.replaceAll(badString, "");
        
        strippedMessage = strippedMessage.substring(216, strippedMessage.length()-28);
        return strippedMessage;
    }
}
