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
    }
}