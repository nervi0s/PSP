package dam.psp;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PelotaHilos implements Runnable {

    private Pelota pelota;
    private Component component;

    public PelotaHilos(Pelota p, Component c) {
        pelota = p;
        component = c;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3000; i++) {

            pelota.mueve_pelota(component.getBounds());
            component.paint(component.getGraphics());

            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(MarcoRebote.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
