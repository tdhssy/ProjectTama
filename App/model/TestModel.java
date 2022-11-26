package model;

import model.tamaEngine.Tamagotchi;

/*
 * Classe de test du model
 */
public class TestModel {
    
    public static void main(String[] args) {

        Engine testEngine;
        Tamagotchi testTama;
        String instanceName;
        String currentRoom;

        System.out.println();
        System.out.println("MODEL TEST :");
        System.out.println("=======================");

        /*
         * Test d'instance d'Engine
         */
        if(true){

            System.out.println("START INSTANCE TEST :");
            System.out.println();
            System.out.println("First instance :");

            testEngine = Engine.createEngineInstance(null, "TamaRobot", "testInstance1");
            testTama = testEngine.getTamagotchi();
            instanceName = testEngine.getInstanceName();
            currentRoom = testEngine.getCurrentRoom();
            
            System.out.println("Le fichier existe-t-il ? si il existe déjà faut penser à la suppr: "+testEngine.saveExist());//Add par clement
            testEngine.makeSave();
            System.out.println("Le fichier existe-t-il ? : "+testEngine.saveExist());//Add par clement

            System.out.println("Affichage des données du fichier de sauvegarde AVANT SLEEP:");//add par clement
            testEngine.loadSave();//add par clement
            System.out.println("-----------FIN DES DONNEES------------");//add par clement

            System.out.println("----------------------");
            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testTama.toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Instance Name : "+instanceName);
            System.out.println("Current Room : "+currentRoom);
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Thread.sleep(5001);");
            try {
                Thread.sleep(5001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Test update clement file sauvegarde
            System.out.println("Le fichier existe-t-il ? : "+testEngine.saveExist());//Add par clement
            testEngine.makeSave();//add par clement
            System.out.println("Le fichier existe-t-il ? : "+testEngine.saveExist());//Add par clement
            System.out.println("Affichage des données du fichier de sauvegarde APRES SLEEP:");//add par clement
            testEngine.loadSave();//add par clement
            System.out.println("-----------FIN DES DONNEES------------");//add par clement
            //Fin
            


            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testTama.toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            testEngine.unloadEngine();
            testEngine.deleteSave();//add par clement test delete save
            System.out.println("Delete instance");
            System.out.println();
            System.out.println("----------------------");
            System.out.println("=======================");

            //================================================================================

            System.out.println();
            System.out.println();
            System.out.println("Second instance :");

            testEngine = Engine.createEngineInstance(null, "TamaLapin", "testInstance2");
            testTama = testEngine.getTamagotchi();
            instanceName = testEngine.getInstanceName();
            currentRoom = testEngine.getCurrentRoom();

            //création clément
            System.out.println("Le fichier existe-t-il ? si il existe déjà faut penser à la suppr: "+testEngine.saveExist());//Add par clement
            testEngine.makeSave();
            System.out.println("Le fichier existe-t-il ? : "+testEngine.saveExist());//Add par clement

            System.out.println("Affichage des DONNEES du fichier de sauvegarde AVANT SLEEP:");//add par clement
            testEngine.loadSave();//add par clement
            System.out.println("-----------FIN DES DONNEES------------");//add par clement
            //Fin 

            System.out.println("----------------------");
            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testTama.toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Instance Name : "+instanceName);
            System.out.println("Current Room : "+currentRoom);
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Thread.sleep(5000);");
  
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //CLEMENT CREATION ICI
            System.out.println("Le fichier existe-t-il ? : "+testEngine.saveExist());//Add par clement
            testEngine.makeSave();//add par clement
            System.out.println("Le fichier existe-t-il ? : "+testEngine.saveExist());//Add par clement
            System.out.println("Affichage des données du fichier de sauvegarde APRES SLEEP:");//add par clement
            testEngine.loadSave();//add par clement
            System.out.println("-----------FIN DES DONNEES------------");//add par clement
            //CLEMENT CREATION ICI
            
            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testTama.toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            testEngine.unloadEngine();
            testEngine.deleteSave();//add par clement
            System.out.println("Delete instance");
            System.out.println();
            System.out.println("----------------------");
            System.out.println("=======================");
            System.out.println("END INSTANCE TEST");
            System.out.println();
            System.out.println("/////////////////////////////////////////////////////////////////////");
            System.out.println();

        }

        /*
         * Test d'interaction des stats
         */
        if(!true){
            System.out.println("START INTERACTION TEST :");
            System.out.println();
            System.out.println("New instance :");

            testEngine = Engine.createEngineInstance(null, "TamaChat", "testInteraction");
            testTama = testEngine.getTamagotchi();

            System.out.println("----------------------");
            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testTama.toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Set satiety to 4 and mentalHealth to 3");
            testTama.setSatiety(4);
            testTama.setMentalHealth(3);
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testTama.toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Thread.sleep(5000);");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testTama.toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            testEngine.unloadEngine();
            System.out.println("Delete instance");
            System.out.println();
            System.out.println("----------------------");
            System.out.println("=======================");
            System.out.println("END INTERACTION TEST");
            System.out.println();
            System.out.println("/////////////////////////////////////////////////////////////////////");
            System.out.println();

        }
        
    
    }

}
