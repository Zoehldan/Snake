import org.w3c.dom.css.Rect;

import java.awt.*;

public class Food {
    int x=0, y=0, range=5;
    final int WIDTH =10;
    public Food(Board board){
        x=((int)((Math.random()*board.getWidth())-WIDTH)/10)*10;
        y=((int)((Math.random()*board.getHeight())-WIDTH)/10)*10;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, WIDTH);
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, WIDTH, WIDTH);
    }
    public void eaten(Board board){
        x=((int)((Math.random()*board.getWidth())-WIDTH)/10)*10;
        y=((int)((Math.random()*board.getHeight())-WIDTH)/10)*10;
    }
}