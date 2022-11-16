package model.tamagotchiFactory;

import model.tamaEngine.TamaChat;
import model.tamaEngine.TamaChien;
import model.tamaEngine.TamaRobot;
import model.tamaEngine.Tamagotchi;

/**
 * TamagotchiFactory
 */

public class TamagotchiFactory {

    private static Tamagotchi tama_instance = null;

    public static Tamagotchi createTamagotchi(String typeTamagotchString){
        if(tama_instance==null){ //check if Tama exist
            switch (typeTamagotchString) {

                case "cat": //creat TamaChat
                    tama_instance = createTamaChat();
                    break;
            
                case "dog": //creat TamaChien
                    tama_instance = createTamaChien();
                    break;

                case "robot": //creat TamaRobot
                    tama_instance = createTamaRobot();
                    break;

                default:
                    //TODO faire une exception custom
                    break;
            }
        }
        return tama_instance;
        
    }

    public static void UnloadTamagotchi(){
        tama_instance = null;
    }

    private static Tamagotchi createTamaChat(){
        return new TamaChat();
    }

    private static Tamagotchi createTamaChien(){
        return new TamaChien();
    }

    private static Tamagotchi createTamaRobot(){
        return new TamaRobot();
    }
    
}