package view.Menu;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NewGameMenu extends Scene
{
    /*
     * Éléments de l'interface graphique.
     */
    Button startGame;
    Button retour;
    Button tamaChien;
    Button tamaChat;
    Button tamaLapin;
    Button tamaRobot;
    TextField tamaName;

    VBox root;
     
    public NewGameMenu(Parent arg0, double arg1, double arg2)
    {
        super(arg0, arg1, arg2);

        root = new VBox();

        startGame = new Button("Commencer la partie");
        startGame.setOnAction(e -> ActionController.event("StartGame"));
        startGame.setPrefSize(200, 35);

        retour = new Button("Retour");
        retour.setOnAction(e -> ActionController.event("Go_main_menu"));
        retour.setPrefSize(100, 35);

        tamaName = new TextField("Nom du Tamagotchi");
        tamaName.setMaxWidth(220);

        //Ajout des boutons au root
        root.getChildren().add(tamaName);
        root.getChildren().add(startGame);
        root.getChildren().add(retour);

        //Réglage de l'emplacement des boutons
        VBox.setMargin(tamaName, new Insets(135, 20, 20, 325));
        VBox.setMargin(startGame, new Insets(50, 20, -35, 435));
        VBox.setMargin(retour, new Insets(0, 20, 20, 325));

        //Change la couleur du fond d'écran
        root.setStyle("-fx-background-color: grey;");

        //Place le root sur la scene
        setRoot(root);
    }

    public String getText(){
        return tamaName.getText();
    }
}
