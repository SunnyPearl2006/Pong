import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
public class Paddle{
  int x;
  int y;
  Color color;
  public Paddle(int x , int y, Color color){
    this.x = x;
    this.y = y;
    this.color = color;
  }
  public void moveL(){
   
    x-=10;
    x = Math.max(x,10);
    
  }
  public void moveR(){

    x+=10;
    x = Math.min(x,390);


  }
  public void reset(int x){
    this.x = x;
  }

  public void draw(Graphics g){
  
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawRect(x, y, 100, 25);

  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
}