package dam.psp;

/**
 *
 * @author wdal9
 */
public class Principal {

    public static void main(String[] args) {

        ColaDeposito deposito = new ColaDeposito();
        Productor productor = new Productor(deposito, 100);
        Consumidor consumer = new Consumidor(deposito, 101);

        productor.start();
        consumer.start();
    }

}
