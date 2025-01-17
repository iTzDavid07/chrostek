import java.awt.*;

class Albero extends Canvas {
    public void paint(Graphics g) {
        g.setColor(Color.decode("#6d3b07"));
        g.fillRect(480, 470, 40, 50);
        
        g.setColor(Color.decode("#06402b"));
        g.fillPolygon(new int[] {220, 780, 500}, new int[] {470, 470, 300}, 3);
        g.fillPolygon(new int[] {270, 730, 500}, new int[] {370, 370, 200}, 3);
        g.fillPolygon(new int[] {340, 660, 500}, new int[] {250, 250, 100}, 3);
        g.fillPolygon(new int[] {410, 590, 500}, new int[] {150, 150, 50}, 3);
    
        g.setColor(Color.decode("#ff0000"));
        g.fillOval(510, 100, 25, 25);
        g.fillOval(450, 180, 25, 25);
        g.fillOval(530, 270, 25, 25);
        g.fillOval(370, 320, 25, 25);
        g.fillOval(580, 390, 25, 25);
        g.fillOval(330, 430, 25, 25);

        g.setColor(Color.decode("#fffff0"));
        g.fillOval(530, 190, 25, 25);
        g.fillOval(450, 280, 25, 25);
        g.fillOval(520, 340, 25, 25);
        g.fillOval(420, 410, 25, 25);

        g.setColor(Color.decode("#e5be01"));
        g.fillPolygon(new int[] {460, 540, 500}, new int[] {70, 70, 10}, 3);
        g.fillPolygon(new int[] {460, 540, 500}, new int[] {30, 30, 90}, 3);
    }
}