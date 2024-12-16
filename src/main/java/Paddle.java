import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
public class Paddle{
  int x;
  int y;
  int VelX;
  Color color;
  public Paddle(int x , int y, Color color){
    this.x = x;
    this.y = y;
    this.color = color;
    this.VelX = 10;
  }
  public void moveL(){
    x-=VelX;
    
  }
  public void moveR(){
    x+=VelX;

  }

  public void draw(Graphics g){
  
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawRect(x, y, 100, 25);

  }
  public int getX(){
    return x;
  }
}