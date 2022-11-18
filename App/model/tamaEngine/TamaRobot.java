package model.tamaEngine;

public class TamaRobot extends Tamagotchi{


    final private int FACTOR=1;
    final private int ID = 3;


    public TamaRobot(){
        super();
    }

    @Override
    public int getFactor() {
        return FACTOR;
    }

    @Override
    public int getID() {
        return ID;
    }
    
}
