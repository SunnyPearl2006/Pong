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
  Paddle paddle2;
  Timer loop;

  public Game() {
    this.loop = new Timer(1000/25,this);
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
    this.ball = new Ball(this.getWidth()/2, (this.getHeight()/2), Color.BLACK);
    //Genreal forumala seems to be half the width and finetune until the correct number is found
    this.paddle = new Paddle(this.getWidth()/2-40, ((this.getHeight()/2)/2)+this.getHeight()/2, Color.BLACK);
    this.paddle2 = new Paddle(this.getWidth()/2-40, ((this.getHeight()/2)/2), Color.BLACK);
    this.loop.start();
  
  }
  public boolean gameOver(){
    if(ball.getY() > 465 || ball.getY() < 32 ){
      //this.repaint();
      ball.reset(this.getWidth()/2,this.getHeight()/2 + 12);
      paddle2.reset(this.getWidth()/2-40);
      paddle.reset(this.getWidth()/2-40);
      this.repaint();
      return true;
    }
    return false;
  }
  public boolean collision(){
    
    if((ball.getY() + 25 <= paddle.getY() && ball.getY() >= paddle.getY()-30) && (ball.getX() >= paddle.getX() -25 && ball.getX() <= paddle.getX() + 105) ){
      //System.out.println(ball.getY());
      return true;
    }
    if((ball.getY()   <= paddle2.getY() + 30 && ball.getY()   >= paddle2.getY() + 25) && (ball.getX() >= paddle2.getX() -25 && ball.getX() <= paddle2.getX() + 110) ){
      //System.out.println(ball.getY());
      return true;
    }
    if(ball.getX()+25 > this.window.getWidth() || ball.getX() < 10 ){
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
    paddle2.draw(gen);
    
  }
  
  
  @Override
  public void keyPressed(KeyEvent e){ 
    if(e.getKeyCode() == KeyEvent.VK_LEFT){
      paddle.moveL();
    }
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      paddle.moveR();
    }
    if(e.getKeyCode() == KeyEvent.VK_A){
      paddle2.moveL();
    }
    if(e.getKeyCode() == KeyEvent.VK_D){
      paddle2.moveR();
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
    
    }
    if(collision()){
      ball.colMath(ball.getX(), ball.getY(),paddle,paddle2);
    }
    ball.move();
    this.repaint();
  

  }
   


  }

 