import javax.swing.JOptionPane;

public class MainAutomobile {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Automobile 1");
        Automobile a1 = new Automobile();
        a1.addGas();
        a1.drive();
        a1.getGas();
        a1.getKm();
        a1.mediaKm();

        JOptionPane.showMessageDialog(null, "Automobile 2");
        Automobile a2 = new Automobile();
        a2.addGas();
        a2.drive();
        a2.getGas();
        a2.getKm();
        a2.mediaKm();
    }
}
