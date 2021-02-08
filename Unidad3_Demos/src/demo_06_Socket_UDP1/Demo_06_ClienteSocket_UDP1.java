package demo_06_Socket_UDP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo_06_ClienteSocket_UDP1 {

    public static void main(String[] args) {

        try {
            InetAddress ipDestino = InetAddress.getByName("localhost");
            int puertoDestino = 50000;

            byte[] mensaje;

            String saludo = "Hola, soy un mensaje del cliente"; //32
            mensaje = saludo.getBytes(); //Mensaje a enviar en formato byte[]

            //Construímos el DatagramPacket
            DatagramPacket datagramaAEnviar = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);

            //Creamos en DatagramSocket
            DatagramSocket socketLadoCliente = new DatagramSocket();

            //Mensajes
            System.out.println("Enviando Datagrama de longitud: " + mensaje.length);
            System.out.println("Host destino : " + ipDestino.getHostName());
            System.out.println("IP Destino : " + ipDestino.getHostAddress());
            System.out.println("Puerto local del socket: "
                    + socketLadoCliente.getLocalPort());
            System.out.println("Puerto al que envio: " + datagramaAEnviar.getPort());

            //Envío del datagrama
            socketLadoCliente.send(datagramaAEnviar);

            socketLadoCliente.close();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (SocketException ex) {
            Logger.getLogger(Demo_06_ClienteSocket_UDP1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Demo_06_ClienteSocket_UDP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
