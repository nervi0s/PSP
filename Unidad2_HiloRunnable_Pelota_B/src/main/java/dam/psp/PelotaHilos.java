package dam.psp;

import java.awt.Component;

public class PelotaHilos implements Runnable {

    private Pelota pelota;
    private Component component;

    public PelotaHilos(Pelota p, Component c) {
        pelota = p;
        component = c;
    }

    @Override
    public void run() {
        /*for (int i = 1; i <= 3000; i++) {

            pelota.mueve_pelota(component.getBounds());
            component.paint(component.getGraphics());

            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                System.out.println("Hilo dormido e intentado interrumpirlo, imposible interrumpirlo");
            }
        }*/

        //while (!Thread.interrupted()) {
        while (!Thread.currentThread().isInterrupted()) {
            pelota.mueve_pelota(component.getBounds());
            component.repaint();

            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                //Thread.currentThread().interrupt();
                return; //Usamos la línea de arriba o esta para interrumpir el hilo
            }
        }
    }
}
