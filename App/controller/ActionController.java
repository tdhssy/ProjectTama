package controller;

import java.awt.event.*;


/*
 * Classe permettant d'écouter les actions effectuer par
 * l'utilisateur et d'agir en fonction.
 */
public class ActionController implements ActionListener {
    
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
    public void actionPerformed(ActionEvent e){

        //Permet l'accès aux méthodes du controller
        Controller control = Controller.getController();

        //Un nouveau case sera ajouté pour chaque 
        //nouveau bouton
        switch (e.getActionCommand()) {
        
            default:
                break;
        }
    }

}
