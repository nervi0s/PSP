package ejercicio2_10;

public class Carrera extends Thread {

    private final Corredor[] corredores;
    private boolean existeGanador = false;
    private final String nombre;

    public Carrera(String nombre, Corredor... corredores) {
        this.nombre = nombre;
        this.corredores = corredores;
    }

    @Override
    public void run() {
        establecerCarrera();
        empezarCarrera();
    }

    public void empezarCarrera() {
        for (Corredor corredor : corredores) {
            corredor.start();
        }
    }

    public void establecerCarrera() {
        for (Corredor corredor : corredores) {
            corredor.setCarrera(this);
        }
    }

    public boolean getExisteGanador() {
        return existeGanador;
    }

    public void setExisteGanador(boolean value) {
        existeGanador = value;
    }

    public String getNombreCarrera() {
        return nombre;
    }
}
