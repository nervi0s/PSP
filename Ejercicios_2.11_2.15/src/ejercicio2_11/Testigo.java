package ejercicio2_11;

public class Testigo {

    public static Testigo testigo = new Testigo();
    private boolean ocupado;

    public boolean estaOcupado() {
        return ocupado;
    }

    public void cambiarEstado() {
        ocupado = !ocupado;
    }

}
