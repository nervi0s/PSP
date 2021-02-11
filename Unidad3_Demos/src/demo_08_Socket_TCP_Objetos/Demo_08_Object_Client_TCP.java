package demo_08_Socket_TCP_Objetos;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo_08_Object_Client_TCP {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50000;

        try {

            Socket socketLadoCliente = new Socket(host, puerto);
            System.out.println("Programa cliente iniciado");

            //Flujo de entrada para recibir el mensaje del servidor
            InputStream is = socketLadoCliente.getInputStream();
            ObjectInputStream ObjetoEntrada = new ObjectInputStream(is);
            Persona personaRecibida = (Persona) ObjetoEntrada.readObject();

            System.out.println("Datos recibidos del servidor: \n"
                    + "Nombre: " + personaRecibida.nombre + "\n"
                    + "Edad: " + personaRecibida.edad);

            //Flujo de salida para el mensaje del servidor
            OutputStream os = socketLadoCliente.getOutputStream();
            ObjectOutputStream ObjetoSalida = new ObjectOutputStream(os);

            personaRecibida.nombre = personaRecibida.nombre + " Olito";
            personaRecibida.edad = 2020;

            System.out.println("Datos modificados a enviar al servidor: \n"
                    + "Nombre: " + personaRecibida.nombre + "\n"
                    + "Edad: " + personaRecibida.edad);

            ObjetoSalida.writeObject(personaRecibida);

            //Cierrar los Streams y los sockets
            os.close();
            ObjetoEntrada.close();
            is.close();
            ObjetoSalida.close();

            socketLadoCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
