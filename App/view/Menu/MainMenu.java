package view.Menu;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Component;

import controller.ActionController;

public class MainMenu extends JPanel
{
   /*
     * Éléments de l'interface graphique.
     */
    JButton b_Charger_Partie = new JButton("Charger une partie");
    JButton b_Nouvelle_Partie = new JButton("Nouvelle partie");
    JButton b_Quitter = new JButton("Quitter");

    public MainMenu()
    {
        b_Charger_Partie.addActionListener(new ActionController());
        b_Charger_Partie.setActionCommand("Menu charger partie");
        b_Charger_Partie.setAlignmentX(Component.CENTER_ALIGNMENT);

        b_Nouvelle_Partie.addActionListener(new ActionController());
        b_Nouvelle_Partie.setActionCommand("Menu nouvelle partie");
        b_Nouvelle_Partie.setAlignmentX(Component.CENTER_ALIGNMENT);

        b_Quitter.addActionListener(new ActionController());
        b_Quitter.setActionCommand("Menu quitter");
        b_Quitter.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(b_Charger_Partie);
        add(b_Nouvelle_Partie);
        add(b_Quitter);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        setVisible(true);
    }
}
