package ejercicios2_7;

public class Contador extends Thread {

    private int counter = 1;
    private String nombreHilo;
    private int limit;

    public Contador(String nombre, int limite) {
        super(nombre);
        nombreHilo = nombre;
        limit = limite;
    }

    @Override
    public void run() {
        for (; counter <= limit; counter++) {
            System.out.println("Hilo [" + getName() + "]: " + counter);
        }
        System.out.println("Hilo [" + getName() + "] ya ha acabado");
    }

}
