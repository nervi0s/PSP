package ud2_PrimerHilo;

public class PrimerHilo extends Thread {

    private final int repetitions;

    public PrimerHilo(int n) {
        repetitions = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= repetitions; i++) {
            System.out.println("Mensaje: " + i);
        }
    }

    public static void main(String[] args) {

        int repeticiones = 5;

        PrimerHilo h1 = new PrimerHilo(repeticiones);
        h1.start();
        System.out.println("Hello!!!");
    }
}
