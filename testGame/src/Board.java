import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by yodi on 12-11-2015.
 */
public class Board extends JPanel {
    private List<Bubble> bubbleInField;
    private List<Bubble> topBubbles;
    private Bow bow;
    private List<Bubble> flyingBubble;
    private List<Bubble> toDelete;


    public Board() {
        bubbleInField = new ArrayList<Bubble>();
        flyingBubble = new ArrayList<Bubble>();
        topBubbles = new ArrayList<Bubble>();
        toDelete = new ArrayList<Bubble>();
        //CreatField();
        bow = new Bow();

        setDoubleBuffered(true);

    }

    private void CreatField() {
        bubbleInField.add(new Bubble(0, 0, 1));
        bubbleInField.add(new Bubble(50, 0, 2));
        bubbleInField.add(new Bubble(100, 0, 3));
        bubbleInField.add(new Bubble(150, 0, 4));
        bubbleInField.add(new Bubble(25, 50, 5));
        bubbleInField.add(new Bubble(75, 50, 6));
    }

    private void BorderCheck() {
        for (Bubble bubble : flyingBubble) {
            if (bubble.GetX() < 25) {
                bubble.Bounce();
                bubble.SetX(25);
            }
            if (bubble.GetX() > 475) {
                bubble.Bounce();
                bubble.SetX(475);
            }
            if (bubble.GetY() < 25) {
                bubble.Stop();
                bubbleInField.add(bubble);
                topBubbles.add(bubble);
                flyingBubble.remove(bubble);
                bubble.SetX((bubble.GetX() / 50) * 50 + 25);
                bubble.SetY(25);
            }
        }
    }


    private void hitDetect() {
        for (Bubble bubbleFlying : flyingBubble) {
            synchronized (bubbleInField) {
                for (Bubble bubbleStil : bubbleInField) {
                    if (bubbleFlying.GetDistanceTo(bubbleStil) < 50) {
                        bubbleStil.BubbleHit(bubbleFlying);
                        bubbleFlying.CountSameColor(bubbleFlying, 0);
                        bubbleInField.add(bubbleFlying);
                        flyingBubble.remove(bubbleFlying);
                        PopControl();
                    }
                }
            }
        }
    }

    private void PopControl() {
        for (Bubble bubble : bubbleInField) {
            bubble.SetSticky(false);
        }
        for (Bubble bubble : topBubbles) {
            bubble.SetSticky(true);
        }
        for (Bubble bubble : bubbleInField) {
            if (!bubble.ControleOnSticky()) {
                toDelete.add(bubble);
            }
        }
        bubbleInField.removeAll(toDelete);

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            bow.TurnLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            bow.TurnRight();
        }
        if (key == KeyEvent.VK_UP) {
            flyingBubble.add(bow.Shoot());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Draw(g);
    }

    public void Draw(Graphics g) {
        for (Bubble bubble : bubbleInField) {
            bubble.Draw(g);
        }
        bow.Draw(g);
        if (flyingBubble.size() > 0) {
            for (Bubble bubble : flyingBubble) {
                BorderCheck();
                hitDetect();
                bubble.Draw(g);
            }
        }
    }

    public void Repaint() {
        repaint();
    }
}