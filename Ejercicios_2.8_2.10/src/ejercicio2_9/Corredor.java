package ejercicio2_9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread {

    private static volatile boolean existeGanador = false;

    private final String nombre;
    private final int sleep;

    public Corredor(String nombre, int sleep) {
        this.nombre = nombre;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        correr();
    }

    public void correr() {
        for (int i = 1; i <= 800; i++) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!existeGanador) {
                if (i % 100 == 0) {
                    System.out.println("El corredor " + nombre + " lleva " + i + "m");
                }
            } else {
                return;
            }
        }
        existeGanador = true;
        System.out.printf("El corredor %s ha finalizado la prueba%n", nombre);
    }

}
