package demo_07_Socket_UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo_07_ClienteSocket_UDP2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            InetAddress ipDestino = InetAddress.getByName("10.0.3.210"); //Datos del servidor
            //InetAddress ipDestino = InetAddress.getByName("localhost"); //Datos del servidor
            int puertoDestino = 50000; //Datos del servidor

            byte[] mensajeEnBytes;

            System.out.print("Introduce mensaje: ");
            String mensajeParaServer = sc.nextLine();

            mensajeEnBytes = mensajeParaServer.getBytes();

            /*
            |----------------------------------------------|--------------------------|-------------|----------------|
            | cadena de bytes contenido del mensaje  |  longitud del mensaje  |  IP destino | Pto destino    |
            |----------------------------------------------|--------------------------|-------------|----------------|
             */
            //Construímos el DatagramPacket
            DatagramPacket datagramaAEnviar = new DatagramPacket(mensajeEnBytes, mensajeEnBytes.length, ipDestino, puertoDestino);

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
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
