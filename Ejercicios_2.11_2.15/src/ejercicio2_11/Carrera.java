package ejercicio2_11;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Carrera {

    public static void main(String[] args) {
        Corredor c1 = new Corredor("Pepe", 5000, Testigo.testigo);
        c1.start();

        try {
            c1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(c1.obtenerTiempoTotal());
    }
}
