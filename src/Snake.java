import java.awt.*;
import java.util.ArrayList;
public class Snake {
    ArrayList<Snake> snake=new ArrayList<Snake>();
    int x, y, dx,dy;
    final int WIDTH=10;
    int speed=10, direction=3;
    public Snake(Board board){
        x=board.getWidth()/4;
        y=board.getHeight()/2;
    }
    public void turnRight(){
        if(dx!=-10){
            dx=Math.abs(speed);
            dy=0;
            direction=3;
        }
    }
    public void turnLeft(){
        if(dx!=10){
            dx=Math.abs(speed)*-1;
            dy=0;
        }
    }
    public void turnUp(){
        if(dy!=10){
            dy=Math.abs(speed)*-1;
            dx=0;
        }
    }
    public void turnDown(){
        if(dy!=-10){
            dy=Math.abs(speed);
            dx=0;
        }
    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, WIDTH, WIDTH);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWIDTH(){
        return WIDTH;
    }
}