package unidad3_ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        int port = 50000;
        String host = "localhost";

        Scanner sc = new Scanner(System.in);
        String mensaje = "";

        try {
            Socket socketLadoCliente = new Socket(host, port);

            InputStream is = socketLadoCliente.getInputStream();
            OutputStream os = socketLadoCliente.getOutputStream();
            DataOutputStream mensajeSalida = new DataOutputStream(os);
            DataInputStream mensajeEntrada = new DataInputStream(is);

            while (!mensaje.equals("*")) {
                System.out.print("Introdouce cadena: ");
                mensaje = sc.nextLine();

                mensajeSalida.writeUTF(mensaje);

                String mensajeEntrante = mensajeEntrada.readUTF();

                System.out.println(mensajeEntrante);

                if (mensajeEntrante.equals("=>ECO: *")) {
                    System.out.println("Fin del envio...");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
