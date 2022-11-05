package view;

import javax.swing.JFrame;

/*
 * Fenetre principale de l'écran de jeu.
 * 
 * Singleton
 */
public class GameView extends JFrame implements View
{
    private static GameView game_View = null;

    private GameView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
		setSize(900, 600);
		setLocationRelativeTo(null);
    }

    public static GameView getGameView()
    {
        if(game_View == null)
        game_View = new GameView();
        
        return game_View;
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
