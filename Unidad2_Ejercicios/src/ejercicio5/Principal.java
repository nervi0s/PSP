package ejercicio5;

public class Principal {

    public static void main(String[] args) {
        Thread h1 = new HilosLetrasNumeros(1);
        Thread h2 = new HilosLetrasNumeros(2);

        h1.start();
        h2.start();
    }

}
