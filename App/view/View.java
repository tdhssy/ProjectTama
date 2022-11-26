package view;

import view.Menu.*;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Application {

    private static NewGameMenu new_game_v = null;
    private static LoadSaveMenu load_save_v = null;
    private static MainMenu main_menu_v = null;
    private static GameView game_v = null;

    private static BorderPane root; //Juste pour pouvoir appeler la scene
    private static Stage stage;

    private static int largeur;
    private static int hauteur;

    @Override
    public void start(Stage s) throws Exception {   

        root = new BorderPane();

        largeur = 960;
        hauteur = 540;

        main_menu_v = new MainMenu(root, largeur, hauteur);
        
        stage = new Stage();

        stage.setScene(main_menu_v);

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
     *  4 = Parametre
     *  5 = GameView
     */
    public static void changeScene(int menu){
        switch (menu) {
            case 1:
                main_menu_v = new MainMenu(root, largeur, hauteur);
                game_v = null;
                new_game_v = null;
                stage.setScene(main_menu_v);
                break;
            case 2:
                new_game_v = new NewGameMenu(root, largeur, hauteur);
                main_menu_v = null;
                stage.setScene(new_game_v);
                break;
            case 3:
                load_save_v = new LoadSaveMenu(root, largeur, hauteur);
                main_menu_v = null;
                stage.setScene(load_save_v);
                break;
            case 4:
                break;
            case 5:
                game_v = new GameView(root, largeur, hauteur);
                main_menu_v = null;
                new_game_v = null;
                stage.setScene(game_v);
                break;
            default:
                break;
        }
    }

    public static NewGameMenu getNewGameMenu(){
        return new_game_v;
    }

    public static LoadSaveMenu getLoadSaveView(){
        return load_save_v;
    }

    public static GameView getGameView(){
        return game_v;
    }
}
