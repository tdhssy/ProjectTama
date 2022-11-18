package model.tamaEngine;

import java.util.ArrayList;

public abstract class Tamagotchi {



	final private int MAX_VALUE = 150; //Maximum value of stat
	final private int MIN_VALUE = 0; //Minimum value of stat
	final private int INITIAL_STAT = 75; //Stats at begining of the game

	private int health; //Vie général des tamagotchi
	private int satiety; //Power
    private int physicalCondition;
    private int mentalHealth;
    private int needs;
    private int sleep;

	public Tamagotchi(){

		this.health = MAX_VALUE;
		this.satiety = INITIAL_STAT;
        this.physicalCondition = INITIAL_STAT;
        this.mentalHealth = INITIAL_STAT;
        this.needs = INITIAL_STAT;
        this.sleep = INITIAL_STAT;
	}

	/*
	 * Getter et Setter de health
	 */
	public int getHealth(){ return health;}
	public void setHealth(int health){ this.health = health; }

	public String toString(){
		String textFormat = this.getClass().getSimpleName()+" : "+System.lineSeparator()
							+"ID = "+this.getID()+System.lineSeparator()
							+"FACTOR = "+this.getFactor()+System.lineSeparator()
							+"Health = "+this.getHealth()+System.lineSeparator()
							+"Satiety = "+this.getSatiety()+System.lineSeparator()
							+"PhysicalCondition = "+this.getPhysicalCondition()+System.lineSeparator()
							+"MentalHealth = "+this.getMentalHealth()+System.lineSeparator()
							+"Needs = "+this.getNeeds()+System.lineSeparator()
							+"Sleep = "+this.getSleep()+System.lineSeparator();
		return textFormat;
	}

	/*
	 * Datas Format :
	 *  int list [Health, Satiety, PhysicalCondition, MentalHealth, Needs, Sleep, ID]
	 *	ID : TamaChat = 0 | TamaChien = 1 | TamaLapin = 2 | TamaRobot = 3
	 */

	public void setAllData(ArrayList<Integer> datas) {
		if(datas.size()==7){
			setHealth(datas.get(0));
			setSatiety(datas.get(1));
			setPhysicalCondition(datas.get(2));
			setMentalHealth(datas.get(3));
			setNeeds(datas.get(4));
			setSleep(datas.get(5));
		}else{
			//TODO Exception size to large
		}
	}

	public ArrayList<Integer> getAllData(){
		ArrayList<Integer> datas = new ArrayList<>();
		datas.add(getHealth());
		datas.add(getSatiety());
		datas.add(getPhysicalCondition());
		datas.add(getMentalHealth());
		datas.add(getNeeds());
		datas.add(getSleep());
		datas.add(this.getID());


		return datas;
	}

	//decrease one stat with factor
	public void updateStat(String stat,int factor){


		switch (stat) {
			case "Health":
				if(this.getHealth()+factor>MIN_VALUE && this.getHealth()+factor<MAX_VALUE){
					this.setHealth(this.getHealth()+factor);
				}else if(this.getHealth()+factor<=MIN_VALUE){
					this.setHealth(MIN_VALUE);
				}else {
					this.setHealth(MAX_VALUE);
				}
				break;

			case "Satiety":
				if(this.getSatiety()+factor>MIN_VALUE && this.getSatiety()+factor<MAX_VALUE){
					this.setSatiety(this.getSatiety()+factor);
				}else if(this.getSatiety()+factor<=MIN_VALUE){
					this.setSatiety(MIN_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}else{
					this.setSatiety(MAX_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}
				break;

			case "PhysicalCondition":
				if(this.getPhysicalCondition()+factor>MIN_VALUE && this.getPhysicalCondition()+factor<MAX_VALUE){
					this.setPhysicalCondition(this.getPhysicalCondition()+factor);
				}else if(this.getPhysicalCondition()+factor<=MIN_VALUE){
					this.setPhysicalCondition(MIN_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}else{
					this.setPhysicalCondition(MAX_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}
				break;

			case "MentalHealth":
				if(this.getMentalHealth()+factor>MIN_VALUE && this.getMentalHealth()+factor<MAX_VALUE){
					this.setMentalHealth(this.getMentalHealth()+factor);
				}else if(this.getMentalHealth()+factor<=MIN_VALUE){
					this.setMentalHealth(MIN_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}else{
					this.setMentalHealth(MAX_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}
				break;

			case "Needs":
				if(this.getNeeds()+factor>MIN_VALUE && this.getMentalHealth()+factor<MAX_VALUE){
					this.setNeeds(this.getNeeds()+factor);
				}else if(this.getMentalHealth()+factor<=MIN_VALUE){
					this.setNeeds(MIN_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}else{
					this.setNeeds(MAX_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}
				break;

			case "Sleep":
				if(this.getSleep()+factor>MIN_VALUE && this.getSleep()+factor<MAX_VALUE){
					this.setHealth(this.getSleep()+factor);
				}else if(this.getSleep()+factor<=MIN_VALUE){
					this.setHealth(MIN_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}else{
					this.setHealth(MAX_VALUE);
					this.setHealth(this.getHealth()-this.getFactor());
				}
				break;

			default:
				//TODO Exception
				break;
	
		}
	}

	//decrease all stats and depend of the Personnal factor
	public void updateDownStat(){
		
		ArrayList<Integer> datas = this.getAllData();//current datas
		ArrayList<Integer> newDatas = new ArrayList<>(); //new ArrayList of datas
		int typeTamagotchi = datas.get(datas.size()-1); //save ID
		int health = datas.get(0); //save Health

		datas.remove(datas.size()-1); //remove ID from datas
		datas.remove(0);//remove health from datas

		newDatas.add(health); //put the health in the first element of newDatas


		for(int data : datas){
			if(data-getFactor()<=MIN_VALUE){	//check if the value can be decrease
				newDatas.add(MIN_VALUE);
				health-=getFactor(); //decrease the health if the current stat check that are zero
				
			}else{
				newDatas.add(data-getFactor());//decrease the current stat check
			}
		}
		newDatas.set(0, health); //update health value
		newDatas.add(typeTamagotchi);//insert ID in the end
	
		this.setAllData(newDatas);//update all datas

	}

	/*
	 * Getter et Setter des différents variables
	 */
	public abstract int getFactor();
	public abstract int getID();


    public int getSatiety() {
        return satiety;
    }
    public void setSatiety(int satiety) {
        this.satiety=satiety;
    }


    public int getPhysicalCondition() {
        return physicalCondition;
    }
    public void setPhysicalCondition(int physicalCondition) {
        this.physicalCondition=physicalCondition;
    }


    public int getMentalHealth() {
        return mentalHealth;
    }
    public void setMentalHealth(int MentalHealth) {
        this.mentalHealth=MentalHealth;
    }


    public int getNeeds() {
        return needs;
    }
    public void setNeeds(int Needs) {
        this.needs=Needs;
    }


    public int getSleep() {
        return sleep;
    }
    public void setSleep(int sleep) {
        this.sleep=sleep;
    }


}
