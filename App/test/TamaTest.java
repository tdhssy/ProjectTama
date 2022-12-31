package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import model.Engine;
import model.tamaEngine.Tamagotchi;


public class TamaTest {

    static private Engine engine;

    @Test
    public void creationEngine()
    {
        engine = Engine.createEngineInstance(null, "TamaChien", "testdog");
        assertEquals("testdog", engine.getInstanceName());
    }

    @Test
    public void changeRoom()
    {
        engine = Engine.createEngineInstance(null, "TamaChien", "testdog");
        //engine.move("garden");
        assertEquals("/salon.png", engine.getCurrentRoom());
    }

    @Test
    public void changeStatsTama()
    {
        engine = Engine.createEngineInstance(null, "TamaChat", "testcat");
        assertEquals("testcat", engine.getInstanceName());
        Tamagotchi tama = engine.getTamagotchi();
        assertNotNull(tama);
        ArrayList<Integer> old_data = tama.getAllData();
        ArrayList<Integer> new_data = new ArrayList<>();
            new_data.add(old_data.get(0)-50);  //Health
            new_data.add(old_data.get(1)-50);  //Satiety
            new_data.add(old_data.get(2)-50);  //PhysicalCondition
            new_data.add(old_data.get(3)-50);  //MentalHealth
            new_data.add(old_data.get(4)-50);  //Needs
            new_data.add(old_data.get(5)-50);  //Sleep
            new_data.add(0);                   //ID
        ArrayList<Integer> oracle = new ArrayList<>();
            oracle.add(100);  //Health        
            oracle.add(25);   //Satiety        
            oracle.add(25);   //PhysicalCondition        
            oracle.add(25);   //MentalHealth        
            oracle.add(25);   //Needs        
            oracle.add(25);   //Sleep        
            oracle.add(0);    //ID
        tama.setAllData(new_data); 
        assertEquals(oracle, tama.getAllData());
    }

    @Test
    public void statsOverTime()
    {
        engine = Engine.createEngineInstance(null, "TamaChat", "testcat");
        Tamagotchi tama = engine.getTamagotchi();
        ArrayList<Integer> oracle = new ArrayList<>();
            oracle.add(150);  //Health        
            oracle.add(69);   //Satiety        
            oracle.add(69);   //PhysicalCondition        
            oracle.add(69);   //MentalHealth        
            oracle.add(69);   //Needs        
            oracle.add(69);   //Sleep        
            oracle.add(0);    //ID
        try {
            Thread.sleep(3001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> new_data = tama.getAllData();
        assertEquals(oracle, new_data);
    }

    @Test
    public void death()
    {
        engine = Engine.createEngineInstance(null, "TamaChat", "testcat");
        assertFalse(engine.isDead());
        engine.getTamagotchi().setHealth(0);
        assertTrue(engine.isDead());
    }
    
    @Test
    public void saveLoad()
    {
        engine = Engine.createEngineInstance(null, "TamaChat", "testcat");
        ArrayList<Integer> before_save = engine.getTamagotchi().getAllData();
        engine.quit();
        engine = Engine.loadSave(null, "testcat");
        ArrayList<Integer> after_save = engine.getTamagotchi().getAllData();
        assertEquals(before_save, after_save);
    }

    @AfterEach
    public void reset()
    {
        engine.quit();
    }
}
