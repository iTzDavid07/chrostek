import javax.swing.JFrame;

public class RecyclingGamemain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gioco Raccolta Differenziata");
        RecyclingGame gamePanel = new RecyclingGame();
        frame   .add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
