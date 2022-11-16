package model.tamaEngine;

import java.util.ArrayList;

public abstract class Tamagotchi {

	private int health = 100; //Vie général des tamagotchi

	public Tamagotchi(){
		
	}

	/*
	 * Getter et Setter de health
	 */
	public int getHealth(){ return health;}
	public void setHealth(int h){ health = h; }

	public String toString(){
		String textFormat = this.getClass().getSimpleName()+" : "+System.lineSeparator()
							+"Factor = "+getFactor()+System.lineSeparator()
							+"Health = "+getHealth()+System.lineSeparator()
							+"Satiety = "+getSatiety()+System.lineSeparator()
							+"PhysicalCondition = "+getPhysicalCondition()+System.lineSeparator()
							+"MentalHealth = "+getMentalHealth()+System.lineSeparator()
							+"Needs = "+getNeeds()+System.lineSeparator()
							+"Sleep = "+getSleep()+System.lineSeparator();
		return textFormat;
	}

	/*
	 * Datas Format :
	 *  int list [Health, Satiety, PhysicalCondition, MentalHealth, Needs, Sleep, typeTamagotchi]
	 *	typeTamagotchi : chat = 0. | chien = 1. | robot = 2.
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
		switch (this.getClass().getSimpleName()) {
			case "TamaChat":
				datas.add(0);
				break;
			case "TamaChien":
				datas.add(1);
				break;
			case "TamaRobot":
				datas.add(2);
				break;
		}


		return datas;
	}

	//decrease one stat with factor
	public void updateDownStat(String stat,double factor){
		if(factor>1) factor = 1;
		if(factor<0) factor = 0;

		switch (stat) {
			case "Health":
				this.setHealth(this.getHealth()-(int)(this.getHealth()*factor));
				break;
			case "Satiety":
				this.setSatiety(this.getSatiety()-(int)(this.getSatiety()*factor));
				break;
			case "PhysicalCondition":
				this.setPhysicalCondition(this.getPhysicalCondition()-(int)(this.getPhysicalCondition()*factor));
				break;
			case "MentalHealth":
				this.setMentalHealth(this.getMentalHealth()-(int)(this.getMentalHealth()*factor));
				break;
			case "Needs":
				this.setNeeds(this.getNeeds()-(int)(this.getNeeds()*factor));
				break;
			case "Sleep":
				this.setHealth(this.getSleep()-(int)(this.getSleep()*factor));
				break;
			default:
				//TODO Exception
				break;
	
		}
	}

	//decrease all stats and depend of the Personnal factor
	public void updateDownStat(){
		//all data change
		ArrayList<Integer> datas = this.getAllData();//curent data
		int typeTamagotchi = datas.get(datas.size()-1); //save typeTamagotchi
		datas.remove(datas.size()-1); //remove datas of typeTamagotchi

		ArrayList<Integer> newDatas = new ArrayList<>();
		for(int data : datas){
			newDatas.add(data-(int)(data*getFactor()));
		}
		newDatas.add(typeTamagotchi);//insert typeTamagotchi in the end

		this.setAllData(newDatas);//update all datas

	}

	/*
	 * Getter et Setter des différents variables
	 */
	public abstract double getFactor();

	public abstract int getSatiety();
	public abstract void setSatiety(int satiety);

	public abstract int getPhysicalCondition();
	public abstract void setPhysicalCondition(int physicalCondition);

	public abstract int getMentalHealth();
	public abstract void setMentalHealth(int MentalHealth);

	public abstract int getNeeds();
	public abstract void setNeeds(int Needs);

	public abstract int getSleep();
	public abstract void setSleep(int sleep);


}
