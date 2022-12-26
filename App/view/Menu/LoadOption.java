package view.Menu;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import view.View;
import controller.ActionController;

public class LoadOption extends Scene {
    
    MenuBar set;
    Menu menu;
    Button retour;
    Rectangle2D screenInfo;
    VBox root;

    public LoadOption(Parent arg0, double arg1, double arg2) {
        
        super(arg0, arg1, arg2);

        root = new VBox();

        screenInfo = Screen.getPrimary().getVisualBounds();

        menu = new Menu("Resolution");
        set = new MenuBar();

        double width = screenInfo.getWidth();
        double height = screenInfo.getHeight();

        MenuItem resolution1 = new MenuItem((int)(width*0.9)+ "x" + (int)(height*0.9));
        resolution1.setOnAction(e -> {
            View.largeur = (int)(width*0.9);
            View.hauteur = (int)(height*0.9);
            ActionController.event("Go_parametre");   
        });
        menu.getItems().add(resolution1);
        MenuItem resolution2 = new MenuItem((int)(width*0.8) + "x" + (int)(height*0.8));
        resolution2.setOnAction(e -> {
            View.largeur = (int)(width*0.8);
            View.hauteur = (int)(height*0.8);
            ActionController.event("Go_parametre");
        });
        menu.getItems().add(resolution2);
        MenuItem resolution3 = new MenuItem((int)(width*0.7) + "x" + (int)(height*0.7));
        resolution3.setOnAction(e -> {
            View.largeur = (int)(width*0.7);
            View.hauteur = (int)(height*0.7);
            ActionController.event("Go_parametre");
        });
        menu.getItems().add(resolution3);
        MenuItem resolution4 = new MenuItem((int)(width*0.6) + "x" + (int)(height*0.6));
        resolution4.setOnAction(e -> {
            View.largeur = (int)(width*0.6);
            View.hauteur = (int)(height*0.6);
            ActionController.event("Go_parametre");
        });
        menu.getItems().add(resolution4);
        
        set.getMenus().add(menu);

        retour = new Button("Retour");
        retour.setOnAction(e -> {
        ActionController.event("Go_main_menu");
        });
        retour.setPrefSize(width*0.08, height*0.04);
        
        root.getChildren().add(set);
        root.getChildren().add(retour);

        VBox.setMargin(set, new Insets(150,425,0,420));
        VBox.setMargin(retour, new Insets(100,0,0,430));

        //Change la couleur du fond d'écran
        root.setStyle("-fx-background-color: grey;");

        //Place le root sur la scene
        setRoot(root);
    }

    public static int getScreenWidth(){
        Rectangle2D screenInfo = Screen.getPrimary().getVisualBounds();
        return (int)(screenInfo.getWidth());
    }

    public static int getScreenHeight(){
        Rectangle2D screenInfo = Screen.getPrimary().getVisualBounds();
        return (int)(screenInfo.getHeight());
    }
}
