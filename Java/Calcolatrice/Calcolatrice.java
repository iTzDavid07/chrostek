import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

class Calcolatrice extends JFrame implements ActionListener   {
	private JLabel text = new JLabel();
	private JPanel grid = new JPanel();
    private String[] buttons_text = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", ".", "/", "="};
    private JButton[] buttons = new JButton[17];
    private float result = 0;
    private String operation = "";

	public Calcolatrice ()  {
        super ("Calcolatrice Chrostek");

        text.setFont(new Font("Arial", 0, 42));
        text.setForeground(Color.WHITE);
        text.setOpaque(true);
        text.setBackground(Color.BLACK);
        text.setBorder(new EmptyBorder(10, 20, 10 ,20));

        grid.setBackground(Color.BLACK);
        grid.setLayout(new GridLayout(5, 4, 3, 3));
        for (int i = 0; i < 17; i++) {  
            buttons[i] = new JButton(buttons_text[i]);

            buttons[i].setPreferredSize(new Dimension(100, 50));
            buttons[i].setFont(new Font("Arial", 0, 26));
            buttons[i].setForeground(Color.ORANGE);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);

            grid.add(buttons[i]);
        }

        setLayout(new GridLayout(2,1));
        add(text);
        add(grid);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)  {
        String buttonText = e.getActionCommand();

        for (JButton button : buttons) {
            button.setForeground(Color.ORANGE);
            button.setBackground(Color.BLACK);
        }

        if (buttonText.equals("C")) {
            if (text.getText().isEmpty()) {
                result = 0;
                operation = "";
            } else if (!operation.isEmpty()) {
                JButton buttonObject = findButtonByText(operation);
                buttonObject.setBackground(Color.WHITE);
                buttonObject.setForeground(Color.ORANGE);
            } else  {
                result = 0;
                operation = "";
            }

            text.setText("");
        } else if (buttonText.equals("=")) {
            if (!text.getText().isEmpty()) {
                float b = Float.parseFloat(text.getText());
                calculate(b, operation);
            }
            String result_text = (result == (int)result) ? String.valueOf((int)result) : String.valueOf(result);
            text.setText(result_text);

            operation = "";
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            if (!text.getText().isEmpty()) {
                float b = Float.parseFloat(text.getText());
                calculate(b, operation);
                operation = buttonText;
                text.setText("");
            } else {
                operation = buttonText;
            }

            JButton buttonObject = (JButton)e.getSource();
            buttonObject.setBackground(Color.WHITE);
            buttonObject.setForeground(Color.ORANGE);
        } else {
            text.setText(text.getText() + buttonText);
        }
	}

    private void calculate(float b, String op) {
        switch (op) {
            case "+":
                result += b;
                break;
            case "-":
                result -= b;
                break;
            case "*":
                result *= b;
                break;
            case "/":
                result /= b;
                break;
            default:
                result = b;
                break;
        }
    }

    private JButton findButtonByText(String text) {
        for (JButton button : buttons) {
            if (button.getText().equals(text)) {
                return button;
            }
        }
        return null;
    }
}