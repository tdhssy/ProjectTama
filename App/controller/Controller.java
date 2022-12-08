package controller;

import java.util.ArrayList;

import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.suite.api.SelectClasses;

import javafx.application.Platform;
import model.Engine;
import model.room.RoomEngine;
import model.saveEngine.Save;
import view.View;
import view.Game.GameView;
import view.Menu.LoadOption;
import view.Menu.LoadSaveMenu;
import view.Menu.NewGameMenu;

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
	private GameView game_v;
	private NewGameMenu new_game_v;
	private LoadSaveMenu load_game_v;
	private LoadOption load_option_v;

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

	public void loadEvent(String save_name)
	{
		engine = Engine.loadSave(this, save_name);
		View.changeScene(5); //GameView
		game_v = View.getGameView();
		load_game_v = null;
	}

	/*
	 * Récupère les informations du tama sur la view et
	 * les passes au modèle puis passe de l'interface Menu
	 * à l'interface Game.
	 */
	public void launchGame()
	{
		try {
			if(StringUtils.isBlank(new_game_v.getTamaName()) || Save.saveExist(new_game_v.getTamaName())){
				System.out.println("Nom incorrecte ou déjà existant dans les sauvegardes");
			} //Evite un nom composé simplement d'espace
			else{
				engine = Engine.createEngineInstance(this, new_game_v.getTamaType(),  new_game_v.getTamaName());
				View.changeScene(5); //GameView
				game_v = View.getGameView();
				game_v.setRoom(engine.getCurrentRoom());
				game_v.setName(engine.getInstanceName());
				game_v.setType(engine.getTypeTama());
				new_game_v = null;
			}
		} catch (Exception e) {
			System.err.println("Erreur de chargement");
			e.printStackTrace();
		}
	}

	public void loadGame(String save){
		engine = Engine.loadSave(this, save);
		View.changeScene(5); //GameView
		game_v = View.getGameView();
		game_v.setRoom(engine.getCurrentRoom());
		game_v.setName(engine.getInstanceName());
		game_v.setType(engine.getTypeTama());
		load_game_v = null;
		updateStatView();
	}

	/*
	 * Permet l'actuallisation de toutes les stats sur la view.
	 * A appeler à chaque changement des stats.
	 */
	public void updateStatView(){
		//TODO
		
		ArrayList<Double> new_data = engine.getDatasPourcent();

		//System.out.println(new_data.get(1));
		game_v.setHunger(new_data.get(1));
		game_v.setHealth(new_data.get(0));
		game_v.setMental(new_data.get(3));
		game_v.setSleep(new_data.get(5));
		game_v.setNeed(new_data.get(4));
		game_v.setPhysical(new_data.get(2));
		game_v.setHygiene(new_data.get(6));
		
		//Check si le tama est mort, si oui délanche l'écran de game over
		if(engine.isDead()) Platform.runLater(() -> {	death();   });
	}

	public void update_room(){
		Platform.runLater(() -> {game_v.setRoom(engine.getCurrentRoom());});
	}

	/*
	 * Permet de gérer les actions de jeu attrapées par l'actionController.
	 * 0 = besoin
	 * 1 = Manger
	 * 2 = Jouer
	 * 3 = Dormir
	 * 4 = Se laver
	 * 5 = Changer salle (droite)
	 * 6 = Changer salle (gauche)
	 */
	public void gameAction(int action){
		switch (action) {
			case 0:
				engine.besoin();
				break;
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
				game_v.setRoom(engine.nextRoom());
				break;
			case 6:
				game_v.setRoom(engine.previousRoom());
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
	 * 8 = charger
	 */
	public void menuAction(int action){
		//TODO
		switch (action) {
			case 1:
				View.changeScene(2);
				new_game_v = View.getNewGameMenu();
				break;
			case 2:
				View.changeScene(3);
				load_game_v = View.getLoadSaveView();
				for(String save : Engine.getAllSaveName()){
					load_game_v.addListSave(save);
				};
				break;
			case 3:
				View.changeScene(4);
				load_option_v = View.getLoadOption();
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
				if (engine != null) engine.destroy(); //à supp plus tard
				new_game_v = null;
				break;
			case 8:
				System.out.println("load");
				if(load_game_v != null) {
					String selectedSave = load_game_v.getSelectedSave(); 
					loadGame(selectedSave);
				}
				break;
			case 9:
				QuitGame();
				break;
			case 10:
				String selectedSave = load_game_v.getSelectedSave();
				Save.deleteSave(selectedSave);
				menuAction(2); //update le menu charger la partie 
				break;
			default:
				System.out.println("Action menu par defaut");
				break;
		}
	}

	private void QuitGame() {
		engine.quit();
		View.changeScene(1);
		game_v=null;

	}

	private void death(){
		engine.destroy();
		game_v.displayDeath();
		//System.out.println("Tu es mort.");
	}
}
