package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {   
        BorderPane root = new BorderPane(); //Juste pour pouvoir appeler la scene

        scene = new MenuView(root, 960,540);
        
        stage.setScene(scene);
        stage.show();   
    }
}
