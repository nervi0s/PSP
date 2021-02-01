package ejercicio4;

public class Controller extends Thread {

    private Thread[] hilos;
    private boolean flag = false;
    private String elegido;

    public Controller(Thread... hilos) {
        this.hilos = hilos;
    }

    @Override
    public void run() {
        correr();
        controlar();
    }

    public void controlar() {
        while (!flag) {
            for (Thread hilo : hilos) {
                if (!hilo.isAlive() && !flag) {
                    detenerHilos();
                    flag = true;
                    System.out.println("Ha ganado: " + hilo.getName());
                    if (elegido.equalsIgnoreCase(hilo.getName())) {
                        System.out.println("Has elegido al caballo ganador");
                    } else {
                        System.out.println("Has perdido la apuesta");
                    }
                }
            }
        }
    }

    public final void correr() {
        for (Thread hilo : hilos) {
            hilo.start();
        }
    }

    public void elegirCaballo(String nombre) {
        elegido = nombre;
    }

    public void detenerHilos() {
        for (Thread hilo : hilos) {
            hilo.interrupt();
        }
    }
}
