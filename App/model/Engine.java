package model;

import java.io.IOException;
import java.util.ArrayList;

import controller.Controller;
import javafx.application.Platform;
import model.room.RessourcesEngine;
import model.saveEngine.Save;
import model.tamaEngine.Tamagotchi;
import model.tamagotchiFactory.TamagotchiFactory;
import model.time.TimeEngine;

public class Engine {

	final private long TIME_UPDATE = 1000; // 1 second between the stats decrease

	private String typeTama;
	private String instanceName;
	private Tamagotchi tamagotchi;
	private TimeEngine timeEngine;
	private RessourcesEngine ressources;
	private String weather;
	private String JourneyState;
	private static Engine engine_Instance = null;

	//Engine constructor 
	private Engine(Controller controller,String typeTamagotchi,String instanceName){
		this.instanceName = instanceName;
		this.typeTama = typeTamagotchi;
		this.ressources=new RessourcesEngine();
		this.tamagotchi = TamagotchiFactory.createTamagotchi(typeTamagotchi);
		this.timeEngine = new TimeEngine(TIME_UPDATE, this, controller);
		this.weather=ressources.getWeather();
		this.JourneyState=ressources.getJourneyState();
		//Platform.runLater(() -> timeEngine.start());
		timeEngine.start();
		
	}

    /**
     * Create unique Engine's Instance 
     * @param Controller Controller linked to Engine
	 * @param String typeTamagotchi [TamaChat, TamaChien, TamaRobot, TamaLapin]
	 * @param String instanceName
	 * @return Engine
     */
	public static Engine createEngineInstance(Controller controller,String typeTamagotchi,String instanceName){
		if(engine_Instance==null){
			engine_Instance = new Engine(controller,typeTamagotchi,instanceName);
		}
		return engine_Instance;
	}

    /**
     * Safety Unload Engine's Instance
	 * return true if the unload is complete else false
	 * @return boolean
     */
	private boolean unloadEngine(){
		boolean isUnload=false;
		this.timeEngine.interrupt();
		engine_Instance=null;
		if(this.timeEngine.isInterrupted() && TamagotchiFactory.UnloadTamagotchi() && engine_Instance==null){
			isUnload=true;
		}
		return isUnload;
		
	}


	/**
     * Build new engine instance with data save 
	 * the return is null if there are no save with the of instance Name
     * @param Controller Controller linked to Engine
	 * @param String instanceName
	 * @return Engine 
     */
	public static Engine loadSave(Controller controller,String instanceName){
		
		ArrayList<Integer> datas;
		int TamaID;
		String typeTamagotchi;
		Engine engine;

		try {
			datas = Save.loadSave(instanceName); //get all data store
			TamaID = datas.get(datas.size()-1); //get the last data who store the ID
			typeTamagotchi ="";
	
			switch (TamaID) { //Convert Int data to String data for typeTamagotchi
				case 0: //TamaChat
					typeTamagotchi = "TamaChat";
					break;
				case 1: //TamaChien
					typeTamagotchi = "TamaChien";
					break;
				case 2: //TamaLapin
					typeTamagotchi = "TamaLapin";
					break;
				case 3: //TamaRobot
					typeTamagotchi = "TamaRobot";
					break;
	
			}
	
			engine = createEngineInstance(controller, typeTamagotchi, instanceName); //create new Engine instance
			engine.getTamagotchi().setAllData(datas); //put all store datas to the tamagotchi



		} catch (IOException e) { //fichier introuvable
			e.getStackTrace();
			engine =  null; 
		} 

		return engine;
	}

	
	/**
     * Save all data in file
     */
	public boolean  makeSave(){
		return Save.makeSave(tamagotchi.getAllData(),instanceName);
	}

	/**
     * Delete save file 
	 * return true if the file is delete else false
	 * @return boolean 
     */
	public static boolean deleteSave(String instanceName){
		return Save.deleteSave(instanceName);
	}

	public static ArrayList<String> getAllSaveName(){
		return Save.getAllSaveName();
	}
	//Fin de l'ajout de clément ici


	/**
     * Get Tamagotchi's intance 
	 * @return Tamagotchi
     */
	public Tamagotchi getTamagotchi(){
		return tamagotchi;
	}

	/**
     * Get instance name 
	 * @return String
     */
	public String getInstanceName(){
		return instanceName;
	}

	/**
     * Get the current room
	 * @return String
     */
	public String getCurrentRoom(){
		return ressources.getCurrentRoom();
	}

	/**
     * Get the next room
	 * @return String
     */
	public String nextRoom(){
		return ressources.nextRoom();
	}

	/**
     * Get the previous room
	 * @return String
     */
	public String previousRoom(){
		return ressources.previousRoom();
	}


	/**
     * Get the previous room
	 * @return String
     */
	public String getWeather(){
		return this.weather;
	}

	/**
     * Set new Weather with a int
     */
	public void setWeather(int n){
		this.weather=ressources.getWeather(n);
	}

	/**
     * get the journey State
     */
	public String getJourneyCycle(){
		return this.JourneyState;
	}

	/**
     * Set the journey State with boolean
     */
	public void setJourneyState(boolean isDay){
		this.JourneyState=ressources.getJourneyState(isDay);
	}

	/**
     * Check if the Tamagotchi is Dead
	 * @return boolean
     */
	public boolean isDead() {
		return (tamagotchi.getHealth() <= 0);
	}

	/**
     * Get all Tamagotchi's datas in Integer list 
	 * Format : [Health, Satiety, PhysicalCondition, MentalHealth, Needs, Sleep, Hygiene, ID]
	 * ID : TamaChat = 0 | TamaChien = 1 | TamaLapin = 2 | TamaRobot = 3
	 * @return ArrayList<Integer> 
     */
	public ArrayList<Integer> getTamaDatas(){
		return tamagotchi.getAllData();
	}

	/**
     * Get all Tamagotchi's datas between [0-1] except ID 
	 * Format : [Health, Satiety, PhysicalCondition, MentalHealth, Needs, Sleep, Hygiene, ID]
	 * ID : TamaChat = 0 | TamaChien = 1 | TamaLapin = 2 | TamaRobot = 3
	 * @return ArrayList<Integer> 
     */
	public ArrayList<Double> getDatasPourcent(){
		ArrayList<Double> res = new ArrayList<>();
		ArrayList<Integer> temp = getTamaDatas();
		double ID = temp.get(temp.size()-1);
		temp.remove(temp.size()-1);

		for (int value : temp) {
			res.add(((double)value/1.5)/100);
		}

		res.add(ID);
		return res;

	}

	/**
     * Update all Tamagotchi's datas
	 * Format : [Health, Satiety, PhysicalCondition, MentalHealth, Needs, Sleep, Hygiene, ID]
	 * ID : TamaChat = 0 | TamaChien = 1 | TamaLapin = 2 | TamaRobot = 3
	 * @param ArrayList<Integer> New Datas
     */
	public void updateNewDatas(ArrayList<Integer> newDatas){
		tamagotchi.setAllData(newDatas);
	}

	/**
     * Action de manger
	 * Augmente la jauge de satieté
     */
	public void manger(){
		tamagotchi.updateStat("Satiety", 10,tamagotchi.getMULTIPLIER()); //facteur à modifier
	}

	/**
     * Action de dormir
	 * Augmente la jauge de sommeil
	 * Augmente la jauge de sante mental
	 * Diminue la jauge de satiete
     */
	public void dormir(){
		tamagotchi.updateStat("Sleep", 20,tamagotchi.getMULTIPLIER());
		tamagotchi.updateStat("MentalHealth", 10,tamagotchi.getMULTIPLIER());
		tamagotchi.updateStat("PhysicalCondition", 20,tamagotchi.getMULTIPLIER());

		tamagotchi.updateStat("Satiety", -15,1);		
	}

	/**
     * Action de se laver
	 * Augmente la jauge de d'hygiene
     */
	public void seLaver(){
		tamagotchi.updateStat("Hygiene", 10,1);
	}

	/**
     * Action de faire ces besoins
	 * Diminue la jauge de besoin
     */
	public void besoin(){
		tamagotchi.updateStat("Needs", 10,1);
	}

	/**
     * Action de jouer
	 * Augmente la jauge de sante mental
	 * Diminue la jauge de satiete
	 * Diminue la jauge de condition physique
	 * Diminue la jauge de de sommeil
     */
	public void jouer(){
		tamagotchi.updateStat("MentalHealth", 10,tamagotchi.getMULTIPLIER());

		tamagotchi.updateStat("Satiety", -10,1);
		tamagotchi.updateStat("PhysicalCondition", -15,1);
		tamagotchi.updateStat("Sleep", -10,1);
	}


	/**
     * safety save and unload
	 * return true if the save is create else false
	 * @return boolean
     */
	public boolean quit(){
		boolean isSaved=false;
		if(makeSave() && unloadEngine()){
			isSaved=true;
		}
		return isSaved;
	}

	public void destroy(){
		unloadEngine();
	}

	public String getTypeTama(){
		return this.typeTama;
	}

}
