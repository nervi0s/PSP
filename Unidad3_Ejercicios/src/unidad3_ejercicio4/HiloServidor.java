package unidad3_ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloServidor extends Thread {

    private final Socket socket;
    private final InputStream is;
    private final OutputStream os;
    private DataInputStream mensajeEntrada;
    private DataOutputStream mensajeSalida;
    private String mensaje = "";

    public HiloServidor(Socket socket) throws IOException {
        this.socket = socket;
        is = this.socket.getInputStream();
        os = this.socket.getOutputStream();
    }

    @Override
    public void run() {
        mensajeSalida = new DataOutputStream(os);
        mensajeEntrada = new DataInputStream(is);

        while (!mensaje.equals("*")) {
            //System.out.println("EN COMUNICACIÓN CON: " + socket);
            try {
                mensaje = mensajeEntrada.readUTF();
                System.out.println("EN COMUNICACIÓN CON: " + socket);
                mensaje = mensaje.toUpperCase();
                mensajeSalida.writeUTF("=>ECO: " + mensaje);
                if (mensaje.equals("*")) {
                    System.out.println("COMUNUCACIÓN FINALIZADA CON: " + socket);
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
