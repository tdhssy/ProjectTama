package view.Menu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import controller.ActionController;

public class LoadSaveMenu extends Scene{

    VBox root;
    Button b_charger;
    Button b_retour;
    Button b_suppr;
    ListView<String> listSaves;
    GridPane rootGrid;

    public LoadSaveMenu(Parent arg0, double arg1, double arg2) {
        super(arg0, arg1, arg2);
        //TODO Auto-generated constructor stub




        root = new VBox();
        listSaves = new ListView<>();
  
        b_retour = new Button("Retour au menu");
        b_retour.setPrefSize(300, 35);
        b_retour.setOnAction(e -> ActionController.event("Go_main_menu"));

        b_charger = new Button("Charger la partie");
        b_charger.setPrefSize(300, 35);
        b_charger.setOnAction(e -> ActionController.event("loadSave"));

        b_suppr = new Button("Supprimer la partie");
        b_suppr.setPrefSize(300,35);
        b_suppr.setOnAction(e -> ActionController.event("Supp_save"));

        root.getChildren().add(listSaves);
        root.getChildren().add(b_charger);
        root.getChildren().add(b_retour);
        root.getChildren().add(b_suppr);

        

        //Place le root sur la scene
        setRoot(root);
    }


    public void addListSave(String save){
        listSaves.getItems().add(save);
    }

    public String getSelectedSave(){
        return listSaves.getSelectionModel().getSelectedItem();
    }

    
}
