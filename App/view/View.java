package view;

import view.Menu.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Application {

    private static Scene scene;
    private static NewGameMenu ngView;
    private static MainMenu mmView;
    private static BorderPane root;
    private static Stage stage;

    private static int largeur;
    private static int hauteur;

    @Override
    public void start(Stage s) throws Exception {   
        root = new BorderPane(); //Juste pour pouvoir appeler la scene

        largeur = 960;
        hauteur = 540;

        scene = new MainMenu(root, largeur, hauteur);
        
        stage = new Stage();

        stage.setScene(scene);

        //Rend impossible le redimensionnement manuelle.
        //Pour redimensionner il faut aller dans la fenêtre paramètre
        stage.setResizable(false);

        stage.setTitle("Tamagotchi");
        stage.show();   
    }

    /*
     * Change la scene.
     *  1 = MainMenu
     *  2 = NewGameMenu
     *  3 = LoadSaveMenu
     *  ...
     */
    public static void changeScene(int menu){
        switch (menu) {
            case 1:
                mmView = new MainMenu(root, largeur, hauteur);
                stage.setScene(mmView);
                break;
            case 2:
                ngView = new NewGameMenu(root, largeur, hauteur);
                stage.setScene(ngView);
            default:
                break;
        }
    }

    public static NewGameMenu getNewGameMenu(){
        return ngView;
    }
}
