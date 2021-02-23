package unidad3_ejercicio4;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        int port = 50000;

        try {
            ServerSocket servidor = new ServerSocket(port);
            System.out.println("Servidor Iniciado...");
            while (true) {
                new HiloServidor(servidor.accept()).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
