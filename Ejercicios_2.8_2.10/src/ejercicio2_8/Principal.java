package ejercicio2_8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        PingPong h1 = new PingPong("ping");
        PingPong h2 = new PingPong("pong");

        h1.start();
        h2.start();

        while (true) {
            try {
                if (h1.state) {
                    h1.wait();
                } else {
                    if (!h2.state) {
                        h2.wait();
                    }
                    h2.state = !h2.state;
                    h2.notify();
                }
                h1.state = !h1.state;
                h1.notify();
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
