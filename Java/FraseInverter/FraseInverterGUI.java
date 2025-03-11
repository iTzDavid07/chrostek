import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FraseInverterGUI extends JFrame implements ActionListener {
    private JPanel topPanel = new JPanel();
    private JPanel botPanel = new JPanel();
    private JTextField inputField = new JTextField();
    private JLabel outputLabel = new JLabel("Frase Invertita: ");
    private FraseInverter inverter = new FraseInverter();

	public FraseInverterGUI ()  {
        super ("Invertitore di Frasi Chrostek");

        inputField.setPreferredSize(new Dimension(500, 40));
        inputField.setFont(new Font("Inter", 0, 18));
        inputField.addActionListener(this);
        topPanel.add(inputField);

        outputLabel.setPreferredSize(new Dimension(500, 40));
        outputLabel.setFont(new Font("Inter", 0, 17));
        botPanel.add(outputLabel);

        setLayout(new GridLayout(2, 1));
        add(topPanel);
        add(botPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)  {
        inverter.inputFrase(inputField.getText());
        String fraseInvertita = inverter.getInverted();
        outputLabel.setText("Frase Invertita: " + fraseInvertita);
	}
}