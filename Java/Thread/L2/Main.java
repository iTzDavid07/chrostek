public class Main {
    public static void main(String[] args) {
        Cavallo a = new Cavallo("A");
        Cavallo b = new Cavallo("B");
        Cavallo c = new Cavallo("C");
        Cavallo d = new Cavallo("D");

        a.start();
        b.start();
        c.start();
        d.start();

        try {
            a.join();
            b.join();
            c.join();
            d.join();
        } catch (InterruptedException e) {
            System.out.println("Gara interrotta");
        }

        Cavallo.stampClass();
    }
}
