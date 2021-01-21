
package dam.psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CFGS
 */
public class Principal {


    public static void main(String[] args) {
        
        HilosPrioridades h1 = new HilosPrioridades();
        HilosPrioridades h2 = new HilosPrioridades();
        HilosPrioridades h3 = new HilosPrioridades();
        
        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.NORM_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);
        
        h1.start();
        h2.start();
        h3.start();
        
        try {
            Thread.sleep(10000);
            h1.msg();
            h2.msg();
            h3.msg();
            
            h1.interrupt();
            h2.interrupt();
            h3.interrupt();
            
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
