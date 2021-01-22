package dam.psp.contador_bloque_sincronizado;

public class HiloIncrementa extends Thread {

    private Contador c;
    private String nombreHilo;

    public HiloIncrementa(Contador c, String nombreHilo) {
        this.c = c;
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        synchronized (c) {
            for (int i = 0; i < 300; i++) {
                c.incrementa();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(HiloIncrementa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(nombreHilo + ": El contador vale: " + c.getValor());
        }
    }// Fin del método Run

}// Fin de la clase HiloIncrementa
