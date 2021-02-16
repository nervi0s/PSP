package dam.psp;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

class PelotaHilo extends Thread {

    private Pelota pelota;
    private Component componente;

    public PelotaHilo(Pelota p, Component c) {
        pelota = p;
        componente = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            pelota.mueve_pelota(componente.getBounds());
            componente.repaint();

            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

}
