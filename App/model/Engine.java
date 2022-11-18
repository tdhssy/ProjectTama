package model;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import controller.Controller;
import model.saveEngine.Save;
import model.tamaEngine.Tamagotchi;
import model.tamagotchiFactory.TamagotchiFactory;
import model.time.TimeEngine;

public class Engine {

	final private long TIME_UPDATE = 1000; // 1 second between the stats decrease
	final private String ROOM = "Default"; // Default room;

	private String currentRoom;
	private String instanceName;
	private Tamagotchi tamagotchi;
	private TimeEngine TimeEngine;
	private Controller controller;
	private static Engine engine_Instance = null;

	//Engine constructor 
	private Engine(Controller controller,String typeTamagotchi,String instanceName){
		this.controller = controller;
		this.instanceName = instanceName;
		this.tamagotchi = TamagotchiFactory.createTamagotchi(typeTamagotchi);
		this.TimeEngine = new TimeEngine(TIME_UPDATE, tamagotchi);
		this.currentRoom = ROOM;
		TimeEngine.start();
	}

	/*
	 * Singleton
	 * Create new engine
	 */
	public static Engine createEngineInstance(Controller controller,String typeTamagotchi,String instanceName){
		if(engine_Instance==null){
			engine_Instance = new Engine(controller,typeTamagotchi,instanceName);
		}
		return engine_Instance;
	}

	//Unload all datas of the Engine 
	public void unloadEngine(){
		this.TimeEngine.interrupt();
		TamagotchiFactory.UnloadTamagotchi();
		engine_Instance=null;
	}

	//build new engine instance with data store in the instanceName already create
	public static Engine loadSave(Controller controller,String instanceName){
		ArrayList<Integer> datas = Save.loadSave(instanceName); //get all data store
		int TamaID = datas.get(datas.size()-1); //get the last data who store the ID
		String typeTamagotchi ="";

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
			case 3:
				typeTamagotchi = "TamaRobot";
				break;

		}

		Engine engine = createEngineInstance(controller, typeTamagotchi, instanceName); //create new Engine instance
		engine.getTamagotchi().setAllData(datas); //put all store datas to the tamagotchi
		return engine;
	}

	public void makeSave(){
		Save.makeSave(tamagotchi.getAllData(),instanceName);
	}

	public Tamagotchi getTamagotchi(){
		return tamagotchi;
	}

	public String getInstanceName(){
		return instanceName;
	}

	public String getCurrentRoom(){
		return currentRoom;
	}
	public void setCurrentRoom(String newRoom){
		this.currentRoom = newRoom;
	}

	public Boolean isDead() {
		if (tamagotchi.getHealth() <= 0)
			return true;
		return false;
	}
}
