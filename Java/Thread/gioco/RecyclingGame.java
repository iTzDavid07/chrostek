import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class RecyclingGame extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private int playerX;
    private final int playerY = 400; // posizione verticale fissa
    private final int playerWidth = 80, playerHeight = 109; // dimensioni del giocatore
    private int score = 0;
    private int lives = 3;
    private boolean gameOver = false;
    private ArrayList<FallingObject> objects;
    private Random random;
    
    // Contatori per spawn indipendenti
    private int spawnRaeeCounter = 0;
    private int spawnWasteCounter = 0;

    // Array di immagini per il giocatore, RAEE e rifiuti
    private Image playerImage;
    private Image[] playerImages;
    private Image[] raeeImages;
    private Image[] wasteImages;

    // Bottoni per Game Over
    private JButton restartButton, exitButton;

    public RecyclingGame() {
        setPreferredSize(new Dimension(600, 500));
        setBackground(Color.decode("#118a88")); // colore di sfondo
        setFocusable(true);
        addKeyListener(this);
        // Imposta layout nullo per posizionare i bottoni manualmente
        setLayout(null);

        playerX = 260; // posizione iniziale centrata
        objects = new ArrayList<>();
        random = new Random();

        // Carica immagini del giocatore (sostituisci con il percorso corretto)
        // Carica le 4 immagini del cestino e imposta la prima come immagine iniziale
        playerImages = new Image[4];
        playerImages[0] = new ImageIcon("resources/cestino1.png").getImage();
        playerImages[1] = new ImageIcon("resources/cestino2.png").getImage();
        playerImages[2] = new ImageIcon("resources/cestino3.png").getImage();
        playerImages[3] = new ImageIcon("resources/cestino4.png").getImage();
        playerImage = playerImages[0];

        // Carica immagini RAEE (esempio: quattro immagini differenti)
        raeeImages = new Image[4];
        raeeImages[0] = new ImageIcon("resources/raee1.png").getImage();
        raeeImages[1] = new ImageIcon("resources/raee2.png").getImage();
        raeeImages[2] = new ImageIcon("resources/raee3.png").getImage();
        raeeImages[3] = new ImageIcon("resources/raee4.png").getImage();

        // Carica immagini rifiuti (esempio: quattro immagini differenti)
        wasteImages = new Image[4];
        wasteImages[0] = new ImageIcon("resources/bad1.png").getImage();
        wasteImages[1] = new ImageIcon("resources/bad2.png").getImage();
        wasteImages[2] = new ImageIcon("resources/bad3.png").getImage();
        wasteImages[3] = new ImageIcon("resources/bad4.png").getImage();

        timer = new Timer(30, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            // Aggiorna i contatori per spawn indipendenti
            spawnRaeeCounter++;
            spawnWasteCounter++;
            if (spawnRaeeCounter > 70) {  // Regola la frequenza dei RAEE
                spawnRaee();
                spawnRaeeCounter = 0;
            }
            if (spawnWasteCounter > 50) { // Regola la frequenza dei rifiuti
                spawnWaste();
                spawnWasteCounter = 0;
            }
            
            // Aggiorna la posizione degli oggetti
            for (int i = 0; i < objects.size(); i++) {
                FallingObject obj = objects.get(i);
                obj.update();
                // Rileva la collisione con il giocatore solo se l'oggetto colpisce la parte superiore
                Rectangle playerTopRect = new Rectangle(playerX + 10, playerY, playerWidth - 20, 20);
                Rectangle objRect = new Rectangle(obj.x, obj.y, obj.size, obj.size);
                if (playerTopRect.intersects(objRect)) {
                    if (obj.isRaee) {
                        score += 10; // raccogliendo un RAEE, aumenti il punteggio
                    } else {
                        lives--;   // raccogliendo un rifiuto, perdi una vita
                        if (lives <= 0) {
                            gameOver = true;
                            timer.stop();
                            showGameOverButtons();
                        }
                    }
                    objects.remove(i);
                    i--;
                } else if (obj.y > getHeight()) {
                    // Se l'oggetto esce dallo schermo, rimuovilo
                    objects.remove(i);
                    i--;
                }
            }
            // Aggiorna l'immagine del giocatore in base al punteggio
            if (score >= 30) {
                playerImage = playerImages[3];
            } else if (score >= 20) {
                playerImage = playerImages[2];
            } else if (score >= 10) {
                playerImage = playerImages[1];
            } else {
                playerImage = playerImages[0];
            }
            repaint();
        }
    }
    
    // Funzione per spawnare un RAEE
    private void spawnRaee() {
        int x = random.nextInt(getWidth() - 30);
        int size = 40;
        int speed = 4; // velocità
        int idx = random.nextInt(raeeImages.length);
        Image img = raeeImages[idx];
        objects.add(new FallingObject(x, 0, size, speed, true, img));
    }
    
    // Funzione per spawnare un rifiuto
    private void spawnWaste() {
        int x = random.nextInt(getWidth() - 30);
        int size = 40;
        int speed = 4; // velocità
        int idx = random.nextInt(wasteImages.length);
        Image img = wasteImages[idx];
        objects.add(new FallingObject(x, 0, size, speed, false, img));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna il cestino del giocatore
        if (playerImage != null) {
            g.drawImage(playerImage, playerX, playerY, playerWidth, playerHeight, this);
        } else {
            g.setColor(Color.YELLOW);
            g.fillRect(playerX, playerY, playerWidth, playerHeight);
        }

        // Disegna gli oggetti in caduta
        for (FallingObject obj : objects) {
            if (obj.img != null) {
                g.drawImage(obj.img, obj.x, obj.y, obj.size, obj.size, this);
            } else {
                // Fallback: disegna forme
                if (obj.isRaee) {
                    g.setColor(Color.GREEN);
                    g.fillOval(obj.x, obj.y, obj.size, obj.size);
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(obj.x, obj.y, obj.size, obj.size);
                }
            }
        }

        // Disegna il punteggio e le vite
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Vite: " + lives, 10, 40);

        // Visualizza Game Over
        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", getWidth() / 2 - 100, getHeight() / 2 - 40);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Punteggio: " + score, getWidth() / 2 - 60, getHeight() / 2);
            // I bottoni saranno aggiunti separatamente
        }
    }

    // Mostra i bottoni per uscire o ricominciare al termine del gioco
    private void showGameOverButtons() {
        exitButton = new JButton("Esci");
        exitButton.setBounds(getWidth() / 2 - 130, getHeight() / 2 + 20, 100, 30);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

        restartButton = new JButton("Ricomincia");
        restartButton.setBounds(getWidth() / 2 + 30, getHeight() / 2 + 20, 120, 30);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        add(restartButton);

        revalidate();
        repaint();
    }

    // Reset dello stato del gioco per ricominciare
    private void restartGame() {
        remove(restartButton);
        remove(exitButton);
        restartButton = null;
        exitButton = null;
        score = 0;
        lives = 3;
        gameOver = false;
        objects.clear();
        playerX = 260;
        spawnRaeeCounter = 0;
        spawnWasteCounter = 0;
        timer.start();

        revalidate();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (!gameOver) {
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                playerX -= 15;
                if (playerX < 0) {
                    playerX = 0;
                }
            } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                playerX += 15;
                if (playerX > getWidth() - playerWidth) {
                    playerX = getWidth() - playerWidth;
                }
            }
        }
    }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }

    class FallingObject {
        int x, y, size, speed;
        boolean isRaee;
        Image img;

        public FallingObject(int x, int y, int size, int speed, boolean isRaee, Image img) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.speed = speed;
            this.isRaee = isRaee;
            this.img = img;
        }

        public void update() {
            y += speed;
        }
    }
}
