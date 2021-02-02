package ejercicio6;

public class Principal {

    public static void main(String[] args) {
        Contador c1 = new Contador("Contador 1", 1);
        Contador c2 = new Contador("Contador 2", 25);
        Contador c3 = new Contador("Contador 3", 50);
        Contador c4 = new Contador("Contador 4", 10);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        //Una forma de hacerlo
        while (c1.isAlive() || c2.isAlive() || c3.isAlive() || c4.isAlive()) {
            //No hacer nada, solo esperar
        }

        //Otra forma de hacerlo
        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Fin del programa");
    }
}
