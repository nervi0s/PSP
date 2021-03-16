package ejercicio2_11;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Carrera {

    public static void main(String[] args) {

        Corredor c1 = new Corredor("Pepe", Testigo.testigo);
        Corredor c2 = new Corredor("Juan", Testigo.testigo);
        Corredor c3 = new Corredor("Luis", Testigo.testigo);

        c1.setCorredorDestino(c2);
        c2.setCorredorDestino(c3);

        c1.start();

        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.printf("El tiempo total de la carreta ha sido: %d%n", c1.obtenerTiempoParcial() + c2.obtenerTiempoParcial() + c3.obtenerTiempoParcial());
    }
}
