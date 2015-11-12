package Classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Timothy on 30/10/2015.
 */
public class PuzzleBubbleFrame extends JFrame {
    public PuzzleBubbleFrame(PuzzleBubble puzzleBubble){
        super();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("PuzzleBubble");
        setContentPane(new PuzzleBubbleDrawingPanel(puzzleBubble));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        setVisible(true);
    }
}