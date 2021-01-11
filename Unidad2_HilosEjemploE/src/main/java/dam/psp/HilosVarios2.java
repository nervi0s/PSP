package dam.psp;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HilosVarios2 implements Runnable {

    private Thread hilo;

    public HilosVarios2(Thread hilo) {
        this.hilo = hilo;
    }

    @Override
    public void run() {

        try {
            hilo.join();

            for (int i = 1; i <= 5; i++) {
                Thread.sleep(500);
                System.out.println("Mensaje " + i + " del hilo " + Thread.currentThread().getName());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
