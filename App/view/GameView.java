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

    Button b_quitter;//Pour les tests
    Button b_manger;

    Text t_name;
    Text t_type;
    
    ProgressBar pb_healthBar;
    ProgressBar pb_hungerBar;


    VBox root;

    public GameView(Parent arg0, double arg1, double arg2) {
        super(arg0, arg1, arg2);
        
        root = new VBox();

        b_quitter = new Button("Quitter");
        b_quitter.setPrefSize(300, 35);
        b_quitter.setOnAction(e -> ActionController.event("quitter"));
        
        b_manger = new Button("Manger");
        b_manger.setPrefSize(300, 35);
        b_manger.setOnAction(e -> ActionController.event("Manger"));

        t_name = new Text();
        t_type = new Text();

        pb_healthBar = new ProgressBar(1);
        pb_healthBar.setPrefWidth(150);

        pb_hungerBar = new ProgressBar(0.5);
        pb_hungerBar.setPrefWidth(150);
        
        root.getChildren().add(t_name);
        root.getChildren().add(t_type);
        root.getChildren().add(pb_healthBar);
        root.getChildren().add(pb_hungerBar);
        root.getChildren().add(b_manger);
        root.getChildren().add(b_quitter);

        VBox.setMargin(t_name, new Insets(30, 20, 20, 330));
        VBox.setMargin(t_type, new Insets(30, 20, 20, 330));
        VBox.setMargin(pb_healthBar, new Insets(30, 20, 20, 330));
        VBox.setMargin(pb_hungerBar, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_manger, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_quitter, new Insets(30, 20, 20, 330));
        
        setRoot(root);
    }

    public void setHunger(double x){
        pb_hungerBar.setProgress(x);
    }

    public void setName(String s){
        t_name.setText(s);
    }

    public void setType(String s){
        t_type.setText(s);
    }
}
