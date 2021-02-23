package unidad3_ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        int port = 50000;

        try {
            ServerSocket servidor = new ServerSocket(port);
            System.out.println("Esperando a cliente...");
            Socket socketLadoServidor = servidor.accept();

            //Creamos el flujo de entrada
            InputStream is = socketLadoServidor.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            //Leemos el objeto enviado por el cliente
            Saludo saludo = (Saludo) ois.readObject(); //Espera a recibir el objeto para leerlo
            System.out.println("Saludo recibido: " + saludo);

            //Creamos el flujo de salida
            OutputStream os = socketLadoServidor.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            //Enviamos el objeto al cliente
            oos.writeObject(saludo);

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
