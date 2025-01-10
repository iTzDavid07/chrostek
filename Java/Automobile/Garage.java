import javax.swing.JOptionPane;

public class Garage {
    private String nome;
    private Automobile[] garage;
    private boolean[] slotStatus;

    public Garage() {
        nome = JOptionPane.showInputDialog("Inserisci il nome del garage:");
        int size = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la grandezza del garage:"));
        garage = new Automobile[size];
        slotStatus = new boolean[size];
    }

    public void entra(Automobile auto) {
        for (int i = 0; i < garage.length; i++) {
            if (!slotStatus[i]) {
                garage[i] = auto;
                slotStatus[i] = true;
                JOptionPane.showMessageDialog(null, "L'auto e' stata parcheggiata al posto " + i + " del garage " + nome);
                break;
            }
        }
    }

    public void esci() {
        int slot = Integer.parseInt(JOptionPane.showInputDialog("Inserire lo slot in cui e' parcheggiata l'auto da rimuovere:"));
        if (slot < garage.length) {
            if (slotStatus[slot]) {
                slotStatus[slot] = false;
                JOptionPane.showMessageDialog(null, "L'auto e' uscita dal garage " + nome);
            } else {
                JOptionPane.showMessageDialog(null, "Non e' presente alcuna auto al posto inserito nel garage " + nome);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Il posto inserito non e' presente nel garage " + nome);
        }
    }
}
