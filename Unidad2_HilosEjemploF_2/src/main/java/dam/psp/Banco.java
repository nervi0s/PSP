package dam.psp;

import java.util.concurrent.locks.ReentrantLock;

/*
 * El número de cuenta será el índice del array.
 *
 * @author wdal9
 */
public class Banco {

    private final ReentrantLock cierreBanco; // Esta vez usamos la clase ReentrantLock para sincronizar los hilos
    private double[] cuentas;

    public Banco() {
        cierreBanco = new ReentrantLock(); // Creamos un objeto de tipo ReentrantLock

        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
    }

    /*
     * Método para realizar las transferencias
     */
    public void transferirDinero(int cuentaOrigen, int cuentaDestino, double cantidad) {
        /*Inicio de lock con su método lock(), a continuación, dentro de un try irá el código "sincronizado"
          Al acabar de ejecutarse dicho código debemos hacer uso de finally para "deslockearlo"
         */
        cierreBanco.lock();
        try {
            if (cuentas[cuentaOrigen] < cantidad) {
                System.out.println("\n" + Thread.currentThread() + ": " + " No hay dinero suficiente en la cuenta: " + cuentaOrigen + ". Cuenta destino: " + cuentaDestino);
                return;
            }

            System.out.println("");
            System.out.println(Thread.currentThread()); // Información sobre el hilo actual
            cuentas[cuentaOrigen] -= cantidad;
            System.out.printf("%10.2f de la cuenta: %d para la cuenta: %d \n", cantidad, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino] += cantidad;
            System.out.printf("Saldo total: %10.2f\n", getCapitalToal());

        } finally {
            cierreBanco.unlock();
        }
    } // Fin del método transferirDinero

    /*
     * Método para obtener el capital total del banco
     */
    public double getCapitalToal() {
        double total = 0;
        /*for (int i = 0; i < cuentas.length; i++) {
            total += cuentas[i];
        }*/
        for (double dinero : cuentas) {
            total += dinero;
        }
        return total;
    }

} // Fin Clase Banco
