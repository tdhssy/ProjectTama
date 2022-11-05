package controller;

/*
 * La classe du controller, permet de gérer
 * l'application.
 * 
 * Singleton
 */
public class Controller 
{	
	static private Controller controller = null;

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
	 * graphique.
	 */
	public void startEvent()
	{
		//TODO : startEvent
	}
}
