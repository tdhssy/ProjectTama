package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import view.Menu.MainMenu;

/*
 * Fenetre principale de l'écran de menu.
 * 
 * Singleton
 */
public class MenuView extends JFrame implements View
{
    private static MenuView menu_View = null;

    private MenuView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
		setSize(900, 600);
		setLocationRelativeTo(null);
    }

    public static View getMenuView()
    {
        if(menu_View == null)
        menu_View = new MenuView();
        
        return menu_View;
    }

    @Override
    public void setup(String title)
    {
        setTitle(title);

        JPanel main_menu = new MainMenu();
        add(main_menu/*, BorderLayout.CENTER*/);

        setVisible(true);
    }

    @Override
    public void hide()
    {
        setVisible(false);
    }
}
