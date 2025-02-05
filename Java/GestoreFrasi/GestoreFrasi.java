import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GestoreFrasi extends JFrame implements ActionListener {
    private int vocali;
    private int spazi;

    private JTextField inputField;
    private JButton analizzaButton;
    private JPanel p1, labelPanel;
    private JLabel vocaliText;
    private JLabel spaziText;
    private JLabel freqVocaliText;
    private JLabel freqSpaziText;

    // costruttore: inizializza gli attributi
    public GestoreFrasi() {
        super ("Gestore Frasi");

        inputField = new JTextField();
        p1 = new JPanel(new FlowLayout(1, 0, 5));
        labelPanel = new JPanel(new GridLayout(2,2,40,10));
        analizzaButton = new JButton("Analizza");
        vocaliText = new JLabel("Vocali: ");
        spaziText = new JLabel("Spazi: ");
        freqVocaliText = new JLabel("Frequenza Vocali: ");
        freqSpaziText = new JLabel("Frequenza Spazi: ");
        
        inputField.setFont(new Font("Roboto", 0, 20));
        analizzaButton.addActionListener(this);
        p1.add(analizzaButton);
        labelPanel.setPreferredSize(new Dimension(500, 50));
        labelPanel.add(vocaliText);
        labelPanel.add(spaziText);
        labelPanel.add(freqVocaliText);
        labelPanel.add(freqSpaziText);

        setLayout(new GridLayout(4,1));
        add(inputField);
        add(p1);
        add(labelPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
	    setVisible(true);
    }

    public void actionPerformed(ActionEvent e)  {
        String buttonText = e.getActionCommand();

        if (buttonText.equals("Analizza")) {
            analizza();
            vocaliText.setText("Vocali: " + vocali);
            spaziText.setText("Spazi: " + spazi);
            double freqVocali = getFreqVocali();
            freqVocaliText.setText("Frequenza Vocali: " + freqVocali);
            double freqSpazi = getFreqSpazi();
            freqSpaziText.setText("Frequenza Spazi: " + freqSpazi);
        }
	}
    
    // calcola il numero di vocali e di spazi
    private void analizza() {
        vocali = 0;
        spazi = 0;
        char carattere;
        String testo = inputField.getText();
        testo.toLowerCase();
        for (int i = 0; i < testo.length(); i++) {
            carattere = testo.charAt(i);
            switch (carattere) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vocali++;
                    break;
                case ' ':
                    spazi++;
                    break;
            }
        }
    }

    // calcola la frequenza delle vocali
    private double getFreqVocali() {
        double freqVocali;
        freqVocali = (double) vocali / inputField.getText().length();
        return arrotonda(freqVocali);
    }

    // calcola la frequenza degli spazi
    private double getFreqSpazi() {
        double freqSpazi;
        freqSpazi = (double) spazi / inputField.getText().length();
        return arrotonda(freqSpazi);
    }

    // arrotonda a due cifre decimali
    private double arrotonda(double valore) {
        return (double) Math.round(valore * 100) / 100;
    }
}