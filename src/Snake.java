import java.awt.*;
import java.util.ArrayList;
public class Snake {
    int[] head={0, 0};
    ArrayList<Integer> tail=new ArrayList<Integer>();
    int x, y, dx, dy;
    final int WIDTH=10;
    int speed=10, direction=3;
    public Snake(Board board){
        head[0]=board.getWidth()/4;
        head[1]=board.getHeight()/2;
        tail.add(head[0]-WIDTH);
        tail.add(head[1]);
        tail.add(getNum(tail.size()-2)-10);
        tail.add(getNum(tail.size()-2));
    }
    public void addLength(){
        if(dx==10){
            tail.add(getNum(tail.size()-2)-10);
            tail.add(getNum(tail.size()-2));
        }else
        if(dx==10){
            tail.add(getNum(tail.size()-2)+10);
            tail.add(getNum(tail.size()-2));
        }else
        if(dy==10){
            tail.add(getNum(tail.size()-2)-10);
            tail.add(getNum(tail.size()-2)-10);
        }else
        if(dy==-10){
            tail.add(getNum(tail.size()-2));
            tail.add(getNum(tail.size()-2)+10);
        }else
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
        for(int i=0; i<tail.size(); i+=2) {
            if(i==0){
                g.setColor(Color.RED);
                g.fillRect(head[0], head[1], WIDTH, WIDTH);
            }else if(i>0){
                System.out.println("run");
                g.setColor(Color.BLACK);
                g.fillRect(tail.get(i), tail.get(i+1), WIDTH, WIDTH);
            }
        }
    }
    public int getNum(int index){
        return tail.get(index);
    }
    public int getWIDTH(){
        return WIDTH;
    }
    public Rectangle getBounds(){
        return new Rectangle(head[0], head[1], WIDTH, WIDTH);
    }
}