package model;

import model.saveEngine.Save;

/*
 * Classe de test du model
 */
public class TestModel {
    
    public static void main(String[] args) {

        Engine testEngine;

        String instanceName;
        String currentRoom;

        System.out.println();
        System.out.println("MODEL TEST :");
        System.out.println("=======================");

        /*
         * Test d'instance d'Engine
         */
        if(true){ //create new Engine

            System.out.println("START INSTANCE TEST :");
            System.out.println();
            System.out.println("First instance :");

            testEngine = Engine.createEngineInstance(null, "TamaRobot", "testInstance1");
            instanceName = testEngine.getInstanceName();
            currentRoom = testEngine.getCurrentRoom();

            testEngine.getAllSaveName(); //add par clément
            
            System.out.println("Le fichier existe-t-il ? si il existe déjà faut penser à la suppr: "+Save.saveExist(instanceName));//Add par clement
            testEngine.makeSave();
            System.out.println("Le fichier existe-t-il ? : "+Save.saveExist(instanceName));//Add par clement

            System.out.println("Affichage des données du fichier de sauvegarde AVANT SLEEP:");//add par clement
            Engine.loadSave(null, instanceName);//add par clement
            System.out.println("-----------FIN DES DONNEES------------");//add par clement

            System.out.println("----------------------");
            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testEngine.getTamagotchi().toString());
            System.out.println();
            System.out.println("ArrayPourcent : "+testEngine.getDatasPourcent().toString());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("Instance Name : "+instanceName);
            System.out.println("Current Room : "+testEngine.getCurrentRoom());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            
            
            System.out.println("Thread.sleep(5001);");

            try {
                Thread.sleep(5001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println("Tamagotchi info :");
            System.out.println(testEngine.getTamagotchi().toString());
            System.out.println();
            System.out.println("Current Room : "+testEngine.getCurrentRoom());
            System.out.println();
            System.out.println("prev Room : "+testEngine.previousRoom());
            System.out.println();
            System.out.println("prev Room : "+testEngine.previousRoom());
            System.out.println();
            System.out.println("Next Room : "+testEngine.nextRoom());
            System.out.println();
            System.out.println("Next Room : "+testEngine.nextRoom());
            System.out.println();
            System.out.println("Next Room : "+testEngine.nextRoom());
            System.out.println();
            System.out.println("Next Room : "+testEngine.nextRoom());
            System.out.println();
            System.out.println("Current Room : "+testEngine.getCurrentRoom());
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
            System.out.println("make save : "+instanceName);
            System.out.println("safety quit ? : "+testEngine.quit());
            



            //add par clement test delete save
            //System.out.println("Le fichier est suprimer ? :" + Save.deleteSave(instanceName));


            System.out.println();
            System.out.println("----------------------");
            System.out.println("=======================");

            //================================================================================
            if(!true){ //load

                System.out.println("----------------------");
                System.out.println("load save : "+instanceName);
                testEngine = Engine.loadSave(null, instanceName);

                System.out.println("----------------------");
                System.out.println();
                System.out.println("Tamagotchi info :");
                System.out.println(testEngine.getTamagotchi().toString());
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
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                System.out.println();
                System.out.println("Tamagotchi info :");
                System.out.println(testEngine.getTamagotchi().toString());
                System.out.println();
                System.out.println("----------------------");
                System.out.println();
                System.out.println("safety quit ? : "+testEngine.quit());

                //add par clement test delete save
                //System.out.println("Le fichier est suprimer ? : " + Engine.deleteSave(instanceName));
                //System.out.println("Le fichier est suprimer ? : " + Engine.deleteSave(instanceName));

                System.out.println();
                System.out.println("----------------------");
                System.out.println("=======================");

            }
        }

        
        
    
    }

}
