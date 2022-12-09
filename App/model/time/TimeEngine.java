package model.time;

import java.util.Random;

import controller.Controller;
import model.Engine;
import model.tamaEngine.Tamagotchi;

public class TimeEngine extends Thread {
    
    private long checkTimer;
    private Engine linkedEngine;
    private Tamagotchi linkedTamagotchi;
    private Controller controller;
    private int cpt = 0;
    private int randEvent;
    private final int NEW_EVENT = 30;
    private final int MAX = 2;
    private final int MIN= 1;

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
                    switch (randEvent) {
                        case 1: //Rain
                            System.out.println("Rain");
                            linkedEngine.setWeather("Rain");
                            break;

                        case 2: //Without Rain
                            System.out.println("no rain");
                            linkedEngine.setWeather("DefaultWeather");
                            break;
                    
                        default:
                            break;
                    }
                    cpt=0;
                }


                linkedTamagotchi.updateDownStat();
                controller.updateStatView();
            } catch (InterruptedException e) {
                
                //System.out.println("On est bien arivé auparadis");
                Thread.currentThread().interrupt();

            }
        }
    }



}
