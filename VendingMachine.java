import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Base Vending Machine class
 */
public class VendingMachine {
    protected  ArrayList<Slots> slotList;
    protected  List<Integer> machineBills;
    protected  ArrayList<TransactionHistory> history ;
    Item[] itemsPerSlot = {
            new Item(208, 70, "Vanilla Yogurt"),
            new Item(254, 80, "Chocolate Yogurt"),
            new Item(255, 80, "Strawberry Yogurt"),
            new Item(11, 10, "Choco Dip"),
            new Item(10, 10, "Strawberry Dip"),
            new Item(24, 15, "Crushed Oreo"),
            new Item(4, 5, "Sprinkles"),
            new Item(18, 10, "Chopped Nuts"),
            new Item(9, 10, "Macha"),
            new Item(7, 10, "Graham")
    };

    /**
     * Constructor for the VendingMachine class.
     * Initializes the vending machine with empty slots and adds default items.
     */

    public VendingMachine() {
        machineBills = new ArrayList<>();
        slotList = new ArrayList<>();
        history = new ArrayList<>();

        int i;
        for (i = 0; i < 10; i++) {
            slotList.add(new Slots());
        }

        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                slotList.get(j).insertItem(itemsPerSlot[j]);
            }
        }
    }

    /**
     * Displays the items and their details in each slot of the vending machine.
     */

    public void displayItemsPerSlot() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Item # | Item Quantity | Item Name              | Price | Calories");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < slotList.size(); i++) {
            Slots slot = slotList.get(i);
            ArrayList<Item> items = slot.getSlotItems();
            int quantity = items.size();

            if (quantity > 0) {
                Item item = items.get(0);
                String itemName = item.name;
                double price = item.price;
                int calories = item.calories;

                System.out.printf("%-4d | %-13d | %-23s | $%.2f | %d\n", i + 1, quantity, itemName, price, calories);
            } else {
                System.out.printf("%-4d | %-13d | %-23s | $%.2f | %d\n", i + 1, 0, "Empty Slot", 0.0, 0);
            }
        }
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * Handles the purchase transaction from the vending machine.
     */
    public void purchase(){
        System.out.println("------------------- PURCHASING FROM VENDING MACHINE -------------------");
        List<Integer> userDenominations = new ArrayList<>();

        Scanner s = new Scanner(System.in);

        boolean isTransactionSuccessful = false;

        int j = 0;

        do {
            j++;
            if (j == 1) {
                System.out.print("Enter bill denomination (Type CANCEL to cancel transaction, or DONE if finished inputting bills): ");
                System.out.println();
            }
            String input = s.nextLine();

            if (input.equalsIgnoreCase("CANCEL")) {
                System.out.println("Transaction canceled. Exiting...");
                break;
            } else if (input.equalsIgnoreCase("DONE")) {
                if (userDenominations.isEmpty()) {
                    System.out.println("No bill denominations entered. Please input at least one bill denomination.");
                } else {
                    isTransactionSuccessful = true;
                    break;
                }
            } else {
                try {
                    int bill = Integer.parseInt(input);
                    if (bill > 0 && !isValidDenomination(bill)) {
                        System.out.println("Invalid Input! Input not found in Philippine denomination system.");
                    } else {
                        userDenominations.add(bill);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input! Please enter a valid bill denomination or type 'CANCEL' to cancel or 'DONE' to finish.");
                }
            }
        } while (true);

        if (isTransactionSuccessful) {
            int choice;
            int totalUserMoney = 0;
            double change;
            double productPrice = 0;
            List<Integer> changeDenominations = new ArrayList<>();

            System.out.println("\n\nEnter Product Number: ");
            choice = s.nextInt();
            s.nextLine();
            Slots selectedSlot = slotList.get(choice - 1);
            if (choice >= 1 && choice <= slotList.size()) {

                ArrayList<Item> itemsInSlot = selectedSlot.getSlotItems();
                if (itemsInSlot.size() > 0) {
                     productPrice = itemsInSlot.get(0).price;
                } else {
                    System.out.println("Item Currently Out of Stock.");
                }
            } else {
                System.out.println("Invalid product choice.");
            }


            for (Integer userDenomination : userDenominations) {
                totalUserMoney += userDenomination;
            }


            if (totalUserMoney >= productPrice) {





                change = totalUserMoney - productPrice;
                double changeCopy =change;
                if (change > 0) {
                    int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
                    for (int denomination : denominations) {

                        int numDenominationAvailable = countDenomination(denomination);
                        while (change >= denomination && numDenominationAvailable > 0) {
                            int index = -1;
                            for (j = 0; j < machineBills.size(); j++) {
                                if (machineBills.get(j) == denomination) {
                                    index = j;
                                    break;
                                }
                            }
                            if (index != -1) {
                                changeDenominations.add(denomination);
                                change -= denomination;
                                numDenominationAvailable--;
                                machineBills.remove(index);
                            }
                        }
                    }
                }

                if (change == 0) {
                    TransactionHistory tHistory = new TransactionHistory(choice,totalUserMoney,changeCopy);
                    addtHistory(tHistory);

                    System.out.println("Transaction successful. Enjoy your " + selectedSlot.getItemName() + "!");

                    // Delete the item from the slot

                    selectedSlot.removeItem(0);

                    for (int denomination : userDenominations) {
                        machineBills.add(denomination);
                    }


                    // Print the breakdown of denominations for the change
                    System.out.println("Change breakdown:");
                    for (Integer changeDenomination : changeDenominations) {
                        System.out.println(changeDenomination);
                    }
                } else {
                    System.out.println("Insufficient bills to provide change. Transaction canceled.");
                }
            } else {
                System.out.println("Insufficient funds. Transaction canceled.");
            }
        }
    }

    /**
     * Checks if the given bill denomination is a valid Philippine denomination.
     *
     * @param bill The bill denomination to check.
     * @return True if the bill is a valid denomination in the Philippine Currency, otherwise false.
     */
    public boolean isValidDenomination(int bill) {
        int[] validDenominations = {1, 5, 10, 20, 50, 100, 200, 500, 1000};
        for (int denomination : validDenominations) {
            if (denomination == bill) {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts the number of occurrences of a given denomination in the vending machine's bills.
     *
     * @param denominationValue The denomination value to count occurrences for.
     * @return The count of occurrences of the given denomination.
     */

    public int countDenomination(int denominationValue){
        int count =0;
        for (Integer machineBill : machineBills) {
            if (denominationValue == machineBill)
                count++;
        }
        return count;
    }

    /**
     * Adds a transaction record to the vending machine's transaction history.
     *
     * @param t_history The TransactionHistory object representing the transaction.
     */


    public void addtHistory(TransactionHistory t_history){
        history.add(t_history);
    }


    /**
     * Displays the current bills and their quantities inside the vending machine.
     */
    public void displayCurrentBills() {
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

        System.out.println("Current Bills in Vending Machine:");
        System.out.println("---------------------------------");
        System.out.println("Denomination\t|\tQuantity");
        System.out.println("---------------------------------");

        for (int denomination : denominations) {
            int count = 0;
            for (Integer machineBill : machineBills) {
                if (denomination == machineBill)
                    count++;
            }
            String denominationText = denomination + " Bills";
            if (denomination == 5 || denomination == 1) {
                denominationText += "\t\t";
            } else {
                denominationText += "\t";
            }
            System.out.println(denominationText + "|\tx" + count);
        }

        System.out.println("---------------------------------");
    }

    /**
     * Restocks all slots in the vending machine up to their maximum capacity.
     * Adds new items if slots are empty or insufficient.
     */

    public void Restock() {
        for (int i = 0; i < 10; i++) {
            int count = slotList.get(i).getSlotItems().size();
            if (count < 10) {
                while (count < 10) {
                    // Retrieve the details of the item from the itemsPerSlot array
                    Item itemToRestock = itemsPerSlot[i];
                    int calories = itemToRestock.calories;
                    double price = itemToRestock.price;
                    String name = itemToRestock.name;

                    // Create a new Item instance and add it to the slot
                    Item newItem = new Item(calories, price, name);
                    slotList.get(i).insertItem(newItem);

                    count++;
                }
            }

        }
        TransactionHistory tHistory = new TransactionHistory("Restock");
        addtHistory(tHistory);
    }

    /**
     * Replenishes the vending machine's money by adding new bills for each denomination.
     */
    public void replenishMoney(){
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

        for (int denomination : denominations) {
            for (int i = 0; i < 5; i++) {
                machineBills.add(denomination);
            }
        }
        TransactionHistory tHistory = new TransactionHistory("Replenish");
        addtHistory(tHistory);
    }

    /**
     * Collects all the money currently inside the vending machine and displays the total amount.
     */

    public void collectMoney(){
        double totalMoney = 0;

        for (double bill : machineBills) {
            totalMoney += bill;
        }

        machineBills.clear();

        System.out.println("Total money collected: " + totalMoney);

        TransactionHistory tHistory;
        tHistory = new TransactionHistory("Collect", totalMoney);
        addtHistory(tHistory);
    }

    /**
     * Updates the price of an item in a specific slot of the vending machine.
     *
     * @param s The Scanner object to read user input.
     */
    public void updatePrice(Scanner s) {
        displayItemsPerSlot();
        System.out.println("What item will you update the price?");
        int choice = s.nextInt();
        s.nextLine(); // Consume the newline character after reading the integer

        if (choice >= 1 && choice <= slotList.size()) {
            int slotIndex = choice - 1;
            Slots slotChoice = slotList.get(slotIndex);

            // Retrieve the selected item in the slot
            ArrayList<Item> itemsInSlot = slotChoice.getSlotItems();
            if (!itemsInSlot.isEmpty()) {
                Item selectedItem = itemsInSlot.get(0);
                String itemName = selectedItem.getName();

                // Display the current price of the selected item
                double currentPrice = selectedItem.getPrice();
                System.out.println("Current price of " + itemName + ": $" + currentPrice);

                // Prompt user for the new price
                System.out.print("Enter the new price for " + itemName + ": $");
                double newPrice = s.nextDouble();
                s.nextLine(); // Consume the newline character after reading the double

                // Update the price of the selected item in itemsPerSlot array
                itemsPerSlot[slotIndex].setPrice(newPrice);

                // Overwrite the existing items in the slot with the new price
                for (int i = 0; i < itemsInSlot.size(); i++) {
                    itemsInSlot.get(i).setPrice(newPrice);
                }

                System.out.println("Price of " + itemName + " updated to $" + newPrice);
            } else {
                System.out.println("Slot " + choice + " is empty. Please select a different slot.");
            }
        } else {
            System.out.println("Invalid slot choice. Please try again.");
        }
    }

    /**
     * Displays the transaction history of the vending machine.
     */

    public void transactionHistory() {
        System.out.println("-- Transaction History --");

        // Variables to keep track of the sums for "Purchase" transactions
        double totalMoneyBeforeRestocking = 0;



        // Loop through the transaction history
        for (int i = 0; i < history.size(); i++) {
            TransactionHistory transaction = history.get(i);

            switch (transaction.getTransactionType()) {
                case "Purchase" -> {
                    // Print the name, money in, and money dispensed for the purchase transaction
                    String itemName = itemsPerSlot[transaction.getItemINDEX() - 1].getName();
                    double moneyIn = transaction.getMoneyIN();
                    double moneyDispensed = transaction.getAmountDispensed();
                    System.out.println("Name: " + itemName);
                    System.out.println("Money In: $" + moneyIn);
                    System.out.println("Money Dispensed: $" + moneyDispensed);

                    // Update the totals for "Purchase" transactions
                    totalMoneyBeforeRestocking += moneyIn;
                }
                case "Replenish" ->
                        System.out.println("-- Money Replenished, Money Cashed in: $" + transaction.getMoneyIN() + " --");
                case "Collect" ->
                        System.out.println("-- Money Collected, Money Collected: $" + transaction.getAmountDispensed() + " --");
                case "Restock" -> {
                    System.out.println("Total money before restocking: $" + totalMoneyBeforeRestocking);
                    System.out.println("-- Restocked --");
                    totalMoneyBeforeRestocking = 0; // Reset the total before restocking
                }
            }
        }
        System.out.println("-- End of Transaction History --");
    }

}
