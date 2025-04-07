public class Utente extends Thread {
    ContoBancario conto;

    public Utente(String nome, ContoBancario conto) {
        setName(nome);
        this.conto = conto;
    }

    private void preleva(double quota) {
        conto.preleva(quota);
        System.out.println(getName() + " ha prelevato");
    }

    private void deposita(double quota) {
        conto.deposita(quota);
        System.out.println(getName() + " ha depositato");
    }

    public void run() {
        try {
            deposita(600);
            Thread.sleep(5000);
            preleva(200);
        } catch (InterruptedException e) {
            System.out.println("Operazione fallita");
        }
    }
}