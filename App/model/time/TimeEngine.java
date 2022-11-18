package model.time;

import model.tamaEngine.Tamagotchi;

public class TimeEngine extends Thread {
    
    private long checkTimer;
    private Tamagotchi linkedTamagotchi;

    public TimeEngine(long checkTimer,Tamagotchi linkedTamagotchi){
        this.checkTimer=checkTimer;
        this.linkedTamagotchi = linkedTamagotchi;
    }


    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(checkTimer);
                linkedTamagotchi.updateDownStat();
                //System.out.println(linkedTamagotchi.toString());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
