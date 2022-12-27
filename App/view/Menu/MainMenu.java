package view.Menu;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import view.View;

public class MainMenu extends Scene {

    Button nouvelle_partie;
    Button charger_partie;
    Button parametre;
    Button quitter;
    BorderPane main;
    VBox root;

    public MainMenu(Parent arg0, double arg1, double arg2) {
        super(arg0, arg1, arg2);

        int l = View.largeur/3;
        int h = View.hauteur/9;

        main = new BorderPane();

        root = new VBox();

        nouvelle_partie = new Button("Nouvelle partie");
        nouvelle_partie.setPrefSize(l, h);
        nouvelle_partie.setOnAction(e -> {
        ActionController.event("Go_new_game");
        });

        charger_partie = new Button("Charger une partie");
        charger_partie.setPrefSize(l, h);
        charger_partie.setOnAction(e -> {
        ActionController.event("Go_load_game");
        });

        parametre = new Button("Parametre");
        parametre.setPrefSize(l, h);
        parametre.setOnAction(e -> {
        ActionController.event("Go_parametre");
        });

        quitter = new Button("Quitter");
        quitter.setPrefSize(l, h);
        quitter.setOnAction(e -> {
        ActionController.event("quitter");
        });

        //Ajout des boutons au root
        root.getChildren().add(nouvelle_partie);
        root.getChildren().add(charger_partie);
        root.getChildren().add(parametre);
        root.getChildren().add(quitter);
        
        root.setAlignment(Pos.CENTER);

        main.setCenter(root);

        //Réglage de l'emplacement des boutons
        VBox.setMargin(nouvelle_partie, new Insets(h/6, l/6, h/6, l/6));
        VBox.setMargin(charger_partie, new Insets(h/6, l/6, h/6, l/6));
        VBox.setMargin(parametre, new Insets(h/6, l/6, h/6, l/6));
        VBox.setMargin(quitter, new Insets(h/6, l/6, h/6, l/6));
        
        //Change la couleur du fond d'écran
        main.setStyle("-fx-background-color: grey;");

        //Place le root sur la scene
        setRoot(main);
    }
    
}