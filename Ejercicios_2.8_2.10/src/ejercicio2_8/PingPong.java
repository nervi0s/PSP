package ejercicio2_8;

public class PingPong extends Thread {

    private final String nombre;
    public boolean state;

    public PingPong(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            showMessage();
        }
    }

    public void showMessage() {
        synchronized (this) {
            if (state) {
                System.out.println("TIC");
                state = !state;
            } else {
                System.out.println("tac");
                state = !state;
            }
        }
    }
}
