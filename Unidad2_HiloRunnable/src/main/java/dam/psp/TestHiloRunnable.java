package dam.psp;

public class TestHiloRunnable {

    public static void main(String[] args) {
        System.out.println("Inicio Main: " + Thread.currentThread().getId());

        //En 3 pasos
        //Thread hilo1 = new new HiloRunnable();
        //hilo1.start():
        //Runnable r = new HiloRunnable();
        HiloRunnable r = new HiloRunnable();
        Thread hilo = new Thread(r);
        hilo.start();

        //En 2 pasos
        HiloRunnable r2 = new HiloRunnable();
        new Thread(r2).start();

        //En 1 paso
        new Thread(new HiloRunnable()).start();

        System.out.println("Fin Main " + Thread.currentThread().getId());
    }

}
