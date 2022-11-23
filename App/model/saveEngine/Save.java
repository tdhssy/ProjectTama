package model.saveEngine;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//test
public class Save {

    final static private String SAVEPATH = "save/";
    
    static private File newSaveFile; 

    public static void makeSave(ArrayList<Integer> datas, String instanceName) throws IOException {

        PrintWriter fichier = new PrintWriter(new FileOutputStream(SAVEPATH+instanceName+".txt"),true);

        for (Integer value : datas) {
            fichier.printf("%d\n",value);
        }
       fichier.close();
        
        
    }
    
    public static ArrayList<Integer> loadSave(String instanceName) {
        //TODO
        return null;
    }

    public static boolean saveExist(String instanceName){
        //TODO
        return false;
    }
}
