package model;



import model.tamaEngine.TamaChat;
import model.tamaEngine.TamaChien;
import model.tamaEngine.TamaRobot;
import model.tamaEngine.Tamagotchi;
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

        System.out.println("Test Tamagotchi : ");
        System.out.println("------------");
        System.out.println();

        Tamagotchi chat =  new TamaChat();
        System.out.println("TamaChat : ");
        System.out.println("------------");

        System.out.println("Initial status :");
        System.out.println("Health = "+chat.getHealth());
        System.out.println("MentalHealth = "+chat.getMentalHealth());
        System.out.println("PhysicalCondition = "+chat.getPhysicalCondition());
        System.out.println("Needs = "+chat.getNeeds());
        System.out.println("Satiety = "+chat.getSatiety());
        System.out.println("Sleep = "+chat.getSleep());
        System.out.println("------------");

        int newStatus = 20;
        System.out.println("Set value to "+newStatus+" :");

        chat.setHealth(newStatus);
        System.out.println("Health = "+chat.getHealth());

        chat.setMentalHealth(newStatus);
        System.out.println("MentalHealth = "+chat.getMentalHealth());

        chat.setPhysicalCondition(newStatus);
        System.out.println("PhysicalCondition = "+chat.getPhysicalCondition());

        chat.setNeeds(newStatus);
        System.out.println("Needs = "+chat.getNeeds());

        chat.setSatiety(newStatus);
        System.out.println("Satiety = "+chat.getSatiety());

        chat.setSleep(newStatus);
        System.out.println("Sleep = "+chat.getSleep());
        System.out.println("------------");
        System.out.println();

        //=========================================================

        Tamagotchi chien =  new TamaChien();
        System.out.println("Tamachien : ");
        System.out.println("------------");

        System.out.println("Initial status :");
        System.out.println("Health = "+chien.getHealth());
        System.out.println("MentalHealth = "+chien.getMentalHealth());
        System.out.println("PhysicalCondition = "+chien.getPhysicalCondition());
        System.out.println("Needs = "+chien.getNeeds());
        System.out.println("Satiety = "+chien.getSatiety());
        System.out.println("Sleep = "+chien.getSleep());
        System.out.println("------------");

        int newStatus2 = 25;
        System.out.println("Set value to "+newStatus2+" :");
        
        chien.setHealth(newStatus2);
        System.out.println("Health = "+chien.getHealth());

        chien.setMentalHealth(newStatus2);
        System.out.println("MentalHealth = "+chien.getMentalHealth());

        chien.setPhysicalCondition(newStatus2);
        System.out.println("PhysicalCondition = "+chien.getPhysicalCondition());

        chien.setNeeds(newStatus2);
        System.out.println("Needs = "+chien.getNeeds());

        chien.setSatiety(newStatus2);
        System.out.println("Satiety = "+chien.getSatiety());

        chien.setSleep(newStatus2);
        System.out.println("Sleep = "+chien.getSleep());
        System.out.println("------------");
        System.out.println();

        //=========================================================

        Tamagotchi robot =  new TamaRobot();
        System.out.println("Tamarobot : ");
        System.out.println("------------");

        System.out.println("Initial status :");
        System.out.println("Health = "+robot.getHealth());
        System.out.println("MentalHealth = "+robot.getMentalHealth());
        System.out.println("PhysicalCondition = "+robot.getPhysicalCondition());
        System.out.println("Needs = "+robot.getNeeds());
        System.out.println("Satiety = "+robot.getSatiety());
        System.out.println("Sleep = "+robot.getSleep());
        System.out.println("------------");

        int newStatus3 = 30;
        System.out.println("Set value to "+newStatus3+" :");
        
        robot.setHealth(newStatus3);
        System.out.println("Health = "+robot.getHealth());

        robot.setMentalHealth(newStatus3);
        System.out.println("MentalHealth = "+robot.getMentalHealth());

        robot.setPhysicalCondition(newStatus3);
        System.out.println("PhysicalCondition = "+robot.getPhysicalCondition());

        robot.setNeeds(newStatus3);
        System.out.println("Needs = "+robot.getNeeds());

        robot.setSatiety(newStatus3);
        System.out.println("Satiety = "+robot.getSatiety());

        robot.setSleep(newStatus3);
        System.out.println("Sleep = "+robot.getSleep());
        System.out.println("------------");
    }

}
