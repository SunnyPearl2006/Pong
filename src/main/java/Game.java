import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements KeyListener {
  public JPanel window;
  Ball ball; 
  Paddle paddle;

  public Game() {
    setUp();
  }

  public void setUp() {
    this.window = new JPanel();
    this.addKeyListener((KeyListener) this);
    this.setTitle("Pong");
    this.setSize(500, 500);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(window);
    this.setVisible(true);
    this.ball = new Ball(this.window.getWidth()/2, (this.window.getHeight()/2)/2, Color.BLACK);
   this.paddle = new Paddle(this.window.getWidth()/2-40, ((this.window.getHeight()/2)/2)+this.window.getHeight()/2, Color.BLACK);
   
  
  }
  @Override
  public void paint(Graphics g) {
    Graphics gen = (Graphics) g;
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
    this.repaint();
  }
  @Override
  public void keyReleased(KeyEvent e){
    
  }
  @Override
  public void keyTyped(KeyEvent e){
  }


}