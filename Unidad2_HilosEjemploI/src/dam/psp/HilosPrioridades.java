package dam.psp;

public class HilosPrioridades extends Thread {

    private int counter = 0;//Contador interno
    private boolean parado = false;//Variable para parar el hilo

    @Override
    public void run() {
        while (!parado) {
            try {
                Thread.sleep(2);//Se duerme el hilo que cuenta para que no desborde en contador con número negativos
                counter++;
            } catch (InterruptedException ex) {
                //Logger.getLogger(HilosPrioridades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void msg() { //Muestra el mensaje 
        System.out.println(getPriority() + " " + counter);
    }

    public void pararHilo() {
        parado = true;
    }
}
