package model;



import java.util.ArrayList;
import java.util.Arrays;

import model.tamaEngine.TamaChat;
import model.tamaEngine.TamaChien;
import model.tamaEngine.TamaRobot;
import model.tamaEngine.Tamagotchi;
import model.tamagotchiFactory.TamagotchiFactory;
/*
 * Classe de test du model
 */
public class TestModel {
    
    public static void main(String[] args) {
        
        System.out.println("Test Model");
        System.out.println("==============");

        /*
         * Test des classes Tamagotchi
         */
        if(!true){
            System.out.println("Test Tamagotchi class : ");
            System.out.println("------------");
            System.out.println();

            Tamagotchi chat =  new TamaChat();
            System.out.println("TamaChat : ");
            System.out.println("------------");

            System.out.println("Initial status :");
            System.out.println(chat.toString());
            System.out.println("------------");

            int newStatus = 20;
            System.out.println("Set value to "+newStatus+" :");

            chat.setHealth(newStatus);
            chat.setMentalHealth(newStatus);
            chat.setPhysicalCondition(newStatus);
            chat.setNeeds(newStatus);
            chat.setSatiety(newStatus);
            chat.setSleep(newStatus);

            System.out.println("Modified status :");
            System.out.println(chat.toString());
            System.out.println("------------");
            System.out.println();

            //=========================================================

            Tamagotchi chien =  new TamaChien();
            System.out.println("Tamachien : ");
            System.out.println("------------");

            System.out.println("Initial status :");
            System.out.println(chien.toString());
            System.out.println("------------");

            int newStatus2 = 25;
            System.out.println("Set value to "+newStatus2+" :");
            
            chien.setHealth(newStatus2);
            chien.setMentalHealth(newStatus2);
            chien.setPhysicalCondition(newStatus2);
            chien.setNeeds(newStatus2);
            chien.setSatiety(newStatus2);
            chien.setSleep(newStatus2);

            System.out.println("Modified status :");
            System.out.println(chien.toString());
            System.out.println("------------");
            System.out.println();

            //=========================================================

            Tamagotchi robot =  new TamaRobot();
            System.out.println("Tamarobot : ");
            System.out.println("------------");

            System.out.println("Initial status :");
            System.out.println(robot.toString());
            System.out.println("------------");

            int newStatus3 = 30;
            System.out.println("Set value to "+newStatus3+" :");

            robot.setHealth(newStatus3);
            robot.setMentalHealth(newStatus3);
            robot.setPhysicalCondition(newStatus3);
            robot.setNeeds(newStatus3);
            robot.setSatiety(newStatus3);
            robot.setSleep(newStatus3);

            System.out.println("Modified status :");
            System.out.println(robot.toString());
            System.out.println("------------");
            System.out.println();
            System.out.println();
            System.out.println();
        }
        

        /*
         * Test de la classe TamagotchiFactory
         */
        if(true){

            System.out.println("Test TamagotchiFactory class : ");
            System.out.println("------------");
            System.out.println();

            System.out.print("TamagotchiFactory.createTamagotchi(\"TamaChat\") = ");
            System.out.println(TamagotchiFactory.createTamagotchi("TamaChat").getClass().getSimpleName());
        
            System.out.print("TamagotchiFactory.createTamagotchi(\"TamaChien\") = ");
            System.out.println(TamagotchiFactory.createTamagotchi("TamaChien").getClass().getSimpleName());

            System.out.println("TamagotchiFactory.UnloadTamagotchi()");
            TamagotchiFactory.UnloadTamagotchi();

            System.out.print("TamagotchiFactory.createTamagotchi(\"TamaRobot\") = ");
            System.out.println(TamagotchiFactory.createTamagotchi("TamaRobot").getClass().getSimpleName());
            System.out.println();

            System.out.println("TamagotchiFactory.UnloadTamagotchi()");
            TamagotchiFactory.UnloadTamagotchi();
            System.out.println();

            System.out.println("Tamagotchi testTama = TamagotchiFactory.createTamagotchi(\"TamaRobot\");");
            Tamagotchi testTama = TamagotchiFactory.createTamagotchi("TamaRobot");
            System.out.println();

            System.out.print("testTama.toString() = ");
            System.out.println(testTama.toString());

            System.out.print("testTama.getAllData().toString() = ");
            System.out.println(testTama.getAllData().toString());
            System.out.println();

            ArrayList<Integer> newDatas = testTama.getAllData();
            newDatas.set(2, 75); //physicalCondition à 75
            testTama.setAllData(newDatas);
            System.out.println("ArrayList<Integer> newDatas = testTama.getAllData()");
            System.out.println("newDatas.set(2, 75); //physicalCondition à 75");
            System.out.println("testTama.setAllData(newDatas)");
            System.out.print("testTama.getAllData().toString() = ");
            System.out.println(testTama.getAllData().toString());
            System.out.println();

            System.out.print("testTama.toString() = ");
            System.out.println(testTama.toString());

            testTama.updateDownStat();
            System.out.println("testTama.updateDownStat()");
            System.out.print("testTama.toString() = ");
            System.out.println(testTama.toString());

            testTama.updateDownStat("Health", 0.5);
            System.out.println("testTama.updateDownStat(\"health\", 0.5);");
            System.out.print("testTama.toString() = ");
            System.out.println(testTama.toString());

            System.out.println();
            System.out.println();
            System.out.println();
        }


        /*
         * Test de la classe Engine
         */
        if(!true){
            System.out.println("Test Engine class  : ");
            System.out.println("------------");
            System.out.println();

            Engine testEngine = Engine.createEngineInstance(null, "TamaChat", "test");
            System.out.println("Engine testEngine = Engine.createEngineInstance(null, \"TamaChat\", \"test\")");
            System.out.println();

            System.out.print("testEngine.getInstanceName() = ");
            System.out.println(testEngine.getInstanceName());
            System.out.println();

            System.out.print("testEngine.getCurrentRoom() = ");
            System.out.println(testEngine.getCurrentRoom());
            System.out.println();

            System.out.println("Thread.sleep(1000);");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("testEngine.getCurrentTime() = ");
            System.out.println(testEngine.getCurrentTime());
            System.out.println();

            System.out.print("testEngine.getTamagotchi().toString() = ");
            System.out.println(testEngine.getTamagotchi().toString());
            System.out.println();
        }
    }

}
