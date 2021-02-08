package demo_07_Socket_UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo_07_ClienteSocket_UDP2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            InetAddress ipDestino = InetAddress.getByName("localhost");
            int puertoDestino = 50000;

            byte[] mensaje;

            System.out.print("Introduce mensaje: ");
            String mensajeParaServer = sc.nextLine();

            mensaje = mensajeParaServer.getBytes();

            //Construímos el DatagramPacket
            DatagramPacket datagramaAEnviar = new DatagramPacket(mensaje, mensaje.length, ipDestino, puertoDestino);

            //Creamos en DatagramSocket
            DatagramSocket socketLadoCliente = new DatagramSocket();

            socketLadoCliente.send(datagramaAEnviar);

            System.out.println("Esperando datagrama...");

            byte[] buffer = new byte[1024];

            DatagramPacket datagramaARecibir = new DatagramPacket(buffer, buffer.length);

            socketLadoCliente.receive(datagramaARecibir);

            System.out.println("Recibo Nº de caracteres que son a => " + new String(datagramaARecibir.getData()));

            socketLadoCliente.close();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (SocketException ex) {
            Logger.getLogger(Demo_07_ClienteSocket_UDP2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Demo_07_ClienteSocket_UDP2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
