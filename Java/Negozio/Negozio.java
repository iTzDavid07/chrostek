import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Negozio extends JFrame {
    private int width = 500;
    private int height = 150;

    private JTextField textField1 = new JTextField(15);
    private JTextField textField2 = new JTextField(15);

    private JButton uno = new JButton("10%");
    private JButton due = new JButton("20%");
    private JButton tre = new JButton("30%");
    private JButton quattro = new JButton("40%");
    private JButton cancella = new JButton("cancella");

    public Negozio() {
        super("Negozio");

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(2, 2, 0, 5));
        p1.add(new Label("Prezzo"));
        textField1.setBackground(Color.yellow);
        p1.add(textField1);
        p1.add(new Label("Sconto"));
        textField2.setBackground(Color.green);
        p1.add(textField2);
        c.add(p1, BorderLayout.NORTH);

        Panel p2 = new Panel();
        p2.setBackground(Color.gray);
        p2.setLayout(new FlowLayout());
        p2.add(uno);
        p2.add(due);
        p2.add(tre);
        p2.add(quattro);

        cancella.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
            }
        });
        p2.add(cancella);

        c.add(p2, BorderLayout.CENTER);

        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}