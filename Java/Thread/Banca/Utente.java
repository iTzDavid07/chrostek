public class Utente extends Thread {
    ContoBancario conto;

    public Utente(String nome, ContoBancario conto) {
        setName(nome);
        this.conto = conto;
    }

    private void preleva(double quota) {
        System.out.println(getName() + " sta tentando di prelevare");
        conto.preleva(quota);
        System.out.println(getName() + " ha finito di prelevare");
    }

    private void deposita(double quota) {
        System.out.println(getName() + " sta tentando di depositare");
        conto.deposita(quota);
        System.out.println(getName() + " ha finito di depositare");
    }

    public void run() {
        deposita(600);
        preleva(200);
    }
}