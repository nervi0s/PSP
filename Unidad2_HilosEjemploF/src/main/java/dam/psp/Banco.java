package dam.psp;

/**
 * El número de cuenta será el índice del array.
 *
 * @author wdal9
 */
public class Banco {

    private double[] cuentas;

    public Banco() {
        cuentas = new double[100];

        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
    }

    /**
     * Método para realizar las transferencias
     */
    public void transferirDinero(int cuentaOrigen, int cuentaDestino, double cantidad) {
        if (cuentas[cuentaOrigen] < cantidad) {
            return;
        }

        System.out.println(Thread.currentThread());

        cuentas[cuentaOrigen] -= cantidad;

        System.out.printf("%10.2f de la cuenta: %d para la cuenta: %d \n", cantidad, cuentaOrigen, cuentaDestino);

        cuentas[cuentaDestino] += cantidad;

    } // Fin del método transferirDinero

} //Fin Clase Banco
