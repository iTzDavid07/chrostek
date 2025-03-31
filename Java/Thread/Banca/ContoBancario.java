public class ContoBancario {
    private double saldo = 0;

    public synchronized void deposita(double quota) {
        try {
            Thread.sleep(1000);

            saldo += quota;
        } catch (InterruptedException e) {
            System.out.println("Operazione fallita");
        }
    }

    public synchronized void preleva(double quota) {
        try {
            Thread.sleep(1000);

            if (saldo >= quota) {
                saldo -= quota;
            } else {
                System.out.println("Saldo insufficiente");
            }
        } catch (InterruptedException e) {
            System.out.println("Operazione fallita");
        }
    }
}
