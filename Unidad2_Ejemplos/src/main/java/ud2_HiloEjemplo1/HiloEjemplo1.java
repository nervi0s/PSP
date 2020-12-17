package ud2_HiloEjemplo1;

public class HiloEjemplo1 extends Thread {

    private final int name;
    private final int repetitions;

    public HiloEjemplo1(int name, int n) {
        this.name = name;
        this.repetitions = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= repetitions; i++) {
            System.out.println("Hilo: Hilo " + name + " Número de mensaje = " + i);
        }
    }

    public static void main(String[] args) {
        HiloEjemplo1[] hilos = new HiloEjemplo1[3];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloEjemplo1(i + 1, 5);
            System.out.println("CREANDO HILO : Hilo " + hilos[i].name);
        }

        System.out.println(hilos.length + " HILOS INICIADOS...");

        for (HiloEjemplo1 hilo : hilos) {
            hilo.start();
        }
    } // Fin del main() 

} // Fin de Clase
