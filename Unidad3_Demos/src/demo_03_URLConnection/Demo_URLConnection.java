package demo_03_URLConnection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Demo_URLConnection {

    public static void main(String[] args) {
        URL url = null;
        URLConnection connection = null;

        try {
            url = new URL("http://example.net");
            connection = url.openConnection();

            InputStream is = connection.getInputStream();
            System.out.println(connection.getContentType());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //BufferedInputStream bis = new BufferedInputStream(is);
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }

            br.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
