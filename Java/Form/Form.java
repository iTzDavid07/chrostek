import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    private int width = 500;
    private int height = 600;

    private JTextField nameField = new JTextField(15);
    private JTextField surnameField = new JTextField(15);
    private JTextField numberField = new JTextField(15);
    private String nationality[] = {"Italiana", "Inglese", "Americana", "Tedesca", "Polacca"};
    private JComboBox<String> nationalityComboBox = new JComboBox<>(nationality);
    private JCheckBox studentCheckBox = new JCheckBox("Studente");
    private JCheckBox workerCheckBox = new JCheckBox("Lavoratore");

    private JButton accept = new JButton("Accetta");
    private JButton cancel = new JButton("Annulla");

    public Form() {
        super("Form");

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(5, 2, 0, 5));
        p1.add(new Label("Nome:"));
        p1.add(nameField);
        p1.add(new Label("Cognome:"));
        p1.add(surnameField);
        p1.add(new Label("Numero di telefono:"));
        p1.add(numberField);
        p1.add(new Label("Nazionalità:"));
        p1.add(nationalityComboBox);
        p1.add(new Label("Status:"));

        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        p3.add(studentCheckBox);
        p3.add(workerCheckBox);

        p1.add(p3);

        c.add(p1, BorderLayout.NORTH);

        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        p2.add(accept);
        p2.add(cancel);

        c.add(p2, BorderLayout.CENTER);

        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}