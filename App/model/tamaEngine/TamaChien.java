package model.tamaEngine;

public class TamaChien extends Tamagotchi{

    final private int FACTOR=3;
    final private int ID=1;

    public TamaChien(){
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
