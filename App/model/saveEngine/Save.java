package model.saveEngine;


import java.io.BufferedReader;//add
import java.io.File;//add
import java.io.FileInputStream;//add
import java.io.InputStream;//add
import java.io.InputStreamReader;//add
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//test du meilleur et du plus beau avec l'aide du plus intelligent c fo
public class Save {

    final static private String SAVEPATH = "save/";
    
    /**
     * Création du fichier de sauvegarde ou bien update d'une déjà existante
     * @return void
     * @param Arralist<Integer> datas : les informations du personnages
     * @param String instanceName : le nom du persnnage
     * 
     */
    public static void makeSave(ArrayList<Integer> datas, String instanceName) throws IOException {

        PrintWriter fichier = new PrintWriter(new FileOutputStream(SAVEPATH+instanceName+".txt"),true);

        for (Integer value : datas) {
            fichier.printf("%d\n",value);
        }
       fichier.close();
        
        
    }
    
    /**
     * Permet d'envoyer les données du fichier de sauvegarde au tamagotchi
     * @return les datas pour le tama
     * @param instanceName : le nom du personnage
     */
    public static ArrayList<Integer> loadSave(String instanceName) {
        ArrayList<Integer> datas = new ArrayList<>();
        String fichier=SAVEPATH+instanceName+".txt";
        int valueInTheLigne;
        try{
            if(saveExist(instanceName)){
                InputStream ips=new FileInputStream(fichier); 
                InputStreamReader ipsr=new InputStreamReader(ips);
                BufferedReader br=new BufferedReader(ipsr);
                String ligne;

                while ((ligne=br.readLine())!=null){
                    valueInTheLigne=Integer.parseInt(ligne);
                    datas.add(valueInTheLigne);
                }
                br.close();
                if(datas.size()!=7){
                    System.out.println("Probleme dans le dossier de sauvegarde, dosser manquant");
                    return null;
                }
                
                for(int data : datas){
                    System.out.println(data);
                }
            }
            else{
                System.out.println("Le fichier n'existe pas,impossible de charger les données");
                return null;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return datas;
        /*Pas faire attention, version alternative du code ci-dessus
            if(!saveExist(instanceName)) throw new FileNotFoundException();
            InputStream ips=new FileInputStream(fichier); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;

            while ((ligne=br.readLine())!=null){
                valueInTheLigne=Integer.parseInt(ligne);
                datas.add(valueInTheLigne);
            }
            br.close();
            if(datas.size()!=7){
                System.out.println("Probleme dans le dossier de sauvegarde, donnée(s) manquante(s)");
                return null;
            }
            
            for(int data : datas){
                System.out.println(data);
            }
            */
    }

    /**
     * Permet de savoir si un fichier existe déjà dans le répertoire save
     * @return boolean
     * @param String instanceName : le nom du personnage
     */
    public static boolean saveExist(String instanceName)throws FileNotFoundException{
        File file = new File(SAVEPATH+instanceName+".txt");
        if(file.exists()){
            //System.out.println("Le fichier existe bien");
            return true;
        }
        //System.out.println("Le fichier n'existe pas");
        return false;
    }

    /**
     * Permet de supprimer un fichier de sauvegarde
     * @return void
     * @param String instanceName : le nom du personnage (celui de l'instance)
     */
    public static void deleteSave(String instanceName)throws FileNotFoundException{
        System.out.println("Suppresion du fichier de sauvegarde de "+instanceName);//add par clement
        File file = new File(SAVEPATH+instanceName+".txt");
        file.delete();
        System.out.println("Le fichier "+instanceName+" a bien été supprimé ? "+!saveExist(instanceName));
        
    }

}
