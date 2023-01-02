package model.ressourcesEngine;

import java.util.ArrayList;
import java.util.HashMap;


public class RessourcesEngine {
    



    
    final private String RESSOURCES_PATH = "/";
    final private String EXTENSION_PNG = ".png";
    final private String EXTENSION_GIF = ".gif";

    /* ---------------------------------------------------------------- */
    //Name journey cycle file
    final private String DAY = "day";
    final private String NIGHT = "night";

    private ArrayList<String> journeyCycle = new ArrayList<>();    

    /* ---------------------------------------------------------------- */
    //Name of weather file
    final private String RAIN = "rain";
    final private String DEFAULT_WEATHER = "defaultWeather";

    private ArrayList<String> weathers = new ArrayList<>();
    private int  numberOfWeather;


    /* ---------------------------------------------------------------- */
    //Name of room file
    final private String BATHROOM = "bath";
    final private String LIVING_ROOM = "salon";
    final private String KITCHEN = "kitchen";
    final private String GARDEN = "garden";

    private ArrayList<String> rooms = new ArrayList<>();
    private int numberOfRooms;
    private int currentRoom=1; //default is LivingRoom


    

    public RessourcesEngine(){

        //Journey Cycle
        this.journeyCycle.add(RESSOURCES_PATH+DAY+EXTENSION_PNG);
        this.journeyCycle.add(RESSOURCES_PATH+NIGHT+EXTENSION_PNG);

        //Weathers
        this.weathers.add(RESSOURCES_PATH+DEFAULT_WEATHER+EXTENSION_PNG);
        this.weathers.add(RESSOURCES_PATH+RAIN+EXTENSION_GIF);

        this.numberOfWeather = weathers.size()-1;

        //Rooms 
        this.rooms.add(RESSOURCES_PATH+BATHROOM+EXTENSION_PNG);
        this.rooms.add(RESSOURCES_PATH+LIVING_ROOM+EXTENSION_PNG);
        this.rooms.add(RESSOURCES_PATH+KITCHEN+EXTENSION_PNG);
        this.rooms.add(RESSOURCES_PATH+GARDEN+EXTENSION_PNG);

        this.numberOfRooms=rooms.size()-1;
    }

    public String nextRoom() {
        String res = rooms.get(currentRoom);
        if(currentRoom<numberOfRooms){
            currentRoom++;
            res=rooms.get(currentRoom);
        }
        return res;
    }

    public String previousRoom() {
        String res = rooms.get(currentRoom);
        if(currentRoom>0){
            currentRoom--;
            res=rooms.get(currentRoom);
        }
        return res;
    }

    public String getCurrentRoom() {
        return rooms.get(currentRoom);
    }

    public String getWeather(int n){
        if(n>numberOfWeather) n=numberOfWeather;
        if(n<0) n=0;
        return this.weathers.get(n);
    }

    public String getWeather(){ //default Weather
        return this.weathers.get(0);
    }

    public String getJourneyState(Boolean isDay){ //default Journey State
        String res;
        if(isDay) res=this.journeyCycle.get(0); //Day
        else res=this.journeyCycle.get(1); //Night
        return res;
    }

    public String getJourneyState(){ //default Journey State
        return this.journeyCycle.get(0);
    }
}
