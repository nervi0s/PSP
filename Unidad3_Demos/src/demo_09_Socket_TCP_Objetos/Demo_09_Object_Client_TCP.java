package demo_09_Socket_TCP_Objetos;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Demo_09_Object_Client_TCP {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50000;
        String condition = "";
        try {

            Socket socketLadoCliente = new Socket(host, puerto);

            System.out.println("Programa cliente iniciado");
            InputStream is = null;
            ObjectInputStream ObjetoEntrada = null;
            OutputStream os = null;
            ObjectOutputStream ObjetoSalida = null;
            while (!condition.equals("*")) {
                //Flujo de entrada para recibir el mensaje del servidor
                is = socketLadoCliente.getInputStream();
                ObjetoEntrada = new ObjectInputStream(is);
                Persona personaRecibida = (Persona) ObjetoEntrada.readObject();

                System.out.println("Datos recibidos del servidor: \n"
                        + "Nombre: " + personaRecibida.nombre + "\n"
                        + "Edad: " + personaRecibida.edad);

                //Flujo de salida para el mensaje del servidor
                os = socketLadoCliente.getOutputStream();
                ObjetoSalida = new ObjectOutputStream(os);
                Scanner sc = new Scanner(System.in);
                System.out.print("Modifica el nombre: ");
                personaRecibida.nombre = sc.nextLine();
                condition = personaRecibida.nombre;
                System.out.print("\nModifica la edad: ");
                personaRecibida.edad = sc.nextInt();

                System.out.println("Datos modificados a enviar al servidor: \n"
                        + "Nombre: " + personaRecibida.nombre + "\n"
                        + "Edad: " + personaRecibida.edad);

                ObjetoSalida.writeObject(personaRecibida);
            }
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
