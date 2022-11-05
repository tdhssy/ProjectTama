package controller;

import view.View;

/*
 * La classe du controller, permet de gérer
 * l'application.
 * 
 * Singleton
 */
public class Controller 
{	
	static private Controller controller = null;
	private View view;

	private Controller(){
		//TODO : Constructeur
	}

	/*
	 * Getter du controller.
	 * Permet d'instancier un controller
	 * unique lors du premier appel de
	 * la méthode.
	 */
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
		view = View.getMenuView();
		view.setup("TamaToxic");
	}

	/*
	 * Permet de passer de l'interface Menu
	 * à l'interface Game.
	 */
	public void launchGame(String title)
	{
		view.hide(); //Cache la vue du Menu

		view = View.getGameView(); //Accède à la vue du jeu
		view.setup(title);
	}
}
