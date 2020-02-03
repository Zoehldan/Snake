import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {
    Snake snake;
    Food food;
    Timer timer;
    Game game;
    int score=0, foodEaten=0;
    public Board(Game game){
        this.game=game;
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.GRAY);
        timer=new Timer(1000/2, this);
        timer.start();
    }
    public void setup(){
        snake=new Snake(this);
        food=new Food(this);
    }
    public void checkCollisions(){
        if(snake.getBounds().intersects(food.getBounds())){
            snake.addLength();
            food.eaten(this);
        }
    }
    public void actionPerformed(ActionEvent e){
        checkCollisions();
        if(game.isRightPressed()==true){
            snake.turnRight();
        }
        if(game.isLeftPressed()==true){
            snake.turnLeft();
        }
        if(game.isUpPressed()==true){
            snake.turnUp();
        }
        if(game.isDownPressed()==true){
            snake.turnDown();
        }
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        printSimpleString("SCORE: "+score, getWidth(), 0, 0, g);
        snake.paint(g);
        food.paint(g);
    }
    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g){
        int stringLen=(int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start=width/2-stringLen/2;
        g.drawString(s, start+XPos, YPos);
    }
}