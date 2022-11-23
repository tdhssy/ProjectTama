package view.Menu;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;

import controller.ActionController;

public class LoadSaveMenu extends JPanel
{
    /*
     * Éléments de l'interface graphique.
     */
    JLabel title = new JLabel("Charger une partie");
    JButton b_retour = new JButton("Retour");
     
    public LoadSaveMenu()
    {
       // b_retour.addActionListener(new ActionController());
        b_retour.setActionCommand("Load retour");
        b_retour.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(title);
        add(b_retour);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        
        setVisible(true);
    }
}
