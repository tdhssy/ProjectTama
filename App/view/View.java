package view;

//import javax.swing.border.Border;

import controller.ActionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        
        BorderPane root = new BorderPane();

        Button button = new Button("Test");
        button.setOnAction(e -> ActionController.event("Test"));
        Button button1 = new Button("Test1");
        button1.setOnAction(e -> ActionController.event("Test1"));

        root.setCenter(button);
        root.setBottom(button1);;

        Scene scene = new Scene(root, 960,540);
        
        stage.setScene(scene);
        stage.show();
        
    }
}
