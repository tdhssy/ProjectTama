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
     * 
     * Toutes les couleurs disponible :
     * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
     */
    private static final String RESET = "\033[0m";      // Text Reset
    private static final String RED = "\033[0;91m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN

    Controller control; //Permet l'accès au méthodes du controller

    /*
     * Permet de lancé tout les tests
     */
    public void startTest()
    {
        System.out.println("DEBUT DE LA SÉRIE DE TEST");
        System.out.println("-------------------------");
        
        testCouleur();
        testUniciteController();
        //.
        //.
        //.

        System.out.println(RESET + "-------------------------");
    }

    /*
     * Test des différentes couleurs de font
     */
    private void testCouleur()
    {
        System.out.println(RESET + "Test couleur : "
                         + GREEN + "Vert" + RESET + ", "
                         + RED + "Rouge" + RESET + ", "
                         + RESET + "Normal");
    }

    /*
     * Test de l'unicité du controller
     */
    private void testUniciteController()
    {
        System.out.print(RESET + "Test unicité du controller : ");
        try {
            control = Controller.getController();
            Controller test_singleton = Controller.getController();
            if(control != test_singleton) throw new Exception();

            System.out.println(GREEN + "OK");
        } catch (Exception e) {
            System.out.println(RED + "FAILED");
        }
    }
}
