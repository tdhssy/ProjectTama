import controller.Controller;
import controller.Test;

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

		}else if (args.length == 1 && args[0].equals("-t"))
		{
			Test test = new Test();
			test.startTest();

		}else
		{
			System.err.println("Usage : java -jar Tama.jar OPTIONNEL");
			System.err.println("OPTIONNEL : [-t] (Lance la série de test)");
		}
	}
}
