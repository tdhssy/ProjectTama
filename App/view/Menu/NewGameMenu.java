package view.Menu;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.View;
import view.Game.GameView;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

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
    BorderPane main;
    VBox root;
    BackgroundImage backgroundimg;

    String tamaType = "TamaChien";
     
    public NewGameMenu(Parent arg0, double arg1, double arg2)
    {
        super(arg0, arg1, arg2);

        int l = View.largeur/6;
        int h = View.hauteur/6;

        root = new VBox();

        startGame = new Button("Commencer la partie");
        startGame.setOnAction(e -> {
        ActionController.event("StartGame");
        });
        startGame.setPrefSize(l, h/2);

        retour = new Button("Retour");
        retour.setOnAction(e -> {
        ActionController.event("Go_main_menu");
        });
        retour.setPrefSize(l, h/2);

        tamaChien = new Button("Chien");//A modifier par une image
        tamaChien.setOnAction(e -> changeType("TamaChien"));
        tamaChien.setPrefSize(l, h);
        tamaChien.setGraphic(new ImageView("TamaChien/Stay.gif"));

        tamaChat = new Button("Chat");//A modifier par une image
        tamaChat.setOnAction(e -> changeType("TamaChat"));
        tamaChat.setPrefSize(l, h);
        tamaChat.setGraphic(new ImageView("TamaChat/Stay.gif"));

        tamaLapin = new Button("Lapin");//A modifier par une image
        tamaLapin.setOnAction(e -> changeType("TamaLapin"));
        tamaLapin.setPrefSize(l, h);
        tamaLapin.setGraphic(new ImageView("TamaLapin/Stay.gif"));

        tamaRobot = new Button("Robot");//A modifier par une image
        tamaRobot.setOnAction(e -> changeType("TamaRobot"));
        tamaRobot.setPrefSize(l, h);
        tamaRobot.setGraphic(new ImageView("TamaRobot/Stay.gif"));

        this.setOnKeyPressed(e -> {
        ActionController.keyEventNewGameMenu(e);
        }); //Pour les raccourci claviver

        tamaName = new TextField("");
        tamaName.setMaxWidth(l);
        tamaName.setMaxHeight(h);

        name = new Text("Nom de votre compagnon :");
        Font font = Font.font("Verdana", FontWeight.BOLD, l/10);
        name.setFont(font);

        //Ajout des boutons au root
        //L'ordre est important
        HBox choice = new HBox();
        choice.getChildren().add(tamaChien);
        choice.getChildren().add(tamaChat);
        choice.getChildren().add(tamaLapin);
        choice.getChildren().add(tamaRobot);
        
        choice.setAlignment(Pos.CENTER);
        root.getChildren().add(choice);

        HBox enter = new HBox();
        enter.getChildren().add(name);
        enter.getChildren().add(tamaName);

        enter.setAlignment(Pos.CENTER);
        root.getChildren().add(enter);

        HBox start = new HBox();
        start.getChildren().add(startGame);
        start.getChildren().add(retour);

        start.setAlignment(Pos.CENTER);
        root.getChildren().add(start);
        
        root.setAlignment(Pos.CENTER);

        //Réglage de l'emplacement des boutons

        HBox.setMargin(tamaChien, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(tamaChat, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(tamaLapin, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(tamaRobot, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(tamaName, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(name, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(startGame, new Insets(h/6, l/6, h/6, l/6));
        VBox.setMargin(retour, new Insets(h/6, l/6, h/6, l/6));

        main = new BorderPane();

        main.setCenter(root);

        //Charge l'image du fond d'écran
        backgroundimg = new BackgroundImage(new Image("menuimg.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        root.setBackground(new Background(backgroundimg));

        //Place le root sur la scene
        setRoot(main);
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
