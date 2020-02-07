import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    Snake snake;
    Food food;
    Timer timer;
    Long timeDelay;
    Game game;
    int score=0;
    public Board(Game game){
        this.game=game;
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.GRAY);
        timer=new Timer(1000/30, this);
        timer.start();
    }
    public void setup(){
        snake=new Snake(this);
        food=new Food(this);
        timeDelay=System.currentTimeMillis();
    }
    public void checkCollisions(){
        if(snake.getHead()[0]==food.getCoord()[0]&&snake.getHead()[1]==food.getCoord()[1]){
            snake.addLength();
            food.eaten(this);
            score+=10;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        long currentTime=System.currentTimeMillis();
        checkCollisions();
        if(currentTime-timeDelay>=150){
            snake.move(this);
            timeDelay=System.currentTimeMillis();
        }
        if(game.isRightPressed()){
            snake.turnRight();
        }
        if(game.isLeftPressed()){
            snake.turnLeft();
        }
        if(game.isUpPressed()){
            snake.turnUp();
        }
        if(game.isDownPressed()){
            snake.turnDown();
        }
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        printSimpleString("SCORE: "+score, getWidth(), -375, 40, g);
        snake.paint(g);
        food.paint(g);
    }
    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g){
        int stringLen=(int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start=width/2-stringLen/2;
        g.drawString(s, start+XPos, YPos);
    }
}