package model.tamaEngine;

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
							+"Health = "+getHealth()+System.lineSeparator()
							+"Satiety = "+getSatiety()+System.lineSeparator()
							+"PhysicalCondition = "+getPhysicalCondition()+System.lineSeparator()
							+"MentalHealth = "+getMentalHealth()+System.lineSeparator()
							+"Needs = "+getNeeds()+System.lineSeparator()
							+"Sleep = "+getSleep()+System.lineSeparator();
		return textFormat;
	}

	/*
	 * Getter et Setter des différents variables
	 */
	public abstract double getSatiety();
	public abstract void setSatiety(double satiety);

	public abstract double getPhysicalCondition();
	public abstract void setPhysicalCondition(double physicalCondition);

	public abstract double getMentalHealth();
	public abstract void setMentalHealth(double MentalHealth);

	public abstract double getNeeds();
	public abstract void setNeeds(double Needs);

	public abstract double getSleep();
	public abstract void setSleep(double sleep);


}
