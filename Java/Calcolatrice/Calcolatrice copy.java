import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calcolatrice extends JFrame implements ActionListener   {
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
    private JPanel pb = new JPanel();
	private JTextField centigradi = new JTextField(15);
	private JTextField fahrenheit = new JTextField(15);
	private JButton converti = new JButton ("converti");
	private JButton cancella = new JButton ("cancella");
	
	public Calcolatrice ()  {
        super ("Convertitore centigradi -> fahrenheit");

        p1.add(new JLabel("Gradi centigradi: "));
        p1.add(centigradi);

        cancella.addActionListener(this);
        converti.addActionListener(this);
        pb.add(converti);
        pb.add(cancella);

        p2.add(new JLabel("Gradi faharenheit: "));
        p2.add(fahrenheit);

        setLayout(new GridLayout(3,1,5,10));
        add(p1);
        add(pb);
        add(p2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)  {
        String bottone = e.getActionCommand();

        if (bottone.equals("converti")) {
            try
            {
                String nLetto = centigradi.getText();
                double cent = Double.valueOf(nLetto).doubleValue();
                double far = 32 + (cent / 100) * 180;
                fahrenheit.setText(" " + far);
            }
            catch(Exception exc)
            {
                fahrenheit.setText("");
            }
        } else if (bottone.equals("cancella")) {
            centigradi.setText("");
            fahrenheit.setText("");
        }
	}
 }