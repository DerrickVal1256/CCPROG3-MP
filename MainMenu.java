import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println();

            System.out.println("[1] View Inventory");
            System.out.println("[2] Explore an Area");
            System.out.println("[3] Evolve Creature");
            System.out.println("[4] Exit");
            System.out.print("Main Menu: ");
    
            int nChoice = scanner.nextInt(); 
            System.out.println();

            switch(nChoice) {
                case 1:
                    System.out.println("");
            } 
        }    
    }
}