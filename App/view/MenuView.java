package view;

import javax.swing.JFrame;

/*
 * Fenetre principale de l'écran de menu.
 * 
 * Singleton
 */
public class MenuView extends JFrame implements View
{
    private static MenuView menuView = null;

    private MenuView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
		setSize(900, 600);
		setLocationRelativeTo(null);
    }

    public static View getMenuView()
    {
        if(menuView == null)
        menuView = new MenuView();
        
        return menuView;
    }

    @Override
    public void setup(String title)
    {
        setTitle(title);
        setVisible(true);
    }

    @Override
    public void hide()
    {
        setVisible(false);
    }
}
