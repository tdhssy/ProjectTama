package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import model.Engine;
import model.tamaEngine.Tamagotchi;


public class TamaTest {

    static private Engine engine;

    @Test
    public void test()
    {
        assertTrue(true);
    }

    @Test
    public void creationEngine()
    {
        engine = Engine.createEngineInstance(null, "Chien", "testdog");
        assertEquals("testdog", engine.getInstanceName());
    }

    @Test
    public void changeRoom()
    {
        engine = Engine.createEngineInstance(null, "chien", "testdog");
        engine.setCurrentRoom("garden");
        assertEquals("garden", engine.getCurrentRoom());
    }

    @Test
    public void statsTama()
    {
        engine = Engine.createEngineInstance(null, "Chat", "testcat");
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
        assertEquals(oracle, tama.getAllData());
    }

    @AfterEach
    public void reset()
    {
        engine.unloadEngine();
    }
}
