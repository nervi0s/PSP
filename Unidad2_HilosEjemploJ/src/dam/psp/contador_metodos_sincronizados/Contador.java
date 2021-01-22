package dam.psp.contador_metodos_sincronizados;

/**
 *
 * @author CFGS
 */
public class Contador {

    private int contador = 0;

    public Contador(int c) {
        this.contador = c;
    }

    synchronized public void incrementa() {
        contador++;
        System.out.println("Soy el hilo Incrementa e inctremento el contador en una unidad");
        System.out.println("El contador vale: " + getValor());
    }

    synchronized public void decrementa() {
        contador--;
        System.out.println("Soy el hilo Decrementa y decremento el contador en una unidad");
        System.out.println("El contador vale: " + getValor());
    }

    synchronized public int getValor() {
        return contador;
    }
}
