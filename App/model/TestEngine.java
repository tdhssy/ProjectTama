package model;



import model.tamaEngine.TamaChat;
import model.tamaEngine.TamaChien;
import model.tamaEngine.TamaRobot;
import model.tamaEngine.Tamagotchi;
import model.tamagotchiFactory.TamagotchiFactory;
/*
 * Classe de test de Engine
 */
public class TestEngine {
    
    public static void main(String[] args) {
        
        System.out.println("Test TamaEngine");
        System.out.println("==============");

        /*
         * Test des classes Tamagotchi
         */
        {
            System.out.println("Test class Tamagotchi : ");
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
        {

            System.out.println("Test class TamagotchiFactory : ");
            System.out.println("------------");
            System.out.println();

            System.out.print("TamagotchiFactory.createTamagotchi(\"cat\") = ");
            System.out.println(TamagotchiFactory.createTamagotchi("cat").getClass().getSimpleName());
        
            System.out.print("TamagotchiFactory.createTamagotchi(\"dog\") = ");
            System.out.println(TamagotchiFactory.createTamagotchi("dog").getClass().getSimpleName());

            System.out.println("TamagotchiFactory.UnloadTamagotchi()");
            TamagotchiFactory.UnloadTamagotchi();

            System.out.print("TamagotchiFactory.createTamagotchi(\"robot\") = ");
            System.out.println(TamagotchiFactory.createTamagotchi("robot").getClass().getSimpleName());
        }

    }

}
