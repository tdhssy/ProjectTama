package controller;

//import view.GameView;
//import view.MenuView;

/*
 * La classe du controller, permet de gérer
 * l'application.
 * 
 * Singleton
 */
public class Controller 
{	
	static private Controller controller = null;
	//private MenuView menu_view;
	//private GameView game_view;

	private Controller(){
		//TODO : Constructeur
	}

	/*
	 * Getter du controller.
	 * Permet d'instancier un controller
	 * unique lors du premier appel de
	 * la méthode.
	 */
	//bffhurfsbnhjxsbnufdy
	static public Controller getController(){
		if(controller == null)
			controller = new Controller();
		
		return controller;
	}

	/*
	 * Permet le lancement de l'interface 
	 * graphique du Menu.
	 */
	public void startEvent()
	{
		//menu_view = MenuView.getMenuView();
		//menu_view.setup("TamaToxic");
	}

	/*
	 * Ferme l'application.
	 */
	public void closeEvent()
	{
		System.exit(0);
	}

	public void loadEvent(String view)
	{
		//menu_view.update(view);
	}

	/*
	 * Permet de passer de l'interface Menu
	 * à l'interface Game.
	 */
	public void launchGame(String title)
	{
		//menu_view.hide(); //Cache la vue du Menu

		//game_view = GameView.getGameView(); //Accède à la vue du jeu
		//game_view.setup(title);
	}
}
