public class Main {
    public static void main(String[] args) {
        CicloThread thread1 = new CicloThread(1);
        CicloThread thread2 = new CicloThread(2);

        CicloRunnable runnable = new CicloRunnable(3);
        Thread thread = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread.start();
    }
}
