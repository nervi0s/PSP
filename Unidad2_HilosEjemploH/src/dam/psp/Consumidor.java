package dam.psp;

/**
 *
 * @author wdal9
 */
public class Consumidor extends Thread {

    private ColaDeposito deposito;
    private int id;

    public Consumidor(ColaDeposito deposito, int id) {
        this.deposito = deposito;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Consumidor: " + Thread.currentThread());
        int valor;
        for (int i = 0; i < 5; i++) {
            valor = deposito.get();
            System.out.println("Iteración " + i + " del consumidor con ID: " + id
                    + ". Consume: " + valor);
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("ERROR 2");
            }*/
        }

    }
}
