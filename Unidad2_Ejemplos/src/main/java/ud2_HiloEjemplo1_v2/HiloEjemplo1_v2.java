package ud2_HiloEjemplo1_v2;

public class HiloEjemplo1_v2 extends Thread {

    private final int name;
    private final int repetitions;

    public HiloEjemplo1_v2(int name, int n) {
        this.name = name;
        this.repetitions = n;
    }
    public int name(){
        return name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= repetitions; i++) {
            System.out.println("Hilo: Hilo " + name + " Número de mensaje = " + i);
        }
    }

} 