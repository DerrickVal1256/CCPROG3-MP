/**
* This class provides methods for displaying various game menus.
*/
public class Display {

    /**
    * Displays the main menu.
    */
    public void mainMenu(){
        System.out.println("\t\t\t************************************");
        System.out.println("\t\t\t|            Main Menu             |");
        System.out.println("\t\t\t|                                  |");
        System.out.println("\t\t\t|        [1] View Inventory        |");
        System.out.println("\t\t\t|        [2] Explore an Area       |");
        System.out.println("\t\t\t|        [3] Evolve Creature       |");
        System.out.println("\t\t\t|        [4] Exit                  |");
        System.out.println("\t\t\t|                                  |");
        System.out.println("\t\t\t************************************");
    }

    /**
    * Displays the starter creature selection menu.
    */
    public void starterPokemon(){
        System.out.println("\t\t\t**********************************");
        System.out.println("\t\t\t|      Choose your starter!      |");
        System.out.println("\t\t\t|                                |");
        System.out.println("\t\t\t|         [1] Strawander         |");
        System.out.println("\t\t\t|         [2] Brownisaur         |");
        System.out.println("\t\t\t|         [3] Squirpie           |");
        System.out.println("\t\t\t|                                |");
        System.out.println("\t\t\t**********************************");
    }

    /**
    * Displays the area selection menu.
    */
    public void areas(){
        System.out.println("\t\t\t+-------------------+");
        System.out.println("\t\t\t|       Areas       |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t|        [1]        |");
        System.out.println("\t\t\t|        [2]        |");
        System.out.println("\t\t\t|        [3]        |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t+-------------------+");
    }

    /**
    * Displays the movement options.
    */
    public void movement() {
        System.out.println("\t\t\t+-------------------+");
        System.out.println("\t\t\t|       Move        |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t|    [1] Up         |");
        System.out.println("\t\t\t|    [2] Down       |");
        System.out.println("\t\t\t|    [3] Left       |");
        System.out.println("\t\t\t|    [4] Right      |");
        System.out.println("\t\t\t|    [5] Leave      |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t+-------------------+");
    }

    /**
    * Displays the battle menu.
    */
    public void battleMenu(){
        System.out.println("\t\t\t+-------------------+");
        System.out.println("\t\t\t|      Actions      |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t|   [1] Attack      |");
        System.out.println("\t\t\t|   [2] Swap        |");
        System.out.println("\t\t\t|   [3] Catch       |");
        System.out.println("\t\t\t|   [4] Run Away    |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t+-------------------+");
    }

    /**
    * Displays the start game prompt.
    * @param nInput The user's choice.
    * @throws Exception If there is an error during the display.
    */
    public void startDisplay(int nInput) throws Exception{
        do{
            System.out.println("Would you like to start your journey?");
            System.out.println("[1] Yes");
            Thread.sleep(2000); 
            System.out.flush();  
            System.out.print("\033[H\033[2J"); 
        }while(nInput != 1);
    }

}
