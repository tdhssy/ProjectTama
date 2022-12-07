package controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

//import java.awt.event.*;

/*
 * Classe permettant d'écouter les actions effectuer par
 * l'utilisateur et d'agir en fonction.
 */
public class ActionController /*extends ActionListener */
{ 

    //Pour JavaFx
    /*
     * Méthode appeler à chaque action de l'utilisateur.
     * 
     * --> Veillez à ajouter pour chaque nouveau bouton
     *     les lignes suivantes :
     *          button.setOnAction(e -> ActionController.event("message"));
     *     "message" étant le nom du bouton, pour pouvoir
     *     différencier les différents boutons.
     */
    public static void event(String buttonName){
        Controller control = Controller.getController();
        switch(buttonName){
            case "Go_new_game": 
                control.menuAction(1);
                break;
            case "Go_load_game": 
                control.menuAction(2);
                break;
            case "Go_main_menu":
                control.menuAction(7);
                break;
            case "Go_parametre":
                control.menuAction(3);
                break;
            case "quitter":
                control.menuAction(5);
                break;
            case "StartGame":
                control.menuAction(6);
                break;
            case "Manger":
                control.gameAction(1);
                break;
            case "Dormir":
                control.gameAction(3);
                break;
            case "Laver":
                control.gameAction(4);
                break;            
            case "Jouer":
                control.gameAction(2);
                break;
            case "Besoin":
                control.gameAction(0);
                break;
            case "loadSave":
                control.menuAction(8);
                break;
            case "QuitGame":
                control.menuAction(9);
                break;
            case "RightRoom":
                control.gameAction(5);
                control.update_room();
                break;
            case "LeftRoom":
                control.gameAction(6);
                control.update_room();
                break;
        }
    }

    /*
     * Gère les raccourci clavier dans une partie
     */
    public static void keyEventInGame(KeyEvent ke){

        if(ke.getCode() == KeyCode.M){
            event("Manger");
        }else if(ke.getCode() == KeyCode.D){
            event("Dormir");
        }else if(ke.getCode() == KeyCode.L){
            event("Laver");
        }else if(ke.getCode() == KeyCode.J){
            event("Jouer");
        }else if(ke.getCode() == KeyCode.B){
            event("Besoin");
        }
    }

    public static void keyEventNewGameMenu(KeyEvent ke){
        if(ke.getCode() == KeyCode.ENTER){
            event("StartGame");
        }
    }
}
