package ejercicio2_6;

public class HiloLetrasNumeros extends Thread {

    public static volatile boolean control = false;
    private int tipo;

    public HiloLetrasNumeros(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        while (true) {
            //synchronized (this) {
            if (tipo == 1 && control) {
                for (int i = 1; i <= 30; i++) {
                    System.out.println("Hilo [" + getName() + "]: " + i);
                }
                HiloLetrasNumeros.control = false;
            } else if (tipo == 2 && !control) {
                for (char i = 'a'; i <= 'z'; ++i) {
                    System.out.println("Hilo [" + getName() + "]: " + i);
                }
                HiloLetrasNumeros.control = true;
            }
            //}
        }
    }

}
