import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JButton uno = new JButton("Uno");
    JButton due = new JButton("Due");
    JButton tre = new JButton("tre");
    JButton quattro = new JButton("quattro");
    JButton cinque = new JButton("Cinque");

    JTextField textField1 = new JTextField(15);
    JTextField textField2 = new JTextField(15);

    public MyFrame() {
        super("Negozio");

        Container c = this.getContentPane();

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(2, 2, 0, 5));
        p1.add(new Label("Prezzo"));
        textField1.setBackground(Color.yellow);
        p1.add(textField1);
        p1.add(new Label("Sconto"));
        textField2.setBackground(Color.yellow);
        p1.add(textField2);
        
        c.setLayout(new BorderLayout());
        c.add(p1, BorderLayout.NORTH);

        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}