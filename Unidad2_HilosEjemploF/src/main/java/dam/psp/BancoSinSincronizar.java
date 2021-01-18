package dam.psp;

public class BancoSinSincronizar {

    public static void main(String[] args) {
        Banco banco = new Banco();

        for (int i = 0; i < 100; i++) {
            new Thread(new HilosTransferencias(banco, i, 2000)).start();
        }
    }

}
