package model.time;

import controller.Controller;
import model.tamaEngine.Tamagotchi;

public class TimeEngine extends Thread {
    
    private long checkTimer;
    private Tamagotchi linkedTamagotchi;
    private Controller controller;

    public TimeEngine(long checkTimer,Tamagotchi linkedTamagotchi, Controller control){
        this.checkTimer=checkTimer;
        this.linkedTamagotchi = linkedTamagotchi;
        controller = control;
    }


    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(checkTimer);
                linkedTamagotchi.updateDownStat();
                //controller.updateStatView();
                //System.out.println(linkedTamagotchi.toString());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
