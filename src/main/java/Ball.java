import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
public class Ball{
  int x;
  int y;
  int VelX;
  int VelY;
  Color color;
  int grav;
  public Ball(int x , int y, Color color){
    this.grav = 2;
    this.x = x;
    this.y = y;
    this.VelY  = 0;
    this.VelX = 0;
    this.color = color;
  }
  public void move(){
    if(y < 32){
      //TODO: replace with actual physics math to proberly calculate velocity later
      y = 32;
      VelY = 0;
      grav = 2;
    }
    

    VelY += grav;
    x+=VelX;
    y+=VelY;
    
    

    
  }
  public void paddleCol(){
      VelY = 0;
      grav = -2;
      System.out.println(VelY);
  }
  
  public void draw(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawOval(x, y, 25, 25);
    g2d.setColor(color);
    g2d.fillOval(x,y,25,25);
    
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  
}