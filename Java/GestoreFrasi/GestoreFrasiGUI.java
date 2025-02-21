import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestoreFrasiGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton analizzaButton;
    private JPanel inputPanel, buttonPanel, labelPanel;
    private JLabel vocaliText;
    private JLabel spaziText;
    private JLabel freqVocaliText;
    private JLabel freqSpaziText;

    // costruttore: inizializza gli attributi
    public GestoreFrasiGUI() {
        super ("Gestore Frasi");

        inputPanel = new JPanel(new FlowLayout(1, 0, 30));
        inputField = new JTextField();
        buttonPanel = new JPanel(new FlowLayout(1, 0, 0));
        labelPanel = new JPanel(new GridLayout(2,2,40,10));
        analizzaButton = new JButton("Analizza");
        vocaliText = new JLabel("Vocali: ");
        spaziText = new JLabel("Spazi: ");
        freqVocaliText = new JLabel("Frequenza Vocali: ");
        freqSpaziText = new JLabel("Frequenza Spazi: ");
        
        inputField.setFont(new Font("Roboto", 0, 20));
        inputField.setPreferredSize(new Dimension(400, 30));
        inputPanel.add(inputField);

        analizzaButton.addActionListener(this);
        buttonPanel.add(analizzaButton);

        labelPanel.setPreferredSize(new Dimension(500, 50));
        labelPanel.add(vocaliText);
        labelPanel.add(spaziText);
        labelPanel.add(freqVocaliText);
        labelPanel.add(freqSpaziText);

        setLayout(new GridLayout(4,1));
        add(inputPanel);
        add(buttonPanel);
        add(labelPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
	    setVisible(true);
    }

    public void actionPerformed(ActionEvent e)  {
        String buttonText = e.getActionCommand();
        GestoreFrasi gestore = new GestoreFrasi();

        if (buttonText.equals("Analizza")) {
            gestore.analizza(inputField.getText());
            vocaliText.setText("Vocali: " + gestore.vocali);
            spaziText.setText("Spazi: " + gestore.spazi);
            double freqVocali = gestore.getFreqVocali();
            freqVocaliText.setText("Frequenza Vocali: " + freqVocali);
            double freqSpazi = gestore.getFreqSpazi();
            freqSpaziText.setText("Frequenza Spazi: " + freqSpazi);
        }
	}
}