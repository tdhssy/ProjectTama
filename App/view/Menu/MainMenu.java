package view.Menu;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenu extends Scene {

    Button nouvelle_partie;
    Button charger_partie;
    Button parametre;
    Button quitter;

    VBox root;

    public MainMenu(Parent arg0, double arg1, double arg2) {
        super(arg0, arg1, arg2);
        
        root = new VBox();

        nouvelle_partie = new Button("Nouvelle partie");
        nouvelle_partie.setPrefSize(300, 35);
        nouvelle_partie.setOnAction(e -> ActionController.event("Go_new_game"));

        charger_partie = new Button("Charger une partie");
        charger_partie.setPrefSize(300, 35);
        charger_partie.setOnAction(e -> ActionController.event("Go_load_game"));

        parametre = new Button("Parametre");
        parametre.setPrefSize(300, 35);
        parametre.setOnAction(e -> ActionController.event("Go_parametre"));

        quitter = new Button("Quitter");
        quitter.setPrefSize(300, 35);
        quitter.setOnAction(e -> ActionController.event("quitter"));

        //Ajout des boutons au root
        root.getChildren().add(nouvelle_partie);
        root.getChildren().add(charger_partie);
        root.getChildren().add(parametre);
        root.getChildren().add(quitter);
        
        //Réglage de l'emplacement des boutons
        VBox.setMargin(nouvelle_partie, new Insets(135, 20, 20, 330));
        VBox.setMargin(charger_partie, new Insets(30, 20, 20, 330));
        VBox.setMargin(parametre, new Insets(30, 20, 20, 330));
        VBox.setMargin(quitter, new Insets(30, 20, 20, 330));
        
        //Change la couleur du fond d'écran
        root.setStyle("-fx-background-color: grey;");

        //Place le root sur la scene
        setRoot(root);
    }
    
}