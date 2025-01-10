import java.awt.*;

class Main {
    public static void main(String args[]) {
        Frame f = new Frame("Albero di Natale");
        Albero a = new Albero();
        
        f.setSize(1000,600);
        f.add(a);
        f.setVisible(true);
    }
}