import java.util.ArrayList;
import java.util.Random;

public class Automobile extends Thread {
    private Random rand = new Random();
    private int distanza_percorsa = 0;
    private int velocita;
    private static ArrayList<Automobile> classifica = new ArrayList<Automobile>();

    public Automobile(String nome) {
        setName(nome);
        this.velocita = rand.nextInt(70) + 90;
    }

    public void run() {
        for(int i = 2; i <= 10; i += 2) {
            try {
                sleep(500);
                int attuale_distanza_percorsa = rand.nextInt(27) + 500;
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
            }
            System.out.println(getName() + " ha percorso " + i + " metri");
        }
        classifica.add(this);
    }

    public static void stampClass() {
        System.out.println("\nClassifica:");
        for(int i = 0; i < classifica.size(); i++) {
            System.out.println(i+1 + ". " + classifica.get(i).getName());
        }
    }
}
