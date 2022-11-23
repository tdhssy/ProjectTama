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

            testEngine.makeSave();

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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

            //================================================================================

            System.out.println();
            System.out.println();
            System.out.println("Second instance :");

            testEngine = Engine.createEngineInstance(null, "TamaLapin", "testInstance2");
            testTama = testEngine.getTamagotchi();
            instanceName = testEngine.getInstanceName();
            currentRoom = testEngine.getCurrentRoom();

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
