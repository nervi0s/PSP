package unidad3_ejercicio1;

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

    public static void main(String[] args) {
        String host = "localhost";
        int port = 50000;
        Scanner sc = new Scanner(System.in);

        System.out.println("Programa cliente iniciado...");
        try {
            //Obtenemos los datos para crear el objeto
            Socket socketLadoCliente = new Socket(host, port);
            System.out.print("Introdice tu País:");
            String pais = sc.nextLine();
            System.out.print("Introdice tu Ciudad:");
            String ciudad = sc.nextLine();
            System.out.print("Introdice tu Saludo:");
            String saludo = sc.nextLine();

            //Creamos el objeto a enviar
            Saludo saludoEnviado = new Saludo(pais, ciudad, saludo);

            //Creamos el flujo de salida
            OutputStream os = socketLadoCliente.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            //Enviamos el objeto al servidor
            oos.writeObject(saludoEnviado);

            System.out.println("Esperando respuesta del servidor...");

            //Creamos el flujo de entrada
            InputStream is = socketLadoCliente.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            //Leemos el objeto enviado por el cliente
            Saludo saludoRecibido = (Saludo) ois.readObject(); //Espera a recibir el objeto para leerlo
            System.out.println("Recibido del servirdor: El país indicado es: " + saludoRecibido.getPais()
                    + ", la ciudad: " + saludoRecibido.getCiudad() + " y el saludo: " + saludoRecibido.getSaludo());

            ois.close();
            is.close();
            oos.close();
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
