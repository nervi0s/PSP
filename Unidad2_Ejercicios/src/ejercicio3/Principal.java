package ejercicio3;

/**
 *
 * @author CFGS
 */
public class Principal {

    public static void main(String[] args) {

        LetrasNumeros h1 = new LetrasNumeros("a");
        LetrasNumeros h2 = new LetrasNumeros("b");
        LetrasNumeros h3 = new LetrasNumeros("n");

        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.NORM_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);

        h1.start();
        h2.start();
        h3.start();

    }
}
