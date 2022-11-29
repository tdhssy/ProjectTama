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
    Button b_dormir;
    Button b_laver;
    Button b_jouer;
    Button b_besoin;

    Text t_type;
    Text t_name;

    ProgressBar pb_healthBar;
    ProgressBar pb_hungerBar;
    ProgressBar pb_mentalBar;
    ProgressBar pb_needBar;
    ProgressBar pb_sleepBar;
    ProgressBar pb_hygieneBar;
    ProgressBar pb_physicalBar;


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

        b_dormir = new Button("Dormir");
        b_dormir.setPrefSize(300, 35);
        b_dormir.setOnAction(e -> ActionController.event("Dormir"));

        b_laver = new Button("Laver");
        b_laver.setPrefSize(300, 35);
        b_laver.setOnAction(e -> ActionController.event("Laver"));

        b_jouer = new Button("Jouer");
        b_jouer.setPrefSize(300, 35);
        b_jouer.setOnAction(e -> ActionController.event("Jouer"));

        b_besoin = new Button("Besoin");
        b_besoin.setPrefSize(300, 35);
        b_besoin.setOnAction(e -> ActionController.event("Besoin"));

        t_name = new Text();
        t_type = new Text();

        pb_healthBar = new ProgressBar(1);
        pb_healthBar.setPrefWidth(150);

        pb_hungerBar = new ProgressBar(0.5);
        pb_hungerBar.setPrefWidth(150);

        pb_mentalBar = new ProgressBar(0.5);
        pb_mentalBar.setPrefWidth(150);

        pb_needBar = new ProgressBar(0.5);
        pb_needBar.setPrefWidth(150);

        pb_sleepBar = new ProgressBar(0.5);
        pb_sleepBar.setPrefWidth(150);

        pb_hygieneBar = new ProgressBar(0.5);
        pb_hygieneBar.setPrefWidth(150);

        pb_physicalBar = new ProgressBar(0.5);
        pb_physicalBar.setPrefWidth(150);
        
        root.getChildren().add(t_name);
        root.getChildren().add(t_type);
        root.getChildren().add(pb_healthBar);
        root.getChildren().add(pb_hungerBar);
        root.getChildren().add(pb_mentalBar);
        root.getChildren().add(pb_sleepBar);
        root.getChildren().add(pb_needBar);
        root.getChildren().add(pb_physicalBar);
        root.getChildren().add(pb_hygieneBar);
        root.getChildren().add(b_manger);
        root.getChildren().add(b_jouer);
        root.getChildren().add(b_laver);
        root.getChildren().add(b_dormir);
        root.getChildren().add(b_besoin);
        root.getChildren().add(b_quitter);

        /*
        VBox.setMargin(t_name, new Insets(30, 20, 20, 330));
        VBox.setMargin(t_type, new Insets(30, 20, 20, 330));
        VBox.setMargin(pb_healthBar, new Insets(30, 20, 20, 330));
        VBox.setMargin(pb_hungerBar, new Insets(30, 20, 20, 330));
        VBox.setMargin(pb_mentalBar, new Insets(30, 20, 20, 330));
        VBox.setMargin(pb_sleepBar, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_manger, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_jouer, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_laver, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_dormir, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_besoin, new Insets(30, 20, 20, 330));
        VBox.setMargin(b_quitter, new Insets(30, 20, 20, 330));
        */
        setRoot(root);
    }

    public void setHunger(double x){
        pb_hungerBar.setProgress(x);
    }

    public void setHealth(double x){
        pb_healthBar.setProgress(x);
    }

    public void setMental(double x){
        pb_mentalBar.setProgress(x);
    }

    public void setNeed(double x){
        pb_needBar.setProgress(x);
    }

    public void setSleep(double x){
        pb_sleepBar.setProgress(x);
    }

    public void setPhysical(double x) {
        pb_physicalBar.setProgress(x);
    }

    public void setHygiene(double x) {
        pb_hygieneBar.setProgress(x);
    }

    public void setName(String s){
        t_name.setText(s);
    }

    public void setType(String s){
        t_type.setText(s);
    }

}
