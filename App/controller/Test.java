package controller;

/*
 * Classe de test pour l'application.
 * Teste l'intégration des fonctionalitées
 * et l'ensemble des classes.
 */
public class Test 
{
    /*
     * Couleur de font des messages sur la console.
     * --> Peux ne pas marcher sur Windows
     */
    private static final String RESET = "\033[0m";  // Text Reset
    private static final String RED = "\033[0;31m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN

    /*
     * Permet de lancé tout les testes
     */
    public void startTest()
    {
        System.out.println("DEBUT DE LA SÉRIE DE TESTE :");
        
        testCouleur();
        //.
        //.
        //.
    }

    private void testCouleur()
    {
        System.out.println(GREEN + "Vert");
        System.out.println(RED + "Rouge");
        System.out.println(RESET + "Normal");
    }
}
