package view;

//import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.Menu.LoadSaveMenu;
import view.Menu.MainMenu;
import view.Menu.NewGameMenu;

/*
 * Fenetre principale de l'écran de menu.
 * 
 * Singleton
 */
public class MenuView extends JFrame implements View
{
    private static MenuView menu_View = null;

    /*
     * Éléments de l'interface graphique.
     */
    JPanel panel = new MainMenu();

    private MenuView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
		setSize(900, 600);
		setLocationRelativeTo(null);
    }

    public static MenuView getMenuView()
    {
        if(menu_View == null)
        menu_View = new MenuView();
        
        return menu_View;
    }

    @Override
    public void setup(String title)
    {
        setTitle(title);

        add(panel/*, BorderLayout.CENTER*/);

        setVisible(true);
    }

    @Override
    public void hide()
    {
        setVisible(false);
    }

    public void update(String view)
    {
        remove(panel);
        
        switch (view) {
            case "Main": panel = new MainMenu();                
                break;
            case "Load": panel = new LoadSaveMenu();
                break;
            case "New Game": panel = new NewGameMenu();
        }

        add(panel/*, BorderLayout.CENTER*/);
        setVisible(true);
    }
}
