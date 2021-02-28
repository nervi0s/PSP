package ejercicio2_3;

public class Ejercicio2_3 {

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

        hiloNumeros.setPriority(Thread.MAX_PRIORITY);
        hiloLetrasB.setPriority(Thread.NORM_PRIORITY);
        hiloLetrasA.setPriority(Thread.MIN_PRIORITY);

        hiloNumeros.start();
        hiloLetrasB.start();
        hiloLetrasA.start();

        /*No se consigue que la salida siempre sea la misma debido a que el tema de las prioridades en un ordenador
        **multinúcleo puede que el planificador del O.S. haga cosas "raras" con el tema de los hilos y las prioridades
         */
    }

}
