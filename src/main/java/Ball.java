import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
public class Ball{
  int x;
  int y;
  int VelX;
  int VelY;
  Color color;
  public Ball(int x , int y, Color color){
    this.x = x;
    this.y = y;
    this.color = color;
  }
  public void move(){
    x+=VelX;
    y+=VelY;
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