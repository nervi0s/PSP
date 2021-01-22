package dam.psp.contador_bloque_sincronizado;

public class HiloDecrementa extends Thread {

    private Contador c;
    private String nombreHilo;

    public HiloDecrementa(Contador c, String nombreHilo) {
        this.c = c;
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        synchronized (c) {

            for (int i = 0; i < 300; i++) {
                c.decrementa();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(HilosIncrementa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(nombreHilo + ": El contador vale: " + c.getValor());
        }
    }// Fin del método Run

}// Fin de la clase HiloDecrementa
