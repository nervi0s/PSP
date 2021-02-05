package demo_04_Socket_TCP1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Demo_04_ClienteSocket_TCP1 {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50000;

        try {
            //System.out.println(InetAddress.getLocalHost());
            Socket socketLadoCliente = new Socket(host, puerto);
            System.out.println("Puerto local aleatorio: " + socketLadoCliente.getLocalPort());

            InetAddress ip = socketLadoCliente.getInetAddress();

            System.out.println("El puerto remoto del server es: " + socketLadoCliente.getPort());
            System.out.println("El host remoto del server es: " + ip.getHostName());
            System.out.println("La IP del host remoto del server es: " + ip.getHostAddress());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
