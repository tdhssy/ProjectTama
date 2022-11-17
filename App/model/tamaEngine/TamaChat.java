package model.tamaEngine;

public class TamaChat extends Tamagotchi{

    private int satiety;
    private int physicalCondition;
    private int MentalHealth;
    private int Needs;
    private int Sleep;
    private double factor=1;

    public TamaChat(){
        satiety = 50;
        physicalCondition = 50;
        MentalHealth = 50;
        Needs = 50;
        Sleep = 50;
    
    }

    @Override
    public int getSatiety() {
        return satiety;
    }

    @Override
    public void setSatiety(int satiety) {
        this.satiety=satiety;
        
    }

    @Override
    public int getPhysicalCondition() {
        return physicalCondition;
    }

    @Override
    public void setPhysicalCondition(int physicalCondition) {
        this.physicalCondition=physicalCondition;
        
    }

    @Override
    public int getMentalHealth() {
        return MentalHealth;
    }

    @Override
    public void setMentalHealth(int MentalHealth) {
        this.MentalHealth=MentalHealth;
        
    }

    @Override
    public int getNeeds() {
        return Needs;
    }

    @Override
    public void setNeeds(int Needs) {
        this.Needs=Needs;
        
    }

    @Override
    public int getSleep() {
        return Sleep;
    }

    @Override
    public void setSleep(int sleep) {
        this.Sleep=sleep;
        
    }

    @Override
    public double getFactor() {
        return factor;
    }
    
}
