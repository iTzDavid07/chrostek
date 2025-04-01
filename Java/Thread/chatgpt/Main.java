public class Main {
    public static void main(String[] args) {
        Casuale a = new Casuale("a");
        Casuale b = new Casuale("b");
        Casuale c = new Casuale("c");

        a.start();
        b.start();
        c.start();

        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}