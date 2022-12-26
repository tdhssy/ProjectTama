package view.Game;

import controller.ActionController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/*
 * Ecran de Game Over
 */
public class Death extends VBox{
    
    Text deathannouncer;

    Button mainMenu;
    Button loadingMenu;

    public Death(double width, double height, String NomTama){
        
        setWidth(width);
        setHeight(height);

        deathannouncer = new Text("Ton animal "+NomTama+" est mort");
        //Font size 1 = 1.3 pixels
        deathannouncer.setFont(new Font(30));

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
    }

}
