import java.awt.*;
import java.util.ArrayList;
public class Snake {
    int[] head={0, 0};
    ArrayList<Integer> tail=new ArrayList<Integer>();
    int x, y, dx, dy;
    final int WIDTH=10;
    int speed=10, direction=3;
    boolean skipTailMove=false, started=false;
    public Snake(Board board){
        head[0]=board.getWidth()/4;
        head[1]=board.getHeight()/2;
        tail.add(head[0]-WIDTH);
        tail.add(head[1]);
        tail.add(getNum(tail.size()-2)-10);
        tail.add(getNum(tail.size()-2));
    }
    public void move(){
        for(int i=tail.size()-1; i>0; i--){
            if(i>1) {
                tail.set(i, tail.get(i-2));
            }else if(i<=1){
                tail.set(i, head[i]);
            }
        }
        if(direction==12){
            head[1]-=WIDTH;
        }else if(direction==3){
            head[0]+=WIDTH;
        }
    }
    public void addLength(){
            tail.add(0, head[0]);
            tail.add(1, head[1]);
            skipTailMove=true;
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
            direction=9;
        }
    }
    public void turnUp(){
        if(dy!=10){
            dy=Math.abs(speed)*-1;
            dx=0;
            direction=12;
        }
    }
    public void turnDown(){
        if(dy!=-10){
            dy=Math.abs(speed);
            dx=0;
            direction=6;
        }
    }
    public void paint(Graphics g){
        if(started=false){
        }
        for(int i=-2; i<tail.size(); i+=2) {
            if(i<0){
                g.setColor(Color.RED);
                g.fillRect(head[0], head[1], WIDTH, WIDTH);
            }else if(i>=0){
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
    }/*
    public void moveTail(int index){
        int get=index*2;
        tail.set(get, tail.get(get-2));
        tail.set(get-1, tail.get(get-3));
    }
    public int tailLength(){
        return tail.size()/2;
    }
    public Rectangle getBounds(){
        return new Rectangle(head[0], head[1], WIDTH, WIDTH);
    }
    public boolean isSkipTailMove() {
        return skipTailMove;
    }
    public void resetTailMove(){
        skipTailMove=false;
    }*/
}