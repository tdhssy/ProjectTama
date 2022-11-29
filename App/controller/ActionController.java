package controller;

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
            case "Test":
                System.out.println("bt1");
                break;
            case "Test1":
                System.out.println("bt2");
                break;
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
                control.gameAction(2);
                break;
            case "Laver":
                control.gameAction(3);
                break;            
            case "Jouer":
                control.gameAction(4);
                break;
            case "Besoin":
                control.gameAction(0);
                break;
        }
    }


    //Pour Swing
    /*
     * Méthode appeler à chaque action de l'utilisateur.
     * 
     * --> Veillez à ajouter pour chaque nouveau bouton
     *     les lignes suivantes :
     *          bouton.addActionListener(new ActionController());
     *          bouton.setActionCommand("message");
     *     "message" étant le nom du bouton, pour pouvoir
     *     différencier les différents boutons.
     */
    /*public void actionPerformed(ActionEvent e){

        //Permet l'accès aux méthodes du controller
        Controller control = Controller.getController();

        //Un nouveau case sera ajouté pour chaque 
        //nouveau bouton
        switch (e.getActionCommand()) {
            //TODO : Ajout de 'case' pour chaque bouton
            
            case "Menu charger partie": control.loadEvent("Load");
                break;
            case "Menu nouvelle partie": control.loadEvent("New Game");
                break;
            case "Menu quitter": control.closeEvent();
                break;
            case "Load retour": control.loadEvent("Main");
                break;
        }
    }*/
}
