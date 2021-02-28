package ejercicio2_6;

public class Ejercicio2_5 {

    public static void main(String[] args) {
        HiloLetrasNumeros hilo1 = new HiloLetrasNumeros(1);
        HiloLetrasNumeros hilo2 = new HiloLetrasNumeros(2);

        hilo1.start();
        hilo2.start();
    }

}
