package dam.psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wdal9
 */
public class ColaDeposito {

    private int numero;
    private boolean disponible = false;

    synchronized public void put(int n) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException ex) {
                //Logger.getLogger(ColaDeposito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.numero = n;
        disponible = true;
        notifyAll();
    }

    synchronized public int get() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException ex) {
                //Logger.getLogger(ColaDeposito.class.getName()).log(Level.SEVERE, null, ex);
            }
            //disponible = false;
            //notifyAll();
            //return this.numero;
        }
        disponible = false;
        notify();
        return this.numero;
        //return -1; //No haría falta
    }

}
