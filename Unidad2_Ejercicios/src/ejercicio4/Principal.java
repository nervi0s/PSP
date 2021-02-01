package ejercicio4;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Thread h1 = new Thread(new Caballo("Saltarín", 15));
        Thread h2 = new Thread(new Caballo("Contento", 15));
        Thread h3 = new Thread(new Caballo("Golfo", 15));

        Controller controlador = new Controller(h1, h2, h3);

        System.out.print("Elige un caballo: 1. Saltarín 2. Contento 3. Golfo: ");
        int seleccion = new Scanner(System.in).nextInt();

        switch (seleccion) {
            case 1:
                controlador.elegirCaballo("Saltarín");
                break;
            case 2:
                controlador.elegirCaballo("Contento");
                break;
            case 3:
                controlador.elegirCaballo("Golfo");
                break;

        }

        controlador.start();

    }
}
