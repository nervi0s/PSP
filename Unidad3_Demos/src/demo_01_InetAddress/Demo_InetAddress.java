package demo_01_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo_InetAddress {

    public static void main(String[] args) {
        InetAddress ip;

        try {
            ip = InetAddress.getByName("www.google.es");
            System.out.println(ip);
            System.out.println("Nombre del host: " + ip.getHostName());
            System.out.println("Dirección ip del host: " + ip.getHostAddress());
        } catch (UnknownHostException ex) {
            //Logger.getLogger(Demo_InetAddress.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

}
