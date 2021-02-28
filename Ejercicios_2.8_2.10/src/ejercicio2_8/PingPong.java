package ejercicio2_8;

public class PingPong extends Thread {

    private static volatile boolean flag = true;
    private final String nombre;

    public PingPong(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            if (nombre.equals("ping") && flag) {
                System.out.println(showPing());
                flag = false;
            } else if (nombre.equals("pong") && !flag) {
                System.out.println(showPong());
                flag = true;
            }
        }
    }

    public String showPing() {
        return "PING";
    }

    public String showPong() {
        return "PONG";
    }
}
