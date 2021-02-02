package ejercicio6;

public class Contador extends Thread {

    private int contador = 1;
    private String name;
    private int limit;

    public Contador(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (contador <= limit) {
            System.out.println("Hilo " + name + ": " + contador);
            contador++;
        }
        System.out.println("Hilo " + name + " ya ha acabado");
    }

}
