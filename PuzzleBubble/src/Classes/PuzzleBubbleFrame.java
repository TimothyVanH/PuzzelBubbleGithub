package Classes;

import javax.swing.*;

/**
 * Created by Timothy on 30/10/2015.
 */
public class PuzzleBubbleFrame extends JFrame {
    public PuzzleBubbleFrame(PuzzleBubble puzzleBubble){
        super();
        setTitle("PuzzleBubble");
        setContentPane(new PuzzleBubbleDrawingPanel(puzzleBubble));
        setVisible(true);







    }





}
