package model.tamaEngine;

public class TamaRobot extends Tamagotchi{

    private double satiety; //Power
    private double physicalCondition;
    private double MentalHealth;
    private double Needs;
    private double Sleep;

    public TamaRobot(){
        satiety = 50;
        physicalCondition = 50;
        MentalHealth = 50;
        Needs = 50;
        Sleep = 50;
    }

    @Override
    public double getSatiety() {
        return satiety;
    }

    @Override
    public void setSatiety(double satiety) {
        this.satiety=satiety;
        
    }

    @Override
    public double getPhysicalCondition() {
        return physicalCondition;
    }

    @Override
    public void setPhysicalCondition(double physicalCondition) {
        this.physicalCondition=physicalCondition;
        
    }

    @Override
    public double getMentalHealth() {
        return MentalHealth;
    }

    @Override
    public void setMentalHealth(double MentalHealth) {
        this.MentalHealth=MentalHealth;
        
    }

    @Override
    public double getNeeds() {
        return Needs;
    }

    @Override
    public void setNeeds(double Needs) {
        this.Needs=Needs;
        
    }

    @Override
    public double getSleep() {
        return Sleep;
    }

    @Override
    public void setSleep(double sleep) {
        this.Sleep=sleep;
        
    }
    
}
