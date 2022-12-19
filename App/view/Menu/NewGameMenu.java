package view.Menu;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
    Text name;

    VBox root;

    String tamaType = "TamaChien";
     
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

        tamaChien = new Button("Chien");//A modifier par une image
        tamaChien.setOnAction(e -> changeType("TamaChien"));
        tamaChien.setPrefSize(100, 100);
        tamaChien.setGraphic(new ImageView("Dog/Dog_Stay.gif"));

        tamaChat = new Button("Chat");//A modifier par une image
        tamaChat.setOnAction(e -> changeType("TamaChat"));
        tamaChat.setPrefSize(100, 100);
        tamaChat.setGraphic(new ImageView("Cat/Cat_Stay.gif"));

        tamaLapin = new Button("Lapin");//A modifier par une image
        tamaLapin.setOnAction(e -> changeType("TamaLapin"));
        tamaLapin.setPrefSize(100, 100);
        tamaLapin.setGraphic(new ImageView("Bunny/Bunny_Stay.gif"));

        tamaRobot = new Button("Robot");//A modifier par une image
        tamaRobot.setOnAction(e -> changeType("TamaRobot"));
        tamaRobot.setPrefSize(100, 100);
        tamaRobot.setGraphic(new ImageView("Robot/Robot_Stay.gif"));

        this.setOnKeyPressed(e -> ActionController.keyEventNewGameMenu(e)); //Pour les raccourci claviver

        tamaName = new TextField("");
        tamaName.setMaxWidth(220);
        tamaName.setMaxHeight(30);

        name = new Text("Nom de votre compagnon :");
        Font font = Font.font("Verdana", FontWeight.BOLD, 13);
        name.setFont(font);

        //Ajout des boutons au root
        //L'ordre est important
        root.getChildren().add(tamaChien);
        root.getChildren().add(tamaChat);
        root.getChildren().add(tamaLapin);
        root.getChildren().add(tamaRobot);
        root.getChildren().add(tamaName);
        root.getChildren().add(name);
        root.getChildren().add(startGame);
        root.getChildren().add(retour);

        //Réglage de l'emplacement des boutons
        VBox.setMargin(tamaChien, new Insets(135, 20, -100, 275));
        VBox.setMargin(tamaChat, new Insets(0, 20, -100, 375));
        VBox.setMargin(tamaLapin, new Insets(0, 20, -100, 475));
        VBox.setMargin(tamaRobot, new Insets(0, 20, 20, 575));
        VBox.setMargin(tamaName, new Insets(20, 20, -20, 450));
        VBox.setMargin(name, new Insets(0, 20, 20, 280));
        VBox.setMargin(startGame, new Insets(50, 20, -35, 435));
        VBox.setMargin(retour, new Insets(0, 20, 20, 325));

        //Change la couleur du fond d'écran
        root.setStyle("-fx-background-color: grey;");

        //Place le root sur la scene
        setRoot(root);
    }

    private void changeType(String type){
        tamaType = type;
    }

    public String getTamaName(){
        return tamaName.getText();
    }

    public String getTamaType(){
        return tamaType;
    }
}
