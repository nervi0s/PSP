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
    synchronized public void transferirDinero(int cuentaOrigen, int cuentaDestino, double cantidad) {

        /*
        Vamos a usar el método wait() de Java para hacer que mientras se cumpla cierta condición (en este caso será
        la de que mientras la cantidad que hay en la cuenta de origen sea menor que la cantidad aleatoria a sacar de ella)
        el hilo actual quede a la espera hasta que dicha condición deje de cumplirse, mientras tanto, los demás hilos seguirán
        trabajando de forma normal.
         */
        
        // Mientras se cumpla la condición (que es que no hay dinero suficiente para realizar la transferencia) el hilo actual espera
        while (cuentas[cuentaOrigen] < cantidad) {
            try {
                System.out.println("\n" + Thread.currentThread() + ": " + " No hay dinero suficiente en la cuenta: " + cuentaOrigen + ". Cuenta destino: " + cuentaDestino);
                wait();
                System.out.println("\n" + Thread.currentThread() + ": " + " Hilo liberado ahora sí hay dinero suficiente en la cuenta: " + cuentaOrigen + ". Cuenta destino: " + cuentaDestino);
            } catch (InterruptedException ex) {
                System.out.println("ERROR 2");
            }
        }

        System.out.println("");
        System.out.println(Thread.currentThread()); // Información sobre el hilo actual
        cuentas[cuentaOrigen] -= cantidad;
        System.out.printf("%10.2f de la cuenta: %d para la cuenta: %d \n", cantidad, cuentaOrigen, cuentaDestino);
        cuentas[cuentaDestino] += cantidad;
        System.out.printf("Saldo total: %10.2f\n", getCapitalToal());

        notifyAll(); // Notifica que este hilo ha quedado desbloqueado y lo despierta

    } // Fin del método transferirDinero

    /*
     * Método para obtener el capital total del banco
     */
    public double getCapitalToal() {
        double total = 0;

        for (double dinero : cuentas) {
            total += dinero;
        }
        return total;
    }

} // Fin Clase Banco
