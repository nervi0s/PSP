package ejercicio2_11;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread {

    private final String nombreCorredor;
    private final int tiempoDemora; //Tiempo que tarda en llegar hasta su siguiente compañero en milisegundos
    private final Testigo testigo;
    private Corredor corredorDestino;
    private long tiempoVueltaCorredor;

    private boolean haRecibidoTestigo;
    private boolean tareaCompletada;

    public Corredor(String nombre, Testigo testigo) {
        this.nombreCorredor = nombre;
        this.tiempoDemora = obtenerTiempoDemoraAleatorio();
        this.testigo = testigo;
    }

    public void setCorredorDestino(Corredor c) {
        corredorDestino = c;
    }

    @Override
    public void run() {
        while (!tareaCompletada) {
            correr();
        }
    }

    public void correr() {
        tiempoVueltaCorredor = System.currentTimeMillis();
        usarTestigo();
        System.out.printf("Corredor %s empieza a correr.%n", nombreCorredor);
        //Simulamos la demora en completar su recorrido hasta poder pasar el testigo
        try {
            sleep(tiempoDemora);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (existeCorredorDestinatario()) {
            tiempoVueltaCorredor = System.currentTimeMillis() - tiempoVueltaCorredor;
            System.out.printf("Corredor %s ha finalizado de correr en  un tiempo de %d y pasa el testigo al corredor %s.%n", nombreCorredor, obtenerTiempoParcial(), corredorDestino.nombreCorredor);
            pasarTestigo(corredorDestino);
        } else {
            tiempoVueltaCorredor = System.currentTimeMillis() - tiempoVueltaCorredor;
            System.out.printf("Corredor %s ha finalizado de correr y ha terminado la carrera en un tiempo de %d.%n", nombreCorredor, obtenerTiempoParcial());
        }

        tareaCompletada = true;
    }

    public long obtenerTiempoParcial() {
        return tiempoVueltaCorredor;
    }

    public void usarTestigo() {//Estable el testigo como ocupado
        haRecibidoTestigo = true;
        testigo.cambiarEstado();
    }

    public void pasarTestigo(Corredor c) {
        testigo.cambiarEstado();
        c.start();
    }

    public boolean existeCorredorDestinatario() {
        return (corredorDestino != null);
    }

    public int obtenerTiempoDemoraAleatorio() {
        return 1000 * ((int) (Math.random() * (11 - 9 + 1)) + 9);
    }

}
