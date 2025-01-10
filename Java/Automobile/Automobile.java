import javax.swing.JOptionPane;

public class Automobile {
    private double resa, carburante;
    private double[] chilometri;

    public Automobile() {
        double resa = Double.parseDouble(JOptionPane.showInputDialog("Inserisci la resa dell'automobile: "));
        this.resa = resa;
        carburante = 0;
        chilometri = new double[30];
    }

    public void drive() {
        double distanza = Double.parseDouble(JOptionPane.showInputDialog("Inserisci la distanza percorsa: "));
        int giorno = Integer.parseInt(JOptionPane.showInputDialog("Inserisci il giorno della distanza percorsa: "));
        if (giorno >= 1 && giorno <= 30) {
            if (carburante >= distanza * resa) {
                carburante -= distanza * resa;
                chilometri[giorno-1] += distanza;
                JOptionPane.showMessageDialog(null, "Distanza inserita correttamente");
            } else {
                JOptionPane.showMessageDialog(null, "Carburante insufficiente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Il giorno inserito e' inesistente");
        }
    }

    public void getGas() {
        JOptionPane.showMessageDialog(null, "Il carburante nell'automobile e' " + carburante + " litri");
    }

    public void addGas() {
        double carburante = Double.parseDouble(JOptionPane.showInputDialog("Inserisci il carburante da aggiungere: "));
        this.carburante += carburante;
    }

    public void getKm() {
        int giorno = Integer.parseInt(JOptionPane.showInputDialog("Inserisci il giorno di cui voi sapere i km percorsi: "));
        
        if (giorno >= 1 && giorno <= 30)
            JOptionPane.showMessageDialog(null, "I km percorsi nel giorno " + giorno + " sono " + chilometri[giorno-1]);
        else
            JOptionPane.showMessageDialog(null, "Il giorno inserito e' inesistente");
    }

    public void mediaKm() {
        double somma = 0;

        for (int i = 0; i < chilometri.length; i++) {
            somma += chilometri[i];
        }

        double media = somma / chilometri.length;

        JOptionPane.showMessageDialog(null, "La media dei chilometri e' " + media + " km");
    }
}