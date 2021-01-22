package dam.psp.contador_bloque_sincronizado;

public class Principal {

    public static void main(String[] args) {

        Contador contador = new Contador(100);
        HiloIncrementa incrementador = new HiloIncrementa(contador, "Hilo Incrementador--");
        HiloDecrementa decrementador = new HiloDecrementa(contador, "Hilo Decrementador--");

        incrementador.start();
        decrementador.start();
    }
}
