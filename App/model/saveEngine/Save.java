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
<<<<<<< HEAD

=======
//test du meilleur et du plus beau avec l'aide du plus intelligent c fo ohoh
>>>>>>> 5eddffc (Ajout de le méthode getAllSaveName)
public class Save {

    final static private String SAVEPATH = "save/";
    
    /**
     * Création du fichier de sauvegarde ou bien update d'une déjà existante
     * @return void
     * @param Arralist<Integer> datas : les informations du personnages
     * @param String instanceName : le nom du personnage
     * 
     */
    public static boolean makeSave(ArrayList<Integer> datas, String instanceName) {
        boolean fileCreate = false;
        try (PrintWriter fichier = new PrintWriter(new FileOutputStream(SAVEPATH+instanceName+".txt"),true)) {

            for (Integer value : datas) {
                fichier.printf("%d\n",value);
            }
            fileCreate=true;
        } catch (FileNotFoundException e) { //repertoir non trouver

            e.printStackTrace();
            new File(SAVEPATH).mkdir();
            makeSave(datas, instanceName);
        }
        return fileCreate;
        
    }
    
    /**
     * Permet d'envoyer les données du fichier de sauvegarde au tamagotchi
     * @return les datas pour le tama
     * @param instanceName : le nom du personnage
     * @throws IOException
     */
    public static ArrayList<Integer> loadSave(String instanceName) throws IOException {
        ArrayList<Integer> datas = new ArrayList<>();
        String fichier=SAVEPATH+instanceName+".txt";
        int valueInTheLigne;
 

<<<<<<< HEAD
        InputStream ips=new FileInputStream(fichier); 
        InputStreamReader ipsr=new InputStreamReader(ips);
        BufferedReader br=new BufferedReader(ipsr);
        String ligne;
=======
                while ((ligne=br.readLine())!=null){
                    valueInTheLigne=Integer.parseInt(ligne);
                    datas.add(valueInTheLigne);
                }
                br.close();
                if(datas.size()!=8){
                    System.out.println("Probleme dans le dossier de sauvegarde, donnée(s) manquante(s)");
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
>>>>>>> 5eddffc (Ajout de le méthode getAllSaveName)

        while ((ligne=br.readLine())!=null){
            valueInTheLigne=Integer.parseInt(ligne);
            datas.add(valueInTheLigne);
        }
        br.close();

        if(datas.size()!=8){
            throw new IOException("Donnée manquante dans le fichier "+instanceName+".txt");
        }
        
        /*for(int data : datas){
            System.out.println(data);
        }*/
            
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
    public static boolean saveExist(String instanceName){
        File file = new File(SAVEPATH+instanceName+".txt");
        return file.exists();
    }

    /**
     * Permet de supprimer un fichier de sauvegarde
     * @return void
     * @param String instanceName : le nom du personnage (celui de l'instance)
     * @throws FileNotFoundException
     */
    public static boolean deleteSave(String instanceName){
        //System.out.println("Suppresion du fichier de sauvegarde de "+instanceName);//add par clement
        File file = new File(SAVEPATH+instanceName+".txt");
        boolean checkFile;

        if(saveExist(instanceName)){
            file.delete();
            checkFile = true;
        }else{
            checkFile = false;
        }
        return checkFile;
        //System.out.println("Le fichier "+instanceName+" a bien été supprimé ? "+!saveExist(instanceName));
        
    }

    /**
     * Permet de connaitre le nom de chaque fichier de sauvegarde
     * @return ArrayList<String> : le nom de chaque sauvegarde (juste leur instance)
     *                              Si pas de sauvegarde return "Il n'y a pas de sauvegarde"
     * 
     */
    public static ArrayList<String> getAllSaveName() throws IOException{
        final File repertoire = new File(SAVEPATH);
        ArrayList<String> Names = new ArrayList<>();
        int cptFile=0;
        
        for(final File actualFile:repertoire.listFiles()){
            cptFile++;
            String tmpSaveName = actualFile.getName();
            final String saveName=tmpSaveName.substring(0, tmpSaveName.length()-4);
            Names.add(saveName);
        }
        if (cptFile==0 || cptFile>5 ){
            Names= new ArrayList<>();
            Names.add("Il n'y a pas sauvegarde");
        }
        return Names;
    }

}
