public class Ressources {
    
    //TODO
    public enum SAVE_PATH {
        //Chemin des sauvegardes
    }
    public enum TAMAGOTCHI_TEXTURE_PATH {
        //Chemin des textures des tamagotchis
    }
    public enum BACKGROUND_TEXTURE_PATH {
        //Chemin des textures des arrières plan
    }

    //Variable contenant les ressources
    private SAVE_PATH s_PATH;
    private TAMAGOTCHI_TEXTURE_PATH tamaTexture_PATH;
    private BACKGROUND_TEXTURE_PATH bgTexture_PATH;

    //Getter et setter de SAVE_PATH
    public void setS_PATH(SAVE_PATH s_PATH) {
        this.s_PATH = s_PATH;
    }
    public SAVE_PATH getS_PATH() {
        return s_PATH;
    }

    //getter de BACKGROUND_TEXTURE_PATH
    public BACKGROUND_TEXTURE_PATH getBgTexture_PATH() {
        return bgTexture_PATH;
    }

    //getter de TAMAGOTCHI_TEXTURE_PATH
    public TAMAGOTCHI_TEXTURE_PATH getTamaTexture_PATH() {
        return tamaTexture_PATH;
    }

}
