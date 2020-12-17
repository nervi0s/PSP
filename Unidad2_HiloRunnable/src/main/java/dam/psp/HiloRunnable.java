package dam.psp;

public class HiloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hola desde el hilo con ID: " + Thread.currentThread().getId());
    }

}
