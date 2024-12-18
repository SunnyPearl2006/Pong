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
    this.grav = 10;
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
    //Genreal formula seems to be half the height(same as width) and add to width(same as height)
    // (500 - 25) = 575, 25/2 = 12.5
    // 575 - 12 =  563, finetuned
    if(y > 465){
      //TODO: replace with actual physics math to proberly calculate velocity later
      y=465;
      VelY = 0;
      grav = -10;
    // 0 + 25 = 25
    // 25 + 12 = 37, finetuned
    } else if(y < 32){
      //TODO: replace with actual physics math to proberly calculate velocity later
      y = 32;
      VelY = 0;
      grav = 10;
    }
    System.out.println(y);

    
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