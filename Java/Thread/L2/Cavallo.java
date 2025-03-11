import java.util.ArrayList;
import java.util.Random;

public class Cavallo extends Thread {
    private Random rand = new Random();
    private int tempo = 0;
    private static ArrayList<Cavallo> classifica = new ArrayList<Cavallo>();

    public Cavallo(String nome) {
        setName(nome);
    }

    public void run() {
        for(int i = 2; i <= 10; i += 2) {
            try {
                int corsa = rand.nextInt(1500) + 500;
                sleep(corsa);
                tempo += corsa;
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
            }
            System.out.println(getName() + " ha percorso " + i + " metri");
        }
        classifica.add(this);
    }

    public int getTempo() {
        return tempo;
    }

    public static void stampClass() {
        System.out.println("\nClassifica:");
        for(int i = 0; i < classifica.size(); i++) {
            System.out.println(i+1 + ". " + classifica.get(i).getName());
        }
    }
}
