import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements ActionListener,KeyListener {
  JPanel window;
  Ball ball; 
  Paddle paddle;
  Timer loop;

  public Game() {
    this.loop = new Timer(1000/30,this);
    setUp();
  }

  public void setUp() { 
    //Since each iteration of the timer counts as an actionevent, don't need to add actionlistener to window or frame
;   this.window = new JPanel();
    this.addKeyListener(( KeyListener)this);
    this.setTitle("Pong");
    this.setSize(500, 500);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(window);
    this.setVisible(true);
    this.ball = new Ball(this.getWidth()/2, (this.getHeight()/2)/2, Color.BLACK);
    //Genreal forumala seems to be half the width and finetune until the correct number is found
    this.paddle = new Paddle(this.getWidth()/2-40, ((this.getHeight()/2)/2)+this.getHeight()/2, Color.BLACK);
    this.loop.start();
  
  }
  public boolean gameOver(){
    if(ball.getY() > 465){
      return true;
    }
    return false;
  }
  public boolean colPaddle(){

    if(ball.getY() >= paddle.getY()){
      return true;
    }
    return false;
  }
  @Override
  public void paint(Graphics g) {
    Graphics gen = (Graphics) g;
    super.paint(g);
    ball.draw(gen);
    paddle.draw(gen);
    
  }
  
  
  @Override
  public void keyPressed(KeyEvent e){ 
    if(e.getKeyCode() == KeyEvent.VK_LEFT){
      paddle.moveL();
    }
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      paddle.moveR();
    }
 
  }
  @Override
  public void keyReleased(KeyEvent e){
    
  }
  @Override
  public void keyTyped(KeyEvent e){
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(gameOver()){
      loop.stop();
    } else {
      if(colPaddle()){
        //System.out.println("Here");
        ball.paddleCol();
      }
      ball.move();
      this.repaint();
    }
  

  }
   


  }

 