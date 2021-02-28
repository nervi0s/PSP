package ejercicios2_7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        Contador contador1 = new Contador("Contador 1", 2);
        Contador contador2 = new Contador("Contador 2", 40);
        Contador contador3 = new Contador("Contador 3", 10);
        Contador contador4 = new Contador("Contador 4", 50);

        contador1.start();
        contador2.start();
        contador3.start();
        contador4.start();

        try {
            contador1.join();
            contador2.join();
            contador3.join();
            contador4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Fin del programa");
    }

}
