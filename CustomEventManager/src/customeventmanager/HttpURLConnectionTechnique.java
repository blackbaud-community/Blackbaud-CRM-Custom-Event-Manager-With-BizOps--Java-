package customeventmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionTechnique {
    public static String XMLFileContentsToString (String soapFile) throws FileNotFoundException {
        String soapMessage = new Scanner
            (new File(soapFile)).useDelimiter("\\A").next();
    return soapMessage;
    };
    
    static class MyAuthenticator extends Authenticator {
        String name;
        String password;
        private MyAuthenticator(String name1, String password1) {
            name = name1;
            password = password1;
        }
        @Override
            public PasswordAuthentication getPasswordAuthentication() {
                System.out.println("Authenticating...");
                return new PasswordAuthentication(name, password.toCharArray());
            }
    }; 
    
    public static String createHttpURLConnectionAndMakeRequest(String passSoapMessage, String passURLString, Boolean useHttps) throws MalformedURLException, FileNotFoundException, IOException{

        //Authenticator.setDefault(new MyAuthenticator("",""));

        String lvSoapMessage = passSoapMessage;
        
        //Create connection
        String URLString = passURLString;
        URL URLForSOAP = new URL(URLString);
        URLConnection URLConnectionForSOAP = URLForSOAP.openConnection();
        String responseString = "";
        if (useHttps) {
            HttpsURLConnection Connection = (HttpsURLConnection) URLConnectionForSOAP;
            //Adjust connection
            Connection.setDoOutput(true);
            Connection.setDoInput(true);
            Connection.setRequestMethod("POST");
            //missing host name here
            Connection.setRequestProperty("Host", "");
            Connection.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
            Connection.setRequestProperty("Connection","Keep-Alive");
            //Send the request
            OutputStreamWriter soapRequestWriter = new OutputStreamWriter(Connection.getOutputStream());
            soapRequestWriter.write(lvSoapMessage);
            System.out.println(lvSoapMessage);
            soapRequestWriter.flush();
            //Read the reply
            BufferedReader soapRequestReader = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
            String line;
            while ((line = soapRequestReader.readLine()) != null) {
                //System.out.println(line);
                responseString = responseString.concat(line);
                }
            soapRequestWriter.close();
            soapRequestReader.close();
            Connection.disconnect();
        }
        else{
            HttpURLConnection Connection = (HttpURLConnection) URLConnectionForSOAP;
            //Adjust connection
            Connection.setDoOutput(true);
            Connection.setDoInput(true);
            Connection.setRequestMethod("POST");
            Connection.setRequestProperty("Host", "localhost");
            Connection.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
            //Send the request
            OutputStreamWriter soapRequestWriter = new OutputStreamWriter(Connection.getOutputStream());
            soapRequestWriter.write(lvSoapMessage);
            soapRequestWriter.flush();
            //Read the reply
            
            BufferedReader soapRequestReader = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
            String line;
            while ((line = soapRequestReader.readLine()) != null) {
                System.out.println(line);
                responseString = responseString.concat(line);
                }
            soapRequestWriter.close();
            soapRequestReader.close();
            Connection.disconnect();
        }
        
        return responseString;
    };
}
