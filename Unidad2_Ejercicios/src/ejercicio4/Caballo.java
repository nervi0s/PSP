package ejercicio4;

public class Caballo implements Runnable {

    protected String name;
    private int sleep;

    public Caballo(String name, int sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 1; i <= 500; i++) {
            try {
                Thread.sleep(sleep);
                if (i % 100 == 0) {
                    System.out.println("El caballo " + name + " lleva recorrido: " + i + " metros");
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
