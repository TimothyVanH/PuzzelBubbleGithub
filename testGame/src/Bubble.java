import javax.swing.*;
import java.awt.*;

/**
 * Created by Gebruiker on 13/11/2015.
 */
public class Bubble {
    private Image image;
    private int x;
    private int y;
    private double xSpeed = 0;
    private double ySpeed = 0;
    private int color;
    private boolean sticky;
    private Bubble[] conectedBubbles;



    public Bubble(int x, int y ,int color)
    {
        this.x = x+25;
        this.y = y+25;
        this.color = color;
        loadImage();
        conectedBubbles =  new Bubble[6];
        sticky = false;
    }

    public int GetColor(){
        return color;
    }
    public int GetX()
    {
        return x;
    }
    public int GetY()
    {
        return y;
    }
    public void  SetX(int x){
        this.x = x;
    }
    public void SetY(int y){
        this.y =  y;
    }
    public boolean GetSticky(){
        return sticky;
    }
    public void SetSticky(boolean toSet){
        sticky =  toSet;
    }

    private void loadImage()
    {
        String path =  "sprite/bubble_" + color + ".png";
        ImageIcon ii = new ImageIcon(path);
        image = ii.getImage();
    }
    private void Move()
    {
        x =  x  + (int) xSpeed;
        y = y + (int) ySpeed;
    }

    public void Draw(Graphics g)
    {
        Move();
        g.drawImage(image,x-25,y-25, null);
    }

    public void shoot(double arc,int speed)
    {
        ySpeed = Math.sin(Math.toRadians(arc)) * speed;
        xSpeed = Math.cos(Math.toRadians(arc)) * speed;
    }

    public void Bounce(){
        xSpeed =  xSpeed*-1;
    }
    public void Stop(){
        xSpeed = 0;
        ySpeed = 0;
    }
    public double GetDistanceTo(Bubble toHit){
        double distance = Math.sqrt(Math.pow((x)-(toHit.GetX()),2)+Math.pow((y)-(toHit.GetY()),2));
        return distance;
    }
    public void BubbleHit(Bubble toAdd){
        toAdd.Stop();
        sticky = true;
        int deltaX = toAdd.GetX()-x;
        int deltaY = toAdd.GetY()-y;

      if(deltaY < 12)
      {
          toAdd.SetY(y);
          if(deltaX >0) {
              conectedBubbles[3] = toAdd;
              toAdd.SetX(x+50);
              toAdd.AddConectedBubble(this,2);
              toAdd.AddConectedBubble(conectedBubbles[1],0);
              toAdd.AddConectedBubble(conectedBubbles[5],4);
          }
          else {
              conectedBubbles[2] = toAdd;
              toAdd.SetX(x-50);
              toAdd.AddConectedBubble(this,3);
              toAdd.AddConectedBubble(conectedBubbles[0],1);
              toAdd.AddConectedBubble(conectedBubbles[4],5);
          }
      }
      else{
          toAdd.SetY(y+50);
          if(deltaX >0) {
              conectedBubbles[5] = toAdd;
              toAdd.SetX(x+25);
              toAdd.AddConectedBubble(this,0);
              toAdd.AddConectedBubble(conectedBubbles[3],1);
              toAdd.AddConectedBubble(conectedBubbles[4],2);
          }
          else {
              conectedBubbles[4] = toAdd;
              toAdd.SetX(x-25);
              toAdd.AddConectedBubble(this,1);
              toAdd.AddConectedBubble(conectedBubbles[2],0);
              toAdd.AddConectedBubble(conectedBubbles[5],3);
          }
      }
    }
    public void AddConectedBubble(Bubble toAdd,int space){
        conectedBubbles[space] =  toAdd;
    }

    public int CountSameColor(Bubble origen,int count){
        int res  = count + 1;
        for (Bubble bubble: conectedBubbles)
        {
            if(bubble != null && bubble != origen && bubble.color == color)
            {
                res = bubble.CountSameColor(this,res);
            }
        }
        if(res >= 3){
            Pop();
        }
        return res;
    }

    public void Pop(){
        conectedBubbles = new Bubble[6];
//        for (int i = 0; i<conectedBubbles.length;i++)
//        {
//            if(conectedBubbles[i] != null){
//                conectedBubbles[i].DeleteMe(5-i);
//            }
//        }
    }
    public void DeleteMe(int position){
        conectedBubbles[position] = null;
    }

    public boolean ControleOnSticky(){
        boolean res = false;
        if(!sticky){
            for(Bubble conectedBubble:conectedBubbles)
            {
                if(conectedBubble != null && conectedBubble.ControleOnSticky())
                {
                    sticky = true;
                }
            }
        }
        res =  sticky;
        return res;
    }

}
