import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class ContaA extends JFrame implements ActionListener {
    private JPanel mainPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel midPanel = new JPanel();
    private JPanel botPanel = new JPanel();
    private JLabel feedbackText = new JLabel();
	private JTextField inputField = new JTextField();
    private JLabel counterText = new JLabel();
    private JLabel outputText = new JLabel();
    private JButton resetButton = new JButton("Reset");
    private ArrayList<String> parole = new ArrayList<String>();

	public ContaA ()  {
        super ("Conta A Chrostek");

        inputField.setPreferredSize(new Dimension(350, 40));
        inputField.setFont(new Font("Inter", 0, 18));
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(Color.WHITE);
        inputField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 1),
            new EmptyBorder(5, 10, 5, 10)
        ));
        inputField.addActionListener(this);

        feedbackText.setForeground(Color.WHITE);

        counterText.setPreferredSize(new Dimension(150, 30));
        counterText.setForeground(Color.WHITE);
        counterText.setText("Parole inserite: 0");

        resetButton.setBackground(Color.WHITE);
        resetButton.addActionListener(this);
        
        outputText.setForeground(Color.WHITE);

        topPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        topPanel.setBackground(Color.BLACK);
        topPanel.setLayout(new GridLayout(2, 1));
        topPanel.add(inputField);
        topPanel.add(feedbackText);

        midPanel.setBackground(Color.BLACK);
        midPanel.add(counterText);
        midPanel.add(resetButton);

        botPanel.setBackground(Color.BLACK);
        botPanel.add(outputText);

        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.add(topPanel);
        mainPanel.add(midPanel);
        mainPanel.add(botPanel);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)  {
        Object actionSource = e.getSource();

        if (actionSource.equals(inputField)) {
            if (parole.size() < 10) {
                outputText.setText("");
                String inputParola = inputField.getText();

                if (!inputParola.contains(" ") && !inputParola.isEmpty()) {
                    parole.add(inputParola);
                    inputField.setText("");
                    counterText.setText("Parole inserite: " + parole.size());

                    feedbackText.setText("Parola inserita!");
                } else if (inputParola.contains(" ")) {
                    feedbackText.setText("La parola contiene spazi.");
                } else if (inputParola.isEmpty()) {
                    feedbackText.setText("Parola vuota.");
                }

                if (parole.size() == 10) {
                    int counter = 0;
                    for (String parola : parole) {
                        if (Character.toLowerCase(parola.charAt(0)) == 'a') counter += 1;
                    }
                    outputText.setText("Le parole che iniziano con a/A sono " + String.valueOf(counter));
                    feedbackText.setText("");
                }
            }
        } else if (actionSource.equals(resetButton)) {
            parole.clear();
            inputField.setText("");
            counterText.setText("Parole inserite: 0");
            outputText.setText("");
            feedbackText.setText("Parole resettate!");
        }
	}
}