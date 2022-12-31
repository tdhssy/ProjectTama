package model.tamaEngine;

public class TamaChat extends Tamagotchi{


    final private int FACTOR=2;
    final private int MULTIPLIER=1; //Permet de simplifier le jeu si l'animal en a besoin
    final private int ID=0;

    public TamaChat(){
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
