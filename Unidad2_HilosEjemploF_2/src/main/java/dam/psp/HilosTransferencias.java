package dam.psp;

public class HilosTransferencias implements Runnable {

    private Banco banco;
    private int cuentaOrigen;
    private double cantidadMaxima;

    public HilosTransferencias(Banco banco, int cuentaOrigen, double cantidadMaxima) {
        this.banco = banco;
        this.cuentaOrigen = cuentaOrigen;
        this.cantidadMaxima = cantidadMaxima;
    }

    @Override
    public void run() {
        while (true) { // Hacemos transferencias indefinidamente entre las cuentas.
            /*
            Cada cuenta de origen, crea su propio hilo (que en este caso coincide con su nombre o índice) 
            en el que va haciendo transferencias a las demás cuentas de manera aleatoria.
             */
            int cuentaDestino = (int) (Math.random() * 100);
            double cantidad = Math.random() * cantidadMaxima;

            banco.transferirDinero(cuentaOrigen, cuentaDestino, cantidad);

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("ERROR 1");
            }
        }
    }
} // Fin Clase HilosTransferencias
