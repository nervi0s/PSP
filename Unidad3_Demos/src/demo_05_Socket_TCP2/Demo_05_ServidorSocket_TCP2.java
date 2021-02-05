package demo_05_Socket_TCP2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_05_ServidorSocket_TCP2 {

    public static void main(String[] args) {
        int puerto = 50000;
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());

            Socket socketLadoServidor = servidor.accept();

            /////////Flujo de entrada para recibir mensaje del cliente
            InputStream is = socketLadoServidor.getInputStream();
            //BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(is));
            DataInputStream flujoEntrada = new DataInputStream(is);
            /*System.out.println("Recibido del cliente: "
                    + (char)is.read() + " --- ");*/
            System.out.println("Recibido del cliente: "
                    + flujoEntrada.readUTF() + " --- ");
            /////////Flujo de salida para enviar al clinte:
            OutputStream os = socketLadoServidor.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(os);
            flujoSalida.writeUTF("Hola, soy un mensaje de servidor");

            //Cierrar los Streams y los sockets
            is.close();
            flujoEntrada.close();
            os.close();
            flujoSalida.close();

            socketLadoServidor.close();
            servidor.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
