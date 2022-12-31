package model.tamaEngine;

public class TamaLapin extends Tamagotchi {

    final private int FACTOR = 10;
    final private int MULTIPLIER = 2;
    final private int ID=2;

    public TamaLapin(){
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
    
    @Override
    public int getMULTIPLIER(){
        return MULTIPLIER;
    }
}
