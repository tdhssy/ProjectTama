package model;

import java.util.ArrayList;

import controller.Controller;
import model.saveEngine.Save;
import model.tamaEngine.Tamagotchi;
import model.tamagotchiFactory.TamagotchiFactory;

public class Engine {

	private long startedTime; //creation time

	private String currentRoom;
	private String instanceName;
	private Tamagotchi tamagotchi;
	private Controller controller;
	private static Engine engine_Instance = null;

	//Engine constructor 
	private Engine(Controller controller,String typeTamagotchi,String instanceName){
		this.controller = controller;
		this.instanceName = instanceName;
		this.tamagotchi = TamagotchiFactory.createTamagotchi(typeTamagotchi);
		this.startedTime = System.currentTimeMillis();
		this.currentRoom = "default";
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

	public void unloadEngine(){
		engine_Instance=null;
	}

	//build new engine instance with data store in the instanceName already create
	public static Engine loadSave(Controller controller,String instanceName){
		ArrayList<Integer> datas = Save.loadSave(instanceName); //get all data store
		int typeTamagotchiData = datas.get(datas.size()); //get the last data who store the type of Tamagotchi
		String typeTamagotchi ="";

		switch (typeTamagotchiData) { //Convert Int data to String data for typeTamagotchi
			case 0: //TamaChat
				typeTamagotchi = "TamaChat";
				break;
			case 1: //TamaChien
				typeTamagotchi = "TamaChien";
				break;
			case 2: //TamaRobot
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

	//calculate the time play since the creation of the engine
	public long getCurrentTime(){
		return System.currentTimeMillis() - startedTime;
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


}
