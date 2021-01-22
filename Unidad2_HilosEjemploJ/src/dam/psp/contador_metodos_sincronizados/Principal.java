package dam.psp.contador_metodos_sincronizados;

public class Principal {

    public static void main(String[] args) {

        Contador contador = new Contador(100);
        HiloIncrementa incrementador = new HiloIncrementa(contador, "Hilo Incrementador--");
        HiloDecrementa decrementador = new HiloDecrementa(contador, "Hilo Decrementador--");

        incrementador.start();
        decrementador.start();
    }
}
