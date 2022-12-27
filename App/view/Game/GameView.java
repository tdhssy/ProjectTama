package view.Game;

import controller.ActionController;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.View;

public class GameView extends Scene
{

    Button b_manger;
    Button b_dormir;
    Button b_laver;
    Button b_jouer;
    Button b_besoin;
    Button b_quit;
    Button b_droite;
    Button b_gauche;
    Text room;
    ImageView tamagotchi;
    String t_name;
    Text name;
    String t_type;
    ProgressBar pb_healthBar;
    ProgressBar pb_hungerBar;
    ProgressBar pb_mentalBar;
    ProgressBar pb_needBar;
    ProgressBar pb_sleepBar;
    ProgressBar pb_hygieneBar;
    ProgressBar pb_physicalBar;
    BackgroundImage myBI;
    VBox top;
    VBox bar;
    VBox bottom;
    BorderPane root;

    public GameView(Parent arg0, double arg1, double arg2,String resBG) {
        super(arg0, arg1, arg2);

        int l = View.largeur/6;
        int h = View.hauteur/12;

        myBI= new BackgroundImage(new Image(resBG), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        
        b_manger = new Button("Manger");
        b_manger.setPrefSize(l, h);
        b_manger.setOnAction(e -> {ActionController.event("Manger");});

        b_dormir = new Button("Dormir");
        b_dormir.setPrefSize(l, h);
        b_dormir.setOnAction(e -> {ActionController.event("Dormir");});

        b_laver = new Button("Laver");
        b_laver.setPrefSize(l, h);
        b_laver.setOnAction(e -> {ActionController.event("Laver");});

        b_jouer = new Button("Jouer");
        b_jouer.setPrefSize(l, h);
        b_jouer.setOnAction(e -> {ActionController.event("Jouer");});

        b_besoin = new Button("Besoin");
        b_besoin.setPrefSize(l, h);
        b_besoin.setOnAction(e -> {ActionController.event("Besoin");});

        b_quit = new Button("Quitter");
        b_quit.setPrefSize(l, h);
        b_quit.setOnAction(e -> {ActionController.event("QuitGame");});

        b_droite = new Button("Aller à droite\n-->");
        b_droite.setPrefSize(l, h);
        b_droite.setOnAction(e -> {ActionController.event("RightRoom");});

        b_gauche = new Button("Aller à gauche\n<--");
        b_gauche.setPrefSize(l, h);
        b_gauche.setOnAction(e -> {ActionController.event("LeftRoom");});

        this.setOnKeyPressed(e -> {ActionController.keyEventInGame(e);}); //Pour les raccourci claviver

        bottom = new VBox();

        VBox action = new VBox();
        
        HBox action1 = new HBox();
        action1.getChildren().add(b_manger);
        action1.getChildren().add(b_jouer);
        action1.getChildren().add(b_laver);
        action1.setAlignment(Pos.CENTER);

        HBox.setMargin(b_manger, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(b_jouer, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(b_laver, new Insets(h/6, l/6, h/6, l/6));

        HBox action2 = new HBox();

        action2.getChildren().add(b_gauche);
        action2.getChildren().add(b_dormir);
        action2.getChildren().add(b_besoin);
        action2.getChildren().add(b_droite);
        action2.setAlignment(Pos.CENTER);

        HBox.setMargin(b_dormir, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(b_besoin, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(b_gauche, new Insets(h/6, l, h/6, l/6));
        HBox.setMargin(b_droite, new Insets(h/6, l/6, h/6, l));

        action.getChildren().add(action1);
        action.getChildren().add(action2);

        action.setAlignment(Pos.CENTER);
        action.setStyle("-fx-background-color: white;");


        tamagotchi = new ImageView();
        tamagotchi.setFitHeight(l);
        tamagotchi.setFitHeight(l);
        tamagotchi.setPreserveRatio(true);
        
        bottom.getChildren().add(tamagotchi);
        bottom.getChildren().add(action);
        bottom.setAlignment(Pos.CENTER);

        room = new Text();

        int n = l;
        int s = h*200;

        pb_healthBar = new ProgressBar(1);
        pb_healthBar.setPrefWidth(n);
        pb_healthBar.setPrefHeight(s);
        pb_healthBar.setStyle("-fx-accent: red;");

        pb_hungerBar = new ProgressBar(0.5);
        pb_hungerBar.setPrefWidth(n);
        pb_hungerBar.setPrefHeight(s);
        pb_hungerBar.setStyle("-fx-accent: green;");

        pb_mentalBar = new ProgressBar(0.5);
        pb_mentalBar.setPrefWidth(n);
        pb_mentalBar.setPrefHeight(s);
        pb_mentalBar.setStyle("-fx-accent: blue;");

        pb_needBar = new ProgressBar(0.5);
        pb_needBar.setPrefWidth(n);
        pb_needBar.setPrefHeight(s);
        pb_needBar.setStyle("-fx-accent: brown;");

        pb_sleepBar = new ProgressBar(0.5);
        pb_sleepBar.setPrefWidth(n);
        pb_sleepBar.setPrefHeight(s);
        pb_sleepBar.setStyle("-fx-accent: violet;");

        pb_hygieneBar = new ProgressBar(0.5);
        pb_hygieneBar.setPrefWidth(n);
        pb_hygieneBar.setPrefHeight(s);
        pb_hygieneBar.setStyle("-fx-accent: pink;");

        pb_physicalBar = new ProgressBar(0.5);
        pb_physicalBar.setPrefWidth(n);
        pb_physicalBar.setPrefHeight(s);
        pb_physicalBar.setStyle("-fx-accent: orange;");

        bar = new VBox();
        
        bar.getChildren().add(new Text("Barre de vie"));
        bar.getChildren().add(pb_healthBar);
        bar.getChildren().add(new Text("Barre de faim"));
        bar.getChildren().add(pb_hungerBar);
        bar.getChildren().add(new Text("Barre de mental"));
        bar.getChildren().add(pb_mentalBar);
        bar.getChildren().add(new Text("Barre de someil"));
        bar.getChildren().add(pb_sleepBar);
        bar.getChildren().add(new Text("Barre de besoin"));
        bar.getChildren().add(pb_needBar);
        bar.getChildren().add(new Text("Barre d'état physique"));
        bar.getChildren().add(pb_physicalBar);
        bar.getChildren().add(new Text("Barre d'hygiene"));
        bar.getChildren().add(pb_hygieneBar);

        top = new VBox();
        
        name = new Text();
        name.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/3));

        top.getChildren().add(b_quit);
        top.getChildren().add(name);

        top.setAlignment(Pos.CENTER);

        root = new BorderPane();
        
        root.setTop(top);
        root.setLeft(bar);
        root.setBottom(bottom);
        root.setBackground(new Background(myBI));

        setRoot(root);
    }

    public void setRoom(String s) {
        room.setText(s);
        myBI= new BackgroundImage(new Image(s), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        root.setBackground(new Background(myBI));
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
        t_name = s;
        name.setText(s);
    }

    public void setAnimation(String s){
        tamagotchi.setImage(new Image(t_type + "/" + s));
    }

    public void setType(String s){
        t_type = s;
        setAnimation("Stay.gif");
    }

    public void displayDeath(){
        Platform.runLater(() -> {
            setRoot(new Death(this.getWidth(), this.getHeight()*0.60,t_name));
        });
    }
}
