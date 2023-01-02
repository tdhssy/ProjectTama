import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;


/*
 * Classe principale, contient le main.
 */
public class Launch extends Application
{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Controller controller = Controller.getController();
		controller.startEvent();
	}
}
