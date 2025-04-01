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
        try {
            deposita(600);
            Thread.sleep(5000);
            preleva(200);
        } catch (InterruptedException e) {
            System.out.println("Operazione fallita");
        }
    }
}