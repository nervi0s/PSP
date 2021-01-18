package dam.psp;

/*
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

    /*
     * Método para realizar las transferencias
     */
    
    //public void transferirDinero(int cuentaOrigen, int cuentaDestino, double cantidad) {
    
    // synchronized se usa para sincronizar los hilos que llamen a este método, esto quiere decir que solo
    // un hilo puede estar usando este método mientras los demás esperan.
    synchronized public void transferirDinero(int cuentaOrigen, int cuentaDestino, double cantidad) {

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
