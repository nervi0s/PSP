package ejercicio2_9;

public class Principal {

    public static void main(String[] args) {
        Thread[] corredores = new Thread[8];

        corredores[0] = new Corredor("Pikachu", 2);
        corredores[1] = new Corredor("Charmander", 2);
        corredores[2] = new Corredor("Blastoise", 2);
        corredores[3] = new Corredor("Chikorita", 2);
        corredores[4] = new Corredor("Meow", 2);
        corredores[5] = new Corredor("Snorlax", 2);
        corredores[6] = new Corredor("Ratata", 2);
        corredores[7] = new Corredor("Bulbasaur", 2);

        for (Thread corredor : corredores) {
            corredor.start();
        }
    }

}
