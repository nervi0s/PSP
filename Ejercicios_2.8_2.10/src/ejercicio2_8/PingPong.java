package ejercicio2_8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PingPong extends Thread {

    private final String nombre;

    public PingPong(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            showMessage();
        }
    }

    public void showMessage() {
        synchronized (PingPong.class) {
            System.out.println(nombre);
            PingPong.class.notifyAll();
            try {
                PingPong.class.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
