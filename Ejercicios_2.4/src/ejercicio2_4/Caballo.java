package ejercicio2_4;

public class Caballo extends Thread {

    static boolean flag = false;

    private String nombre;
    private boolean seleccionado;

    public Caballo(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] ha empezado a correr!");
        for (int i = 1; i <= 500; i++) {

            if (i % 100 == 0 && !flag) {
                System.out.println("Distancia recorrida de [" + getName() + "]: " + i + "m");
                if (i == 500 && !flag) {
                    flag = true;
                    System.out.println("¡Ha ganado: " + getName() + "!");
                    if (isSeleccionado()) {
                        System.out.println("Has elegido al caballo ganador");
                    } else {
                        System.out.println("Tu caballo no ha ganado");
                    }
                }
            }
        }
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean selecionado) {
        this.seleccionado = selecionado;
    }

}
