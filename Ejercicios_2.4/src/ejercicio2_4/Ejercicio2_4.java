package ejercicio2_4;

import java.util.Scanner;

public class Ejercicio2_4 {

    public static void main(String[] args) {
        Caballo c1 = new Caballo("Caballo 1");
        Caballo c2 = new Caballo("Caballo 2");
        Caballo c3 = new Caballo("Caballo 3");

        System.out.print("Elige un caballo (1-> Caballo 1, 2-> Caballo 2, 3-> Caballo 3): ");
        Scanner sc = new Scanner(System.in);
        int seleccion = sc.nextInt();

        switch (seleccion) {
            case 1:
                c1.setSeleccionado(true);
                break;
            case 2:
                c2.setSeleccionado(true);
                break;
            case 3:
                c3.setSeleccionado(true);
                break;
            default:
                System.out.println("Selección incorrecta");
        }

        c1.start();
        c2.start();
        c3.start();
    }

}
