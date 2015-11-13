package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Timothy on 30/10/2015.
 */
public class Board extends JPanel{
    private List<Bubble> bubbleInField;
    private Bow bow;

    private Bubble testBubble = new Bubble(225,500,3);

    public Board(){
        bubbleInField =  new ArrayList<Bubble>();
        //CreatField();
        bow = new Bow();
        testBubble.shoot(1,5);

        setDoubleBuffered(true);

    }
    private void CreatField()
    {
        bubbleInField.add(new Bubble(0,0,1));
        bubbleInField.add(new Bubble(50,0,2));
        bubbleInField.add(new Bubble(100,0,3));
        bubbleInField.add(new Bubble(150,0,4));
        bubbleInField.add(new Bubble(25,50,5));
        bubbleInField.add(new Bubble(75,50,6));
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Draw(g);
    }

    public void Draw(Graphics g)
    {
        for (Bubble bubble: bubbleInField){
            bubble.Draw(g);
        }
        bow.Draw(g);

        testBubble.Draw(g);
    }
    public void Repaint()
    {
        repaint();
    }
}
