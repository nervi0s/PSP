package dam.psp;

/**
 *
 * @author CFGS
 */
public class Contador {

    private int contador = 0;

    public Contador(int c) {
        this.contador = c;
    }

    public void incrementa() {
        contador++;
        System.out.println("Soy el hilo Incrementa e inctremento el contador en una unidad");
        System.out.println("El contador vale: " + getValor());
    }

    public void decrementa() {
        contador--;
        System.out.println("Soy el hilo Decrementa y decremento el contador en una unidad");
        System.out.println("El contador vale: " + getValor());
    }

    public int getValor() {
        return contador;
    }
}
