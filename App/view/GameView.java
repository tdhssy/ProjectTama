package view;

import javax.swing.JFrame;

/*
 * Fenetre principale de l'écran de jeu.
 * 
 * Singleton
 */
public class GameView extends JFrame implements View
{
    private static GameView gameView = null;

    private GameView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
		setSize(900, 600);
		setLocationRelativeTo(null);
    }

    public static View getGameView()
    {
        if(gameView == null)
        gameView = new GameView();
        
        return gameView;
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
