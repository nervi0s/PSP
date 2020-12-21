package dam.di;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HilosVarios implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Mensaje " + i + " del hilo " + Thread.currentThread().getName());
        }
    }
}
