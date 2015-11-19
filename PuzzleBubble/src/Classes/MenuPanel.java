package Classes;

import javax.swing.*;

/**
 * Created by laure on 12/11/2015.
 */
public class MenuPanel extends JPanel {

    public MenuPanel(){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        addMenuButtons();
    }

    private void addMenuButtons(){
        JButton buttonArcade = new JButton("Arcade");
        JButton buttonCampaign = new JButton("Campaign");
        JButton buttonMultiplayer = new JButton("Multiplayer");

        add(buttonArcade);
        add(buttonCampaign);
        add(buttonMultiplayer);
    }

}
