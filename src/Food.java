import java.awt.*;
public class Food {
    int[] food={1, 1};
    final int WIDTH =10;
    public Food(Board board){
        food[0]=((int)((Math.random()*board.getWidth())-WIDTH)/10)*10;
        food[1]=((int)((Math.random()*board.getHeight())-WIDTH)/10)*10;
    }
    public int[] getCoord(){
        return food;
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(food[0], food[1], WIDTH, WIDTH);
    }
    public void eaten(Board board){
        food[0]=((int)((Math.random()*board.getWidth())-WIDTH)/10)*10;
        food[1]=((int)((Math.random()*board.getHeight())-WIDTH)/10)*10;
    }
}