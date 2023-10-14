public class Display {

    public void mainMenu(){
        System.out.println("[1] View Inventory");
        System.out.println("[2] Explore an Area");
        System.out.println("[3] Evolve Creature");
        System.out.println("[4] Exit");
    }

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
