package Classes;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

/**
 * Created by Timothy on 30/10/2015.
 */
public class PuzzleBubbleDrawingPanel extends JPanel {
    private PuzzleBubble puzzleBubble;

    public PuzzleBubbleDrawingPanel(PuzzleBubble puzzleBubble){
        this.puzzleBubble = puzzleBubble;
        setPreferredSize(new Dimension(150,600));



    }





}
