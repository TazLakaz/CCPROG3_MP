import java.util.Scanner;

/**
 * Main Driver Program
 */

public class Main {
    public static void main(String[] args) {
            FactoryGUI gui = new FactoryGUI();
            Scanner s = new Scanner(System.in);

            RegularVM regularVM = null;
            SpecialVM specialVM = null;

            int choice = 0;
            int choice2;

            while (choice != 3){
                System.out.println("-----------------------------------------------------------------");
                System.out.print("Active Vending Machines:");
                if (regularVM != null){
                    System.out.println ("Regular Vending Machine.\n\n");
                }
                else if (specialVM != null){
                    System.out.println ("Special Vending Machine.\n\n");
                }
                else {
                    System.out.println ("No Vending Machines Active\n\n");
                }

                displayMenu();
                System.out.print("Enter input: ");
                choice = s.nextInt();
                s.nextLine();

                if (choice == 1){
                    vendingDisplay();
                    System.out.println ("Enter input: ");
                    choice2 =s.nextInt();
                    s.nextLine();
                    if (choice2 == 1){
                         regularVM = new RegularVM();
                         specialVM =null;
                        System.out.println("---------------------- BUILD SUCCESSFUL! ----------------------");
                    }
                    else if (choice2 == 2){
                         specialVM = new SpecialVM();
                         regularVM =null;
                    }
                    else if (choice2 == 3 ){
                        System.out.println(" ");
                    }
                    else{
                        System.out.println ("Invalid Input. Returning to Menu");
                    }

                } else if (choice == 2){
                    testMachine(s, regularVM != null ? regularVM : specialVM);
                } else if (choice == 3){
                    System.out.println("---------------------- PROGRAM TERMINATED -----------------------");
                    System.out.println("------------------ THANK YOU FOR USING OUR VM! ------------------");


                } else {
                    System.out.println("Invalid choice. Please try again.");
                }


            }

    }

    /**
     * Displays text of the first menu.
     */
    public static void displayMenu() {
        System.out.println("------------------- VENDING MACHINE GENERATOR -------------------");
        System.out.println("1. Make Vending Machine");
        System.out.println("2. Test Vending Machine");
        System.out.println("3. Exit Program");
        System.out.println("-----------------------------------------------------------------");
    }


    /**
     * Displays text when creating the Vending Machine
     */

    public static void vendingDisplay(){
        System.out.println("------------------- VENDING MACHINE GENERATOR -------------------");
        System.out.println("1. Regular Vending Machine");
        System.out.println("2. Special Vending Machine");
        System.out.println("3. Return to Menu)");
        System.out.println("-----------------------------------------------------------------");
    }


    /**
     * Displays text when testing the Active Machine
     */
    public static void testMachineDisplay(){
        System.out.println("------------------- TESTING VENDING MACHINE -------------------");
        System.out.println("1. Display Current Number of Items per Slot");
        System.out.println("2. Make a Purchase");
        System.out.println("3. Restock Items");
        System.out.println("4. Print Current Machine Bills");
        System.out.println("5. Replenish Money");
        System.out.println("6. Collect Money");
        System.out.println("7. Update Item Price");
        System.out.println("8. Print Transaction History");
        System.out.println("9. Exit");
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * Tests the active Vending Machine.
     *
     * @param s             Scanner object for input
     * @param activeMachine The active Vending Machine to be tested
     */
    public static void testMachine(Scanner s, VendingMachine activeMachine) {
        if (activeMachine == null) {
            System.out.println("------------------ ERROR NO ACTIVE MACHINE ------------------");
            return;
        }

        testMachineDisplay();
        int choice = 0;

        while (choice != 9) {
            testMachineDisplay();
            System.out.print("Enter input: ");
            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1 -> activeMachine.displayItemsPerSlot();
                case 2 -> {
                    activeMachine.displayItemsPerSlot();
                    System.out.println("\n\n");
                    activeMachine.purchase();
                }
                case 3 -> activeMachine.Restock();
                case 4 -> activeMachine.displayCurrentBills();
                case 5 -> activeMachine.replenishMoney();
                case 6 -> activeMachine.collectMoney();
                case 7 -> activeMachine.updatePrice(s);
                case 8 -> activeMachine.transactionHistory();
                case 9 -> System.out.println("Exiting testing...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }






}