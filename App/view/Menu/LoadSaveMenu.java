package view.Menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.View;
import controller.ActionController;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

public class LoadSaveMenu extends Scene{

    VBox root;
    Button b_charger;
    Button b_retour;
    Button b_suppr;
    BackgroundImage backgroundimg;
    ListView<String> listSaves;
    GridPane rootGrid;

    public LoadSaveMenu(Parent arg0, double arg1, double arg2) {
        super(arg0, arg1, arg2);

        int l = View.largeur/6;
        int h = View.hauteur/9;

        root = new VBox();
        listSaves = new ListView<>();
    
        HBox action = new HBox();
        
        b_retour = new Button("Retour au menu");
        b_retour.setPrefSize(l, h);
        b_retour.setOnAction(e -> {ActionController.event("Go_main_menu");});

        b_charger = new Button("Charger la partie");
        b_charger.setPrefSize(l, h);
        b_charger.setOnAction(e -> {ActionController.event("loadSave");});

        b_suppr = new Button("Supprimer la partie");
        b_suppr.setPrefSize(l, h);
        b_suppr.setOnAction(e -> {ActionController.event("Supp_save");});

        action.getChildren().add(b_charger);
        action.getChildren().add(b_retour);
        action.getChildren().add(b_suppr);
        action.setAlignment(Pos.CENTER);

        HBox.setMargin(b_retour, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(b_charger, new Insets(h/6, l/6, h/6, l/6));
        HBox.setMargin(b_suppr, new Insets(h/6, l/6, h/6, l/6));

        root.getChildren().add(listSaves);
        root.getChildren().add(action);
        root.setAlignment(Pos.CENTER);

        //root.setStyle("-fx-background-color: Grey;");

        //Place le root sur la scene
        setRoot(root);

        //Charge l'image du fond d'écran
        backgroundimg = new BackgroundImage(new Image("menuimg.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        root.setBackground(new Background(backgroundimg));
    }

    

    public void addListSave(String save){
        listSaves.getItems().add(save);
    }

    public String getSelectedSave(){
        return listSaves.getSelectionModel().getSelectedItem();
    }

    
}
