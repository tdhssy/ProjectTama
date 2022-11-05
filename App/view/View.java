package view;

public interface View
{
    public static GameView getGameView()
    {
        return GameView.getGameView();
    }

    public static MenuView getMenuView()
    {
        return MenuView.getMenuView();
    }

    /*
     * Permet d'afficher et de donner un nom
     * à l'interface.
     */
    public void setup(String title);

    /*
     * Permet de cacher l'interface.
     * Utile pour passer de l'interface Menu
     * à l'interface Game.
     */
    public void hide();
}
