package model.room;

import java.util.HashMap;


public class RoomEngine {
    
    final private String RESSOURCES_PATH = "Ressources/";
    final private String EXTENSION = ".png";

    
    final private String BATHROOM = "bath";
    final private String LIVING_ROOM = "livRo";
    final private String KITCHEN = "kit";
    final private String GARDEN = "gard";

    private int NUMBER_OF_ROOM;

    private int currentRoom=1; //default is LivingRoom

    private HashMap<Integer,String> Rooms = new HashMap<>();

    public RoomEngine(){
        Rooms.put(0, RESSOURCES_PATH+BATHROOM+EXTENSION);
        Rooms.put(1, RESSOURCES_PATH+LIVING_ROOM+EXTENSION);
        Rooms.put(2, RESSOURCES_PATH+KITCHEN+EXTENSION);
        Rooms.put(3, RESSOURCES_PATH+GARDEN+EXTENSION);

        NUMBER_OF_ROOM=Rooms.size()-1;
    }

    public String nextRoom() {
        String res = Rooms.get(currentRoom);
        if(currentRoom<NUMBER_OF_ROOM){
            currentRoom++;
            res=Rooms.get(currentRoom);
        }
        return res;
    }

    public String previousRoom() {
        String res = Rooms.get(currentRoom);
        if(currentRoom>0){
            currentRoom--;
            res=Rooms.get(currentRoom);
        }
        return res;
    }

    public String getCurrentRoom() {
        return Rooms.get(currentRoom);
    }

}
