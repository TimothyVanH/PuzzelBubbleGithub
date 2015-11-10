package Classes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by yodi on 9-11-2015.
 */
public class Bubble {
    private int xPos;
    private int yPos;
    private double xSpeed;
    private double ySpeed;
    private int color;
    private BufferedImage image;
    private Bubble[] linktedBubbles;


    public Bubble(int xPos,int yPos)
    {
        this.xPos =  xPos;
        this.yPos = yPos;

    };

    public void Shoot(int speed,int arc)
    {
        ySpeed = Math.sin(arc) * speed;
        xSpeed = Math.cos(arc) * speed;
        image =  ImageIO.read(new File("img/bubbleBlue.png"));
    }

    public void Draw()
    {

    }
    public void  bounce(){
        xSpeed  =  xSpeed * -1;
    }

}
