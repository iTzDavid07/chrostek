import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class BossFightGUI extends JFrame {
    private Menu menu = new Menu();

    public BossFightGUI() {
        super("Boss Fight");

        add(menu);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BossFightGUI();
    }
}

class Menu extends JPanel {
    private Color GREEN = Color.getHSBColor(0.33f, 1, 1);

    private Dimension menuDimensions = new Dimension(400, 300);
    private JPanel titlePanel = new JPanel();
    private JLabel title = new JLabel("Scegli i boss da affrontare");

    private JPanel bossGrid = new JPanel();
    private String[] bossList = {"Boss1", "Boss2", "Boss3", "Boss4", "Boss5", "Boss6", "Boss7", "Boss8"};

    private JPanel nextPanel = new JPanel();
    private JButton next = new JButton("Prosegui");

    public Menu() {
        setPreferredSize(menuDimensions);
        setLayout(new GridLayout(3, 1));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(Color.BLACK);

        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setOpaque(false);

        title.setForeground(GREEN);
        try {
            Font hellbone = Font.createFont(Font.TRUETYPE_FONT, new File("font/Hellbone.otf")).deriveFont(30f);
            title.setFont(hellbone);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        titlePanel.add(title);
        add(titlePanel);

        bossGrid.setLayout(new GridLayout(2, 4));
        bossGrid.setOpaque(false);

        for (String boss : bossList) {
            JButton b = new JButton(boss);

            MouseListener mouseListener = new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    b.setContentAreaFilled(true);
                    b.setBackground(Color.DARK_GRAY);
                }
                public void mouseExited(MouseEvent e) {
                    b.setContentAreaFilled(false);
                }
            };

            b.setForeground(Color.WHITE);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.addMouseListener(mouseListener);
            b.addActionListener(e -> {
                if (!b.isSelected()) {
                    b.removeMouseListener(mouseListener);
                    b.setBackground(Color.DARK_GRAY);
                    b.setSelected(true);
                } else {
                    b.addMouseListener(mouseListener);
                    b.setSelected(false);
                }
            });

            bossGrid.add(b);
        }
        add(bossGrid);

        nextPanel.setLayout(new GridBagLayout());
        nextPanel.setOpaque(false);

        next.setForeground(Color.WHITE);
        next.setContentAreaFilled(false);
        next.setFocusPainted(false);
        next.setBorder(new LineBorder(GREEN, 2));
        next.setPreferredSize(new Dimension(95, 32));
        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        next.setFont(new Font("Roboto", 1, 14));

        nextPanel.add(next);
        add(nextPanel);
    }
}