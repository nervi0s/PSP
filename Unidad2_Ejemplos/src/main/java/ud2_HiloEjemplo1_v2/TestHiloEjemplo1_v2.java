package ud2_HiloEjemplo1_v2;

public class TestHiloEjemplo1_v2 {


    public static void main(String[] args) {
        HiloEjemplo1_v2[] hilos = new HiloEjemplo1_v2[3];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloEjemplo1_v2(i + 1, 5);
            System.out.println("CREANDO HILO : Hilo " + hilos[i].name());
        }

        System.out.println(hilos.length + " HILOS INICIADOS...");

        for (HiloEjemplo1_v2 hilo : hilos) {
            hilo.start();
        }
    } 
}