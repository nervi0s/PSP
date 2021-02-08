package demo_06_Socket_UDP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo_06_ServidorSocket_UDP1 {

    public static void main(String[] args) {
        //Mensaje a recibir
        byte[] buffer = new byte[1024];

        try {
            //Creamos el Socktet
            DatagramSocket socketLadoServidor = new DatagramSocket(50000);
            //Esperamos el datagrama del cliente:
            System.out.println("Estamos esperamos el datagrama del cliente.");
            DatagramPacket datagramaARecibir = new DatagramPacket(buffer, buffer.length);

            socketLadoServidor.receive(datagramaARecibir);

            int bytesRecibidos = datagramaARecibir.getLength();

            String cadenaRecibida = new String(datagramaARecibir.getData());

            //VISUALIZO INFORMACIÓN
            System.out.println("Número de Bytes recibidos: " + bytesRecibidos);
            System.out.println("Contenido del Paquete    : " + cadenaRecibida.trim());
            System.out.println("Puerto origen del mensaje: " + datagramaARecibir.getPort());
            System.out.println("IP de origen             : "
                    + datagramaARecibir.getAddress().getHostAddress());
            System.out.println("Puerto destino del mensaje:");

            socketLadoServidor.close();
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Demo_06_ServidorSocket_UDP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
