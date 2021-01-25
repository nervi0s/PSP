package ejercicio3;


/**
 *
 * @author CFGS
 */
public class LetrasNumeros extends Thread {

    private String tipo;

    public LetrasNumeros(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        if (tipo.equalsIgnoreCase("a")) {
            lanzarLetraA();
        } else if (tipo.equalsIgnoreCase("b")) {
            lanzarLetraB();
        } else if (tipo.equalsIgnoreCase("n")) {
            lanzarNumeros();
        }
    }

    public void lanzarLetraA() {
        for (int i = 1; i <= 100; i++) {
            System.out.print("a");
        }
    }

    public void lanzarLetraB() {
        for (int i = 1; i <= 100; i++) {
            System.out.print("b");
        }
    }

    public void lanzarNumeros() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i);
        }
    }

}
