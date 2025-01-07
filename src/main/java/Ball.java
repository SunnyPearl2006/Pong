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
    this.VelY  = 4;
    this.VelX = 4;
    this.color = color;
  }
  public void move(){
    

 
    x+=VelX;
    y+=VelY;
    
    

    
  }
  public void reset(int x , int y){
    this.x = x;
    this.y = y;
  }
  public void colMath(int x , int y , Paddle paddle, Paddle paddle2){
    if((y + 25 <= paddle.getY() && y >= paddle.getY()-30) && (x >= paddle.getX() -25 && x <= paddle.getX() + 105) ){

      VelY = -4;
    }
    if((y  <= paddle2.getY() + 45 && y   >= paddle2.getY() + 25) && (x >= paddle2.getX() -25 && x <= paddle2.getX() + 110) ){
  
      VelY = 4;
    }
    if(x+35 > 500){
      VelX = -4;
    }
    if(x < 10){
      System.out.println(x);
      VelX = 4;
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