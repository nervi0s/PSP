package ejercicio2_8;

public class Principal {

    public static void main(String[] args) {
        PingPong h1 = new PingPong("ping");
        PingPong h2 = new PingPong("pong");

        h1.start();
        h2.start();
    }
}
