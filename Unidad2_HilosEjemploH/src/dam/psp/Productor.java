package dam.psp;

/**
 *
 * @author wdal9
 */
public class Productor extends Thread {

    private ColaDeposito deposito;
    private int id;

    public Productor(ColaDeposito deposito, int id) {
        this.deposito = deposito;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Productor: " + Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            deposito.put(i);
            System.out.println("Iteración " + i + " del productor con ID: " + id
                    + ". Produce: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("ERROR 1");
            }
        }

    }
}
