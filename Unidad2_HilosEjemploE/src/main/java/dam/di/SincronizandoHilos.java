package dam.di;

public class SincronizandoHilos {

    public static void main(String[] args) {

        Thread hilo1 = new Thread(new HilosVarios());
        Thread hilo2 = new Thread(new HilosVarios2(hilo1));

        hilo1.start();

        hilo2.start();

        System.out.println("Al final de main");
    }
}
