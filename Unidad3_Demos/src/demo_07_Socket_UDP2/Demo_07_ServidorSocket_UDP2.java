package demo_07_Socket_UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo_07_ServidorSocket_UDP2 {

    public static void main(String[] args) {
        //Mensaje a recibir
        byte[] buffer = new byte[1024];

        try {
            //Creamos el Socktet
            DatagramSocket socketLadoServidor = new DatagramSocket(50000);
            //Esperamos el datagrama del cliente:
            System.out.println("Servidor Esperando Datagrama...");
            DatagramPacket datagramaARecibir = new DatagramPacket(buffer, buffer.length);

            socketLadoServidor.receive(datagramaARecibir);

            int bytesRecibidos = datagramaARecibir.getLength();

            String cadenaRecibida = new String(datagramaARecibir.getData());

            //VISUALIZO INFORMACIÓN
            System.out.println("Servidor recibe: " + cadenaRecibida);
            System.out.println("Enviando en número de apariciones de la letra a => : " + getMatches(cadenaRecibida));

            String info = String.valueOf(getMatches(cadenaRecibida));
            DatagramPacket datagramaAEnviar = new DatagramPacket(info.getBytes(), info.length(), datagramaARecibir.getAddress(), datagramaARecibir.getPort());

            socketLadoServidor.send(datagramaAEnviar);

            System.out.println("Cerrando Conexión");

            socketLadoServidor.close();
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Demo_07_ServidorSocket_UDP2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getMatches(String str) {
        str = str.toLowerCase();
        int matches = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                matches++;
            }
        }
        return matches;
    }
}
