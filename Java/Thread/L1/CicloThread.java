public class CicloThread extends Thread {
    private int n;

    public CicloThread(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(n + " Ciclo " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException exc) {}
        }
    }
}
