package dam.psp;

public class Principal {

    public static void main(String[] args) {
        //Creamos 3 hilos
        HilosPrioridades h1 = new HilosPrioridades();
        HilosPrioridades h2 = new HilosPrioridades();
        HilosPrioridades h3 = new HilosPrioridades();
        //Les damos a cado uno de ellos una prioridad
        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.NORM_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);
        //Arrancamos los hilos
        h1.start();
        h2.start();
        h3.start();
        //Hacemos esperar al main() 10 segundos
        try {
            Thread.sleep(10000);
            //Paramos dichos hilos con otro método creado por nosotros
            h1.pararHilo();
            h2.pararHilo();
            h3.pararHilo();

            //Después de 10 seg mostramos hasta cuánto ha contado cada hilo con un método que creamos nosotros mismos msg()
            //En teoría el hilo de mayor prioridad debería contar más veces que el resto.
            h1.msg();
            h2.msg();
            h3.msg();
        } catch (InterruptedException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
