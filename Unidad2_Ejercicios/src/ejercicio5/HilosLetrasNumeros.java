package ejercicio5;

public class HilosLetrasNumeros extends Thread {

    private int tipo;
    static boolean showNumber = false;

    public HilosLetrasNumeros(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        while (true) {
            if (tipo == 1) {
                muestraNumeros();
            } else if (tipo == 2) {
                muestraAbecedario();
            }
        }
    }

    /*synchronized*/ public void muestraNumeros() {

        synchronized (this) {
            if (!showNumber) {
                //System.out.println("lol");
            } else {
                for (int i = 1; i <= 30; i++) {
                    System.out.println(i);
                }
                showNumber = false;
            }
        }

        /* while (!showNumber) {
            try {
                System.out.println("oooo");
                wait();
            } catch (InterruptedException ex) {
                //   Logger.getLogger(HilosLetrasNumeros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 1; i <= 30; i++) {
            System.out.println(i);
        }
        showNumber = false;
        notifyAll();*/
    }

    /*synchronized*/ public void muestraAbecedario() {
        synchronized (this) {
            if (showNumber) {

            } else {
                for (int i = 97; i <= 122; i++) {
                    System.out.println((char) i);
                }
                showNumber = true;
            }
        }

        /*while (showNumber) {
            try {
                System.out.println("fffff");
                wait();
            } catch (InterruptedException ex) {
                //Logger.getLogger(HilosLetrasNumeros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 97; i <= 122; i++) {
            System.out.println((char) i);
        }
        showNumber = true;
        notifyAll();*/
    }

}
