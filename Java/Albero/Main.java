import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Albero di Natale");
        Albero a = new Albero();
        Container c = frame.getContentPane();

        c.add(a);
        
        frame.setSize(1000,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}