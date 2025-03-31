public class Main {
    public static void main(String[] args) {
        Automobile a = new Automobile("A");
        Automobile b = new Automobile("B");
        Automobile c = new Automobile("C");
        Automobile d = new Automobile("D");

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

        Automobile.stampClass();
    }
}
