package view.Game;

import controller.ActionController;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.View;

public class GameView extends Scene {

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
    Label name;
    String t_type;
    ProgressBar pb_healthBar;
    ProgressBar pb_hungerBar;
    ProgressBar pb_mentalBar;
    ProgressBar pb_needBar;
    ProgressBar pb_sleepBar;
    ProgressBar pb_hygieneBar;
    ProgressBar pb_physicalBar;
    BackgroundImage myBI;
    BorderPane page;
    VBox top;
    HBox topRight;
    HBox topCenter;
    HBox middle;
    HBox middleLeft;
    HBox middleRight;
    VBox bar;
    HBox bottom;
    StackPane root;
    String temps;

    Image img;
    ImageView i; //salon, sdb, cuisine...
    Image weath;
    ImageView weather;

    public GameView(Parent arg0, double arg1, double arg2, String resBG, String time, String w) {
        super(arg0, arg1, arg2);

        int l = View.largeur / 6;
        int h = View.hauteur / 12;


        myBI = new BackgroundImage(new Image(time), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        img = new Image(resBG);
        i = new ImageView();
        i.setImage(img);
        weath = new Image(w);
        weather = new ImageView();
        weather.setImage(weath);



        b_manger = new Button("Manger");
        b_manger.setPrefSize(l, 20);
        b_manger.setOnAction(e -> {
            ActionController.event("Manger");
        });

        b_dormir = new Button("Dormir");
        b_dormir.setPrefSize(l, 20);
        b_dormir.setOnAction(e -> {
            ActionController.event("Dormir");
        });

        b_laver = new Button("Laver");
        b_laver.setPrefSize(l, 20);
        b_laver.setOnAction(e -> {
            ActionController.event("Laver");
        });

        b_jouer = new Button("Jouer");
        b_jouer.setPrefSize(l, 20);
        b_jouer.setOnAction(e -> {
            ActionController.event("Jouer");
        });

        b_besoin = new Button("Besoin");
        b_besoin.setPrefSize(l, 20);
        b_besoin.setOnAction(e -> {
            ActionController.event("Besoin");
        });

        b_quit = new Button("Quitter");
        b_quit.setPrefSize(l / 2, 50);
        b_quit.setOnAction(e -> {
            ActionController.event("QuitGame");
        });

        b_droite = new Button("Aller à droite\n-->");
        b_droite.setPrefSize(l, h);
        b_droite.setOnAction(e -> {
            ActionController.event("RightRoom");
        });

        b_gauche = new Button("Aller à gauche\n<--");
        b_gauche.setPrefSize(l, h);
        b_gauche.setOnAction(e -> {
            ActionController.event("LeftRoom");
        });

        /*this.setOnKeyPressed(e -> {
            ActionController.keyEventInGame(e);
        }); // Pour les raccourci clavier*/



        /* top part */
        room = new Text();

        top = new VBox();

        topRight = new HBox();
        topRight.getChildren().add(b_quit);
        topRight.setAlignment(Pos.CENTER_RIGHT);
        topRight.setMargin(b_quit, new Insets(15, 10, 15, 10));

        topCenter = new HBox();

        name = new Label();
        name.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h / 2));
        //name.setStyle("-fx-background-color: #cacaca");
        topCenter.getChildren().add(name);
        topCenter.setAlignment(Pos.CENTER);

        top.getChildren().add(topRight);
        top.getChildren().add(topCenter);
        top.setAlignment(Pos.CENTER);
        /* end top part */

        /* middle part */

        // Affichage tamagotchi
        tamagotchi = new ImageView();
        tamagotchi.setFitHeight(l);
        tamagotchi.setFitHeight(l);
        tamagotchi.setPreserveRatio(true);

        // Barre de progression (vie, sommeil, etc.)
        int n = l;
        int s = 30;

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
        
        bar = new VBox(); // Vertical box des stats
        //bar.setStyle("-fx-background-color:  #ebedef");
        bar.setAlignment(Pos.CENTER);


        Label life = new Label("Barre de vie");
        life.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/4));
        life.setStyle("-fx-background-color: #cacaca");

        Label hungry = new Label("Barre de faim");
        hungry.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/4));
        hungry.setStyle("-fx-background-color: #cacaca");

        Label mental = new Label("Barre de mental");
        mental.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/4));
        mental.setStyle("-fx-background-color: #cacaca");

        Label sleep = new Label("Barre de sommeil");
        sleep.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/4));
        sleep.setStyle("-fx-background-color: #cacaca");

        Label need = new Label("Barre de besoin");
        need.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/4));
        need.setStyle("-fx-background-color: #cacaca");

        Label physique = new Label("Barre d'état physique");
        physique.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/4));
        physique.setStyle("-fx-background-color: #cacaca");

        Label propre = new Label("Barre d'hygiène");
        propre.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, h/4));
        propre.setStyle("-fx-background-color: #cacaca");


        bar.getChildren().add(life);
        bar.getChildren().add(pb_healthBar);
        bar.getChildren().add(hungry);
        bar.getChildren().add(pb_hungerBar);
        bar.getChildren().add(mental);
        bar.getChildren().add(pb_mentalBar);
        bar.getChildren().add(sleep);
        bar.getChildren().add(pb_sleepBar);
        bar.getChildren().add(need);
        bar.getChildren().add(pb_needBar);
        bar.getChildren().add(physique);
        bar.getChildren().add(pb_physicalBar);
        bar.getChildren().add(propre);
        bar.getChildren().add(pb_hygieneBar);

        HBox middle = new HBox();
        HBox middleLeft = new HBox();
        middleLeft.getChildren().add(bar);
        middleLeft.setAlignment(Pos.CENTER_LEFT);
        middleLeft.setPadding(new Insets(20,60,60,30));
        HBox middleRight = new HBox();
        middleRight.getChildren().add(b_gauche);
        middleRight.getChildren().add(tamagotchi);
        middleRight.getChildren().add(b_droite);
        middleRight.setAlignment(Pos.BOTTOM_RIGHT);
        middleRight.setPadding(new Insets(0, 40, 30, 30 ));

        middle.getChildren().add(middleLeft);
        middle.getChildren().add(middleRight);
        middle.setAlignment(Pos.CENTER);
        //HBox.setMargin(middle, new Insets(500));
        middle.setSpacing(50);
        //middle.setStyle("-fx-background-color: white;");

        //HBox.setMargin(b_gauche, new Insets(h / 6, l, h / 6, l / 6));
        //HBox.setMargin(b_droite, new Insets(h / 6, l / 6, h / 6, l));
        /* end middle part */

        /* bottom part */
        HBox bottom = new HBox();

        bottom.getChildren().add(b_manger);
        bottom.getChildren().add(b_jouer);
        bottom.getChildren().add(b_laver);
        bottom.getChildren().add(b_dormir);
        bottom.getChildren().add(b_besoin);

        bottom.setAlignment(Pos.CENTER);
        // bottom.setStyle("-fx-background-color: black;");

        HBox.setMargin(b_manger, new Insets(h / 6, 15, h / 6, 20));
        HBox.setMargin(b_jouer, new Insets(h / 6, 15, h / 6, 20));
        HBox.setMargin(b_laver, new Insets(h / 6, 15, h / 6, 20));
        HBox.setMargin(b_besoin, new Insets(h / 6, 15, h / 6, 20));

        /* end bottom part */

        top.setPrefSize(l, h*0.3);
        middle.setPrefSize(l, h);
        bottom.setPrefSize(l, h*0.2);

        page = new BorderPane();
        /*page.getChildren().add(top);
        page.getChildren().add(middle);
        page.getChildren().add(bottom); */
        //page.setPrefSize(l, h);

        page.setTop(top);
        page.setCenter(middle);
        page.setBottom(bottom);





        root = new StackPane();
        
        //page.setPrefSize(root.getWidth(), root.getHeight());

        root.getChildren().add(weather);
        root.getChildren().add(i);
        root.getChildren().add(page);
        //root.getChildren().add(top);
        //root.getChildren().add(middle);
        //root.getChildren().add(bottom);
  
        setRoot(root);
        setRoom(resBG);
        setWeather(w);

        i.setFitWidth(root.getWidth());
        i.setFitHeight(root.getHeight());

        root.setBackground(new Background(myBI));
    }

    public void setTime(String str) {
        myBI = new BackgroundImage(new Image(str), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        root.setBackground(new Background(myBI));
    }

    public void setWeather(String w) {
        weather = new ImageView();
        weather.setImage(new Image(w));
        weather.setFitWidth(root.getWidth());
        weather.setFitHeight(root.getHeight());
        root.getChildren().set(0, weather);
    }

    public void setRoom(String s) {
        b_gauche.setVisible(!s.equals("/bath.png")); // disparition bouton gauche dans la salle de bain
        b_droite.setVisible(!s.equals("/garden.png")); // disparition bouton droite dans le jardin
        // System.out.println(s.equals("/salon.png"));

        b_manger.setDisable(!s.equals("/kitchen.png"));
        b_dormir.setDisable(!s.equals("/salon.png"));
        b_laver.setDisable(!s.equals("/bath.png"));
        b_jouer.setDisable(!s.equals("/garden.png") & !s.equals("salon"));
        b_besoin.setDisable(!s.equals("/bath.png"));

        room.setText(s);
        i = new ImageView();
        i.setImage(new Image(s));
        i.setFitWidth(root.getWidth());
        i.setFitHeight(root.getHeight());
        root.getChildren().set(1, i);
        System.out.println(root.getChildren().size());

    }

    public void setHunger(double x) {
        pb_hungerBar.setProgress(x);
    }

    public void setHealth(double x) {
        pb_healthBar.setProgress(x);
    }

    public void setMental(double x) {
        pb_mentalBar.setProgress(x);
    }

    public void setNeed(double x) {
        pb_needBar.setProgress(x);
    }

    public void setSleep(double x) {
        pb_sleepBar.setProgress(x);
    }

    public void setPhysical(double x) {
        pb_physicalBar.setProgress(x);
    }

    public void setHygiene(double x) {
        pb_hygieneBar.setProgress(x);
    }

    public void setName(String s) {
        t_name = s;
        name.setText(s);
    }

    public void setAnimation(String s) {
        tamagotchi.setImage(new Image(t_type + "/" + s));
    }

    public void setType(String s) {
        t_type = s;
        setAnimation("Stay.gif");
    }

    public void displayDeath() {
        Platform.runLater(() -> {
            setRoot(new Death(this.getWidth(), this.getHeight() * 0.60, t_name));
        });
    }
}
