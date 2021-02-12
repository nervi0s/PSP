package demo_09_Socket_TCP_Objetos;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_09_Object_Server_TCP {

    public static void main(String[] args) {
        String condition = "";
        int puerto = 50000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());
            System.out.println("Esperando al cliente");

            Socket socketLadoServidor = servidor.accept();

            /////////Flujo de salida para enviar al clinte:
            OutputStream os = socketLadoServidor.getOutputStream();
            InputStream is = null;
            ObjectInputStream ObjetoEntrada = null;
            ObjectOutputStream ObjetoSalida = null;
            while (!condition.equals("*")) {
                ObjetoSalida = new ObjectOutputStream(os);
                Persona personaEnviada = new Persona("Luis", 38);
                System.out.println("Datos a enviar al cliente: \n"
                        + "Nombre: " + personaEnviada.nombre + "\n"
                        + "Edad: " + personaEnviada.edad);

                ObjetoSalida.writeObject(personaEnviada);

                /////////Flujo de entrada para recibir mensaje del cliente
                is = socketLadoServidor.getInputStream();
                ObjetoEntrada = new ObjectInputStream(is);
                /////////Lectura del objeto persona
                Persona personaRecibida = (Persona) ObjetoEntrada.readObject();

                System.out.println("Datos a recibidos (Objeto recibido del cliente): \n"
                        + "Nombre: " + personaRecibida.nombre + "\n"
                        + "Edad: " + personaRecibida.edad);

                condition = personaRecibida.nombre;
            }
            //Cierrar los Streams y los sockets
            is.close();
            ObjetoEntrada.close();
            os.close();
            ObjetoSalida.close();

            socketLadoServidor.close();
            servidor.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
