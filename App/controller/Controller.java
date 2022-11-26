package controller;

import java.util.ArrayList;

import org.junit.vintage.engine.descriptor.VintageEngineDescriptor;

import model.Engine;
import view.GameView;
//import view.GameView;
//import view.MenuView;
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
	private Engine engine;
	private GameView game_view;

	private Controller(){
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
		View.launch();
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
	 * Récupère les informations du tama sur la view et
	 * les passes au modèle puis passe de l'interface Menu
	 * à l'interface Game.
	 */
	public void launchGame()
	{
		try {
			engine = Engine.createEngineInstance(this, View.getNewGameMenu().getType(),  View.getNewGameMenu().getText());
			View.changeScene(5); //GameView
			game_view = View.getGameView();
			game_view.setName(engine.getInstanceName());
			game_view.setType(View.getNewGameMenu().getType());
		} catch (Exception e) {
			System.err.println("Erreur de chargement");
		}
	}

	/*
	 * Permet l'actuallisation de toutes les stats sur la view.
	 * A appeler à chaque changement des stats.
	 */
	public void updateStatView(){
		//TODO
		ArrayList<Integer> new_data = engine.getTamaDatas();
	}

	/*
	 * Permet de gérer les actions de jeu attrapées par l'actionController.
	 * 1 = Manger
	 * 2 = Jouer
	 * 3 = Dormir
	 * 4 = Se laver
	 * 5 = Changer salle (droite)
	 * 6 = Changer salle (gauche)
	 */
	public void gameAction(int action){
		switch (action) {
			case 1:
				engine.manger();
				break;
			case 2:
				engine.jouer();
				break;
			case 3:
				engine.dormir();
				break;
			case 4:
				engine.seLaver();
				break;
			case 5:
				//TODO
				break;
			case 6:
				//TODO
				break;
			default:
				System.out.println("Action game par defaut");
				break;
		}
		updateStatView();
	}

	/*
	 * Permet de gérer les actions du menu attrapées par l'actionController.
	 * 1 = go menu Nouvelle partie
	 * 2 = go menu Charger une partie
	 * 3 = go menu Parametre
	 * 4 = Sauvegarder
	 * 5 = Quitter app
	 * 6 = Lancer une partie
	 * 7 = go menu principal
	 */
	public void menuAction(int action){
		//TODO
		switch (action) {
			case 1:
				View.changeScene(2);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				engine.makeSave();
				break;
			case 5:
				closeEvent();
				break;
			case 6:
				launchGame();
				break;
			case 7:
				View.changeScene(1);
				break;
			default:
				System.out.println("Action menu par defaut");
				break;
		}
	}
}
