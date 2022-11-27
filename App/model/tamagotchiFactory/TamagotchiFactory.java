package model.tamagotchiFactory;

import model.tamaEngine.TamaChat;
import model.tamaEngine.TamaChien;
import model.tamaEngine.TamaLapin;
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

                case "TamaChat": //creat TamaChat
                    tama_instance = createTamaChat();
                    break;
            
                case "TamaChien": //creat TamaChien
                    tama_instance = createTamaChien();
                    break;

                case "TamaRobot": //creat TamaRobot
                    tama_instance = createTamaRobot();
                    break;

                case "TamaLapin": //creat TamaLapin
                    tama_instance = createTamaLapin();
                    break;

                default:
                    //TODO faire une exception custom
                    break;
            }
        }
        return tama_instance;
        
    }

    public static boolean UnloadTamagotchi(){
        tama_instance = null;
        boolean isUnload=false;
        if(tama_instance==null){
            isUnload=true;
        }
        return isUnload;
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

    private static Tamagotchi createTamaLapin(){
        return new TamaLapin();
    }
    
}