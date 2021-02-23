package unidad3_ejercicio2;

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
        String condicion = "";

        Socket socketLadoCliente = null;
        OutputStream os = null;
        ObjectOutputStream objetoSalida = null;
        InputStream is = null;
        ObjectInputStream objetoEntrada = null;
        socketLadoCliente = new Socket(host, port);
        try {
            while (!condicion.equals("*")) {

                System.out.println("Programa Cliente Inciado...");
                System.out.print("Introduce tu País: ");
                String pais = sc.nextLine();
                condicion = pais;
                System.out.print("Introduce tu Ciudad: ");
                String ciudad = sc.nextLine();
                System.out.print("Introduce tu Saludo: ");
                String saludo = sc.nextLine();

                Saludo saludoEnviado = new Saludo(pais, ciudad, saludo);

                os = socketLadoCliente.getOutputStream();
                objetoSalida = new ObjectOutputStream(os);

                objetoSalida.writeObject(saludoEnviado);
                if (!condicion.equals("*")) {
                    is = socketLadoCliente.getInputStream();
                    objetoEntrada = new ObjectInputStream(is);
                    System.out.println("Esperando respuesta del servidor:");
                    Saludo saludoEntrate = (Saludo) objetoEntrada.readObject();

                    System.out.println("Recibido del servidor: El país indicado es: " + saludoEntrate.getPais()
                            + ", la ciudad: " + saludoEntrate.getCiudad() + " y el saludo: " + saludoEntrate.getSaludo());
                }
            }
            if (objetoEntrada != null && is != null) {
                objetoEntrada.close();
                is.close();

            }
            objetoSalida.close();
            os.close();
            socketLadoCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
