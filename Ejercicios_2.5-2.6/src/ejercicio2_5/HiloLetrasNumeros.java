package ejercicio2_5;

public class HiloLetrasNumeros extends Thread {

    private int tipo;

    public HiloLetrasNumeros(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        while (true) {
            if (tipo == 1) {
                for (int i = 1; i <= 30; i++) {
                    System.out.println("Hilo [" + getName() + "]: " + i);
                }
            } else if (tipo == 2) {
                for (char i = 'a'; i <= 'z'; ++i ){
                    System.out.println("Hilo [" + getName() + "]: " + i);
                }
            }
        }
    }

}
