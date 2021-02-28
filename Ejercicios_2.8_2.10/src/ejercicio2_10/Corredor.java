package ejercicio2_10;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread {

    private Carrera carrera;
    private final String nombre;
    private final int sleep;

    public Corredor(String nombre, int sleep) {
        this.nombre = nombre;
        this.sleep = sleep;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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
            if (!carrera.getExisteGanador()) {
                if (i % 100 == 0) {
                    System.out.printf("El corredor %s del la %s, lleva %dm%n", nombre, carrera.getNombreCarrera(), i);
                }
            } else {
                return;
            }
        }
        carrera.setExisteGanador(true);
        System.out.printf("***** El corredor %s ha finalizado la prueba. %s *****%n", nombre, carrera.getNombreCarrera());
    }

}
