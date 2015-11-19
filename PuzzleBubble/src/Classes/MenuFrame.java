package Classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by laure on 12/11/2015.
 */
public class MenuFrame extends JFrame {

    public MenuFrame(){
        super();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        new JFrame("Puzzle Bobble");


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setContentPane(new PuzzleBubbleDrawingPanel(MenuPanel));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        setVisible(true);

    }
}
