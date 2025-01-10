import javax.swing.JOptionPane;

public class MainGarage {
    public static void main(String[] args) {
        Garage chrostek = new Garage();

        JOptionPane.showMessageDialog(null, "Automobile 1");
        Automobile a1 = new Automobile();

        chrostek.entra(a1);
        chrostek.esci();
    }
}
