package Classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by laure on 12/11/2015.
 */
public class MenuFrame extends JFrame {

    public MenuFrame(){
        super();
        setTitle("Puzzle Bobble - Menu");
        add(new MenuPanel());

        pack();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
