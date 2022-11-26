package view;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameView extends Scene
{

    Button quitter;//Pour les tests
    Text name;
    Text type;
    ProgressBar healthBar;


    VBox root;

    public GameView(Parent arg0, double arg1, double arg2) {
        super(arg0, arg1, arg2);
        
        root = new VBox();

        quitter = new Button("Quitter");
        quitter.setPrefSize(300, 35);
        quitter.setOnAction(e -> ActionController.event("quitter"));

        name = new Text();
        type = new Text();
        
        root.getChildren().add(name);
        root.getChildren().add(type);
        root.getChildren().add(quitter);

        VBox.setMargin(name, new Insets(30, 20, 20, 330));
        VBox.setMargin(type, new Insets(30, 20, 20, 330));
        VBox.setMargin(quitter, new Insets(30, 20, 20, 330));
        
        setRoot(root);
    }

    public void setName(String s){
        name.setText(s);
    }

    public void setType(String s){
        type.setText(s);
    }
}
