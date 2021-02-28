package ejercicio2_5;

public class Ejercicio2_5 {

    public static void main(String[] args) {
        HiloLetrasNumeros hilo1 = new HiloLetrasNumeros(1);
        HiloLetrasNumeros hilo2 = new HiloLetrasNumeros(2);

        hilo1.start();
        hilo2.start();
        //Se intercalan y mezclan las letras y los números ya que los dos hilos se están ejecuntando a la vez
    }

}
