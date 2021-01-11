package dam.psp;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SincronizandoHilos {

    public static void main(String[] args) {

        Thread hilo1 = new Thread(new HilosVarios());
        Thread hilo2 = new Thread(new HilosVarios());

        hilo1.start();
        try {
            hilo1.join(); // Espera a que acabe este hilo para continuar
        } catch (InterruptedException ex) {
            Logger.getLogger(SincronizandoHilos.class.getName()).log(Level.SEVERE, null, ex);
        }

        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SincronizandoHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Terminadas todas las tereas");
    }
}
