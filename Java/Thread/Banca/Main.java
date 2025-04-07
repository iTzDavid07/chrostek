public class Main {
    public static void main(String[] args) {
        ContoBancario conto = new ContoBancario();
        Utente u1 = new Utente("David", conto);
        Utente u2 = new Utente("Lorenzo", conto);
        Utente u3 = new Utente("Andrea", conto);

        u1.start();
        u2.start();
        u3.start();
    }
}
