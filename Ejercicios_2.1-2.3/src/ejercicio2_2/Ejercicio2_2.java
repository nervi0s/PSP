package ejercicio2_2;

public class Ejercicio2_2 {

    public static void main(String[] args) {
        Thread hiloLetrasA = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.print("a");
            }
        });

        Thread hiloLetrasB = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.print("b");
            }
        });

        Thread hiloNumeros = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.print(i);
            }
        });
        try {
            hiloNumeros.start();
            hiloNumeros.join();
            hiloLetrasB.start();
            hiloLetrasB.join();
            hiloLetrasA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
