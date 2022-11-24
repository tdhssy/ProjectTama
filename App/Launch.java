import controller.Controller;

/*
 * Classe principale, contient le main.
 */
public class Launch
{
	public static void main(String[] args) {
		if (args.length == 0)
		{
			Controller controller = Controller.getController();
			controller.startEvent();

		}else
		{
			System.err.println("Usage : java -jar Tama.jar");
		}
	}
}
