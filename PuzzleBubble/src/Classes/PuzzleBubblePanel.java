package Classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Timothy on 30/10/2015.
 */
public class PuzzleBubblePanel extends JPanel{

    private PuzzleBubbleDrawingPanel puzzleBubbleDrawingPanel;

    private JFileChooser fileChooser;
    private JButton test;

    private PuzzleBubble puzzleBubble;
    public PuzzleBubblePanel (PuzzleBubble puzzleBubble) {
        setLayout(new BorderLayout());
        this.puzzleBubble = puzzleBubble;

        createComponents();
        addComponents();
        addActionListeners();

    }

    private void addActionListeners() {

    }

    private void addComponents() {
        add(puzzleBubbleDrawingPanel, BorderLayout.SOUTH);
        add(test, BorderLayout.NORTH);


    }

    private void createComponents() {
        puzzleBubbleDrawingPanel= new PuzzleBubbleDrawingPanel(this.puzzleBubble);
        fileChooser = new JFileChooser();
        test = new JButton();
        test.setText("TEST");
    }


}
