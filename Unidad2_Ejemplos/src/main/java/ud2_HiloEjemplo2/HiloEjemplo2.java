package ud2_HiloEjemplo2;

public class HiloEjemplo2 extends Thread {

    @Override
    public void run() {
        System.out.println("Dentro del Hilo   : " + this.getName()
                + "\n\tPrioridad :" + this.getPriority()
                + "\n\tID        :" + this.getId());
    }

    public static void main(String[] args) {

        Thread hiloMain = Thread.currentThread();
        hiloMain.setName("Principal");
        System.out.println("El nombre del hilo main es: " + hiloMain.getName());
        System.out.println("Llamada la método toString() del hilo main: " + hiloMain.toString());

        Thread[] hilos = new Thread[3];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloEjemplo2();
            hilos[i].setName("HILO" + (i + 1));
            hilos[i].setPriority(i + 1);
            System.out.println("Información del " + hilos[i].getName() + ": " + hilos[i].toString());
            hilos[i].start();
        }
        System.out.println(hilos.length + " HILOS CREADOS...");
        System.out.println("Hilos activos: " + Thread.activeCount());
    }
}
