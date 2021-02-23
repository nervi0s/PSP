package unidad3_ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 50000;
        Scanner sc = new Scanner(System.in);
        boolean hayUnAsterisco = false;

        Socket socketLadoCliente = new Socket(host, port);
        try {
            //Creamos nuestros Streams
            InputStream is = socketLadoCliente.getInputStream();
            OutputStream os = socketLadoCliente.getOutputStream();
            ObjectOutputStream objetoSalida = new ObjectOutputStream(os);
            ObjectInputStream objetoEntrada = new ObjectInputStream(is); //Espera a leer el ObjectOutputStream del otro lado (Cliente)

            while (!hayUnAsterisco) {
                //Pedimos dato para crear el objeto Saludo
                System.out.println("Programa Cliente Inciado...");
                System.out.print("Introduce tu País: ");
                String pais = sc.nextLine();
                System.out.print("Introduce tu Ciudad: ");
                String ciudad = sc.nextLine();
                System.out.print("Introduce tu Saludo: ");
                String saludo = sc.nextLine();
                //Creamos el objeto Saludo y comprobamos si algún campo es un '*'
                Saludo saludoEnviado = new Saludo(pais, ciudad, saludo);
                hayUnAsterisco = saludoEnviado.contieneAsterisco();
                //Enviamos nuestro objeto a través del OutputStream usando una envoltura de ObjectOutputStream
                objetoSalida.writeObject(saludoEnviado);

                System.out.println("Esperando respuesta del servidor:");

                //Leemos nuestro objeto a través del InputStream usando una envoltura de ObjectInputStream
                Saludo saludoEntrate = (Saludo) objetoEntrada.readObject(); //Espera a leer

                //Si recibimos un objeto nulo, tenemos que mostrar un mensaje de que acabará el programa
                if (saludoEntrate != null) {
                    System.out.println("Recibido del servidor: El país indicado es: " + saludoEntrate.getPais()
                            + ", la ciudad: " + saludoEntrate.getCiudad() + " y el saludo: " + saludoEntrate.getSaludo());
                } else {
                    System.out.println("Recibido del servidor: Fin del programa");
                }
            }
            //Cerramos nuestros Streams
            objetoEntrada.close();
            is.close();
            objetoSalida.close();
            os.close();
            socketLadoCliente.close();
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
