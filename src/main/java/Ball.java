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
    

    VelY += grav;
    x+=VelX;
    y+=VelY;
    
    

    
  }
  public void reset(int x , int y){
    this.x = x;
    this.y = y;
  }
  public void colMath(){
      if(this.y < 250){
        VelY = 0;
        grav = 2;
      } else {
        VelY = 0;
        grav = -2;
      }
     
      //System.out.println(VelY);
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