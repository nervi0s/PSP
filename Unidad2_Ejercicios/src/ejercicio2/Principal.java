package ejercicio2;

/**
 *
 * @author CFGS
 */
public class Principal {

    public static void main(String[] args) {

        LetrasNumeros h1 = new LetrasNumeros("a");
        LetrasNumeros h2 = new LetrasNumeros("b");
        LetrasNumeros h3 = new LetrasNumeros("n");

        try {
            h3.start();
            h3.join();
            h2.start();
            h2.join();
            h1.start();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
