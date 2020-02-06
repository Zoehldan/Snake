import java.awt.*;
import java.util.ArrayList;
public class Snake {
    int[] head={0, 0};
    ArrayList<Integer> tail=new ArrayList<Integer>();
    final int WIDTH=10;
    int direction=3, turn;
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
        direction=turn;
        if(skipTailMove==false) {
            for(int i=tail.size()-1; i>=0; i--){
                if(i>1){
                    tail.set(i, tail.get(i-2));
                }else if(i<=1){
                    tail.set(i, head[i]);
                }
            }
        }
        if(direction==12){
            head[1]-=WIDTH;
        }else if(direction==3){
            head[0]+=WIDTH;
        }else if(direction==6){
            head[1]+=WIDTH;
        }else if(direction==9){
            head[0]-=WIDTH;
        }
        skipTailMove=false;
    }
    public void addLength(){
            tail.add(0, head[0]);
            tail.add(1, head[1]);
            skipTailMove=true;
    }
    public void turnRight(){
        if(direction!=9){
            turn=3;
        }
    }
    public void turnLeft(){
        if(direction!=3){
            turn=9;
        }
    }
    public void turnUp(){
        if(direction!=6){
            turn=12;
        }
    }
    public void turnDown(){
        if(direction!=12){
            turn=6;
        }
    }
    public void paint(Graphics g){
        if(started=true){
            for(int i=-2; i<tail.size()-1; i+=2){
                if(i<0){
                    g.setColor(Color.RED);
                    g.fillRect(head[0], head[1], WIDTH, WIDTH);
                }else if(i>=0){
                    g.setColor(Color.BLACK);
                    g.fillRect(tail.get(i), tail.get(i + 1), WIDTH, WIDTH);
                }
            }
        }
    }
    public int getNum(int index){
        return tail.get(index);
    }
    public int[] getHead(){
        return head;
    }
    public int getWIDTH(){
        return WIDTH;
    }
    public Rectangle getBounds(){
        return new Rectangle(head[0], head[1], WIDTH, WIDTH);
    }
}
