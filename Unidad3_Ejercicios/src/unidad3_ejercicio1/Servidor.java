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
        String condicion = "";

        try {
            ServerSocket servidor = new ServerSocket(port);
            System.out.println("Esperando al cliente: ");
            Socket socketLadoServidor = servidor.accept();

            InputStream is = null;
            ObjectInputStream objetoEntrada = null;
            OutputStream os = null;
            ObjectOutputStream objetoSalida = null;

            while (!condicion.equals("*")) {

                is = socketLadoServidor.getInputStream();
                objetoEntrada = new ObjectInputStream(is);

                Saludo saludoEntrante = (Saludo) objetoEntrada.readObject();
                condicion = saludoEntrante.getPais();
             
                System.out.println("Saludo recibido: " + saludoEntrante);

                if (!condicion.equals("*")) {
                    os = socketLadoServidor.getOutputStream();
                    objetoSalida = new ObjectOutputStream(os);
                    objetoSalida.writeObject(saludoEntrante);
                }
            }
            
            if (objetoSalida != null && os!=null) {
                
                objetoSalida.close();
                os.close();
            }
            objetoEntrada.close();
            is.close();
            socketLadoServidor.close();

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
