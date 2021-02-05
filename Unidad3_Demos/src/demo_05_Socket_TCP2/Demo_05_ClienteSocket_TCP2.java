package demo_05_Socket_TCP2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo_05_ClienteSocket_TCP2 {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50000;

        try {
            //System.out.println(InetAddress.getLocalHost());
            Socket socketLadoCliente = new Socket(host, puerto);
            System.out.println("Programa cliente iniciado");

            //InetAddress ip = socketLadoCliente.getInetAddress();

            /*System.out.println("El puerto remoto del server es: " + socketLadoCliente.getPort());
            System.out.println("El host remoto del server es: " + ip.getHostName());
            System.out.println("La IP del host remoto del server es: " + ip.getHostAddress());*/
            
            //Flujo de salida para el mensaje del servidor
            OutputStream os = socketLadoCliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(os);
            flujoSalida.writeUTF("Hola, soy un mensaje de cliente");

            //Flujo de entrada para recibir el mensaje del servidor
            InputStream is = socketLadoCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(is);

            System.out.println("Recibido del servidor: " + flujoEntrada.readUTF());

            //Cierrar los Streams y los sockets
            os.close();
            flujoSalida.close();
            is.close();
            flujoEntrada.close();

            socketLadoCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
