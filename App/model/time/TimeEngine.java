package model.time;

import java.util.Random;

import controller.Controller;
import javafx.application.Platform;
import model.Engine;
import model.tamaEngine.Tamagotchi;

public class TimeEngine extends Thread {
    
    private long checkTimer;
    private Engine linkedEngine;
    private Tamagotchi linkedTamagotchi;
    private Controller controller;
    private int cpt = 0;
    private int randEvent;
    private final int NEW_EVENT = 45;
    private final int CYCLE_JOURNEY = 60;
    private final int MAX = 1;
    private final int MIN= 0;
    private boolean isDay= true;

    public TimeEngine(long checkTimer,Engine linkedEngine, Controller control){
        this.checkTimer=checkTimer;
        this.linkedEngine=linkedEngine;
        this.linkedTamagotchi = linkedEngine.getTamagotchi();
        controller = control;
    }


    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(checkTimer);
                
                cpt++;
                if(cpt==NEW_EVENT){
                    randEvent=(int) Math.floor(Math.random()*(MAX-MIN+1)+MIN);


                    linkedEngine.setWeather(randEvent);  
                    controller.update_weather();; 
                
                    
                }else if (cpt==CYCLE_JOURNEY) {
                    linkedEngine.makeSave(); //sauvegarde automatique
                    isDay=!isDay;
                    linkedEngine.setJourneyState(isDay);
                    controller.update_Journey_Cycle();
                    cpt=0;
                }


                linkedTamagotchi.updateDownStat();
                Platform.runLater(() ->controller.updateStatView());
            } catch (InterruptedException e) {
                
                //System.out.println("On est bien arivé auparadis");
                Thread.currentThread().interrupt();

            }
        }
    }



}
