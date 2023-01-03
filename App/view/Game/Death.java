package view.Game;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/*
 * Ecran de Game Over
 */
public class Death extends VBox{
    
    Label deathannouncer;

    Button mainMenu;
    Button loadingMenu;
    BackgroundImage backgroundimg;
    Label tex;

    public Death(double width, double height, String NomTama){
        
        setWidth(width);
        setHeight(height);

        Label tex = new Label("Ton animal "+ NomTama +" est mort");
        tex.setTextFill(Color.WHITE);

        deathannouncer = tex;
        //Font size 1 = 1.3 pixels 
        deathannouncer.setFont(new Font(25));

        mainMenu = new Button("Menu principal");
        mainMenu.setOnAction(e -> {ActionController.event("Go_main_menu");});
        mainMenu.setPrefHeight(this.getHeight()*0.20);
        mainMenu.setPrefWidth(this.getWidth()*0.50);
        
        loadingMenu = new Button("Charger une partie");
        loadingMenu.setOnAction(e -> {ActionController.event("Go_load_game");});
        loadingMenu.setPrefHeight(this.getHeight()*0.20);
        loadingMenu.setPrefWidth(this.getWidth()*0.50);

        VBox.setMargin(deathannouncer, new Insets(this.getHeight()*0.2, this.getWidth()*0.5-240, 0, this.getWidth()*0.5-240));
        VBox.setMargin(mainMenu,       new Insets(0, this.getWidth()*0.25, 0, this.getWidth()*0.25));
        VBox.setMargin(loadingMenu,    new Insets(0, this.getWidth()*0.25, 0, this.getWidth()*0.25));


        this.getChildren().addAll(deathannouncer, mainMenu, loadingMenu);

        //Charge l'image du fond d'écran
        backgroundimg= new BackgroundImage(new Image("dead.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundimg));
    }

}
