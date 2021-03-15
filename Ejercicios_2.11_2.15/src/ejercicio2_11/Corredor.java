package ejercicio2_11;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread {

    private final String nombre;
    private final int tiempoDemora; //Tiempo que tarda en completar su tarea en milisegundos
    private final Testigo testigo;
    private long tiempoTotal;

    private boolean tareaCompletada;

    public Corredor(String nombre, int tiempo, Testigo testigo) {
        this.nombre = nombre;
        this.tiempoDemora = tiempo;
        this.testigo = testigo;
    }

    @Override
    public void run() {
        correr();
    }

    public void correr() {
        System.out.printf("Corredor %s empieza a correr.%n", nombre);
        tiempoTotal = System.currentTimeMillis();
        //Simulamos la demora en completar su recorrido hasta poder pasar el testigo
        try {
            sleep(tiempoDemora);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Corredor %s ha finalizado de correr y pasa el testigo.%n", nombre);
        tareaCompletada = true;
        tiempoTotal = System.currentTimeMillis() - tiempoTotal;
    }

    public String obtenerTiempoTotal() {
        return tiempoTotal + "";
    }

    public void usarTestigo() {

    }

    public void pasarTestigo() {

    }

}
