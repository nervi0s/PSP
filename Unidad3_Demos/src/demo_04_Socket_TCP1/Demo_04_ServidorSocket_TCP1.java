package demo_04_Socket_TCP1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_04_ServidorSocket_TCP1 {

    /* private ServerSocket svSocket;
    private Socket socket;
    
    public Demo_04_ServidorSocket_TCP1(int puerto){
        //this.s
    }*/
    public static void main(String[] args) {
        int puerto = 50000;
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());

            Socket socketLadoServidor = servidor.accept();

            servidor.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
