public class Casuale extends Thread {
    public Casuale(String nome) {
        setName(nome);
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + " ha generato " + ((int)(Math.random() * 100) + 1));
                Thread.sleep((int)(Math.random() * 501) + 500);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " ha riscontrato un errore");
        }
    }
}