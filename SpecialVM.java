import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialVM extends VendingMachine {

    private int[] slotItemCount;

    /**
     * Constructor for the Special Vending Machine.
     */
    public SpecialVM() {


        super();
        slotItemCount = new int[slotList.size()];

    }




    Item[] specialItemsData = {
            new Item(759, 255, "Yogurt Parfait"),
            new Item(300, 115, "Choco-Dipped Strawberry Yogurt Bowl"),
            new Item(259, 105, "Macha Yogurt Smoothie"),
            new Item(473, 165, "Graham Cracker Yogurt Parfait"),
            new Item(307, 115, "Choco-Nut Yogurt Sundae"),
    };


    /**
     * Displays the special items available in the vending machine along with their prices and calories.
     */
    @Override
    public void displayItemsPerSlot() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Special Items Menu:");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < specialItemsData.length; i++) {
            Item item = specialItemsData[i];
            String itemName = item.getName();
            double price = item.getPrice();
            int calories = item.getCalories();

            System.out.printf("%-4d | %-42s | $%.2f | %d cal\n", i + 1, itemName, price, calories);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * Processes the purchase of an item from the vending machine.
     */

    @Override
    public void purchase() {
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
            double change = 0;
            double productPrice = 0;
            List<Integer> changeDenominations = new ArrayList<>();

            System.out.println("\n\nEnter Product Number: ");
            choice = s.nextInt();
            s.nextLine(); // Consume the newline character
            if (choice >= 1 && choice <= specialItemsData.length) {


                Item selectedSpecialItem = specialItemsData[choice - 1];
                if (checkStock(choice-1)==true){
                    productPrice =specialItemsData[choice - 1].getPrice();
                }
                else{
                    System.out.println("No stock available");
                }

            } else {
                System.out.println("Invalid product choice.");
            }

            for (int i = 0; i < userDenominations.size(); i++) {
                totalUserMoney += userDenominations.get(i);
            }


            if (totalUserMoney >= productPrice) {

                change = totalUserMoney - productPrice;
                double changeCopy =change;
                if (change > 0) {
                    int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
                    for (int i = 0; i < denominations.length; i++) {

                        int denomination = denominations[i];
                        int numDenominationAvailable = countDenomination(denomination);
                        while (change >= denomination && numDenominationAvailable > 0) {
                            int index = -1;
                            for ( j = 0; j < machineBills.size(); j++) {
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
                    //for later
                    TransactionHistory tHistory = new TransactionHistory(choice,totalUserMoney,changeCopy);
                    addtHistory(tHistory);

                    //TODO GENERATE THE TEXT MESSAGE

                    textmessage(choice-1);

                    // Delete the item from the slot
                    removeItems(choice-1);

                    for (int denomination : userDenominations) {
                        machineBills.add(denomination);
                    }


                    // Print the breakdown of denominations for the change
                    System.out.println("Change breakdown:");
                    for (int i = 0; i < changeDenominations.size(); i++) {
                        System.out.println(changeDenominations.get(i));
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
     * Checks if there is enough stock for the selected item.
     *
     * @param choice The choice of the selected item.
     * @return True if there is enough stock, otherwise False.
     */

    public boolean checkStock (int choice){
        for (int i = 0; i < slotList.size(); i++) {
            Slots slot = slotList.get(i);
            ArrayList<Item> items = slot.getSlotItems();
            slotItemCount[i] = items.size();
        }

        if (choice == 1){
            if (slotItemCount[0]!=0 &&slotItemCount[2]!=0 && slotItemCount[1]!=0 &&slotItemCount[5]!=0 && slotItemCount[7]!=0 ){
                return true;
            }
            else
                return false;
        }
        else if (choice == 2){
            if (slotItemCount[2]!=0 &&slotItemCount[3]!=0 && slotItemCount[4]!=0 &&slotItemCount[5]!=0){
                return true;
            }
            else
                return false;

        }
        else if (choice ==3){
            if (slotItemCount[0]!=0 &&slotItemCount[8]!=0 && slotItemCount[5]!=0 &&slotItemCount[7]!=0){
                return true;
            }
            else
                return false;
        }
        else if (choice == 4){
            if (slotItemCount[0]!=0 &&slotItemCount[1]!=0 && slotItemCount[9]!=0 &&slotItemCount[6]!=0){
                return true;
            }
            else
                return false;
        }
        else if (choice == 5){
            if (slotItemCount[1]!=0 &&slotItemCount[5]!=0 && slotItemCount[3]!=0 &&slotItemCount[7]!=0){
                return true;
            }
            else
                return false;
        }
        else{
            System.out.println ("Invalid Item Number");
            return false;
        }

    }

    /**
     * Displays a text message based on the choice of the purchased item.
     *
     * @param choice The choice of the purchased item.
     */


    public void textmessage(int choice){
        if (choice == 0){
            System.out.println("Layering vanilla, strawberry, and chocolate yogurt in a cup...");
            System.out.println("Sprinkling crushed Oreos...");
            System.out.println("Putting chopped nuts on top...");
            System.out.println("Finishing touches...");
            System.out.println("Serve and Enjoy!");

        }
        else if (choice == 1){
            System.out.println("Dispensing strawberry into a cup...");
            System.out.println("Pouring chocolate and strawberry dip...");
            System.out.println("Sprinkling crushed Oreos...");
            System.out.println("Finishing touches...");
            System.out.println("Serve and Enjoy!");


        }
        else if (choice == 2){
            System.out.println("Dispensing vanilla into a cup...");
            System.out.println("Sprinkling macha and crushed Oreos...");
            System.out.println("Putting chopped nuts on top...");
            System.out.println("Finishing touches...");
            System.out.println("Serve and Enjoy!");

        }
        else if (choice == 3){
            System.out.println("Layering vanilla and chocolate yogurt in a cup...");
            System.out.println("Adding graham on the sides...");
            System.out.println("Sprinkling sprinkles on top...");
            System.out.println("Finishing touches...");
            System.out.println("Serve and Enjoy!");

        }
        else if (choice == 4){

            System.out.println("Dispensing chocolate into a cup...");
            System.out.println("Sprinkling crushed Oreos...");
            System.out.println("Pouring chocolate dip...");
            System.out.println("Putting chopped nuts on top...");
            System.out.println("Finishing touches...");
            System.out.println("Serve and Enjoy!");

        }

    }

    /**
     * Removes the purchased item from the vending machine slot.
     *
     * @param choice The choice of the purchased item.
     */

    public void removeItems(int choice) {
        if (choice == 0) {
            slotList.get(0).removeItem(0);
            slotList.get(2).removeItem(0);
            slotList.get(1).removeItem(0);
            slotList.get(5).removeItem(0);
            slotList.get(7).removeItem(0);
        } else if (choice == 1) {
            slotList.get(2).removeItem(0);
            slotList.get(3).removeItem(0);
            slotList.get(4).removeItem(0);
            slotList.get(5).removeItem(0);
        } else if (choice == 2) {
            slotList.get(0).removeItem(0);
            slotList.get(8).removeItem(0);
            slotList.get(5).removeItem(0);
            slotList.get(7).removeItem(0);
        } else if (choice == 3) {
            slotList.get(0).removeItem(0);
            slotList.get(1).removeItem(0);
            slotList.get(9).removeItem(0);
            slotList.get(6).removeItem(0);
        } else if (choice == 4) {
            slotList.get(1).removeItem(0);
            slotList.get(5).removeItem(0);
            slotList.get(3).removeItem(0);
            slotList.get(7).removeItem(0);
        }
    }

    /**
     * Displays the transaction history of the vending machine.
     */

    @Override
    public void transactionHistory() {
        System.out.println("-- Transaction History --");

        // Variables to keep track of the sums for "Purchase" transactions
        double totalMoneyBeforeRestocking = 0;



        // Loop through the transaction history
        for (int i = 0; i < history.size(); i++) {
            TransactionHistory transaction = history.get(i);

            if (transaction.getTransactionType().equals("Purchase")) {
                // Print the name, money in, and money dispensed for the purchase transaction
                int choice = transaction.getItemINDEX() - 1;
                Item selectedSpecialItem = specialItemsData[choice];
                String itemName = selectedSpecialItem.getName();
                double moneyIn = transaction.getMoneyIN();
                double moneyDispensed = transaction.getAmountDispensed();
                System.out.println("Name: " + itemName);
                System.out.println("Money In: $" + moneyIn);
                System.out.println("Money Dispensed: $" + moneyDispensed);

                // Update the totals for "Purchase" transactions
                totalMoneyBeforeRestocking += moneyIn;
            } else if (transaction.getTransactionType().equals("Replenish")) {
                System.out.println("-- Money Replenished, Money Cashed in: $" + transaction.getMoneyIN() + " --");
            } else if (transaction.getTransactionType().equals("Collect")) {
                System.out.println("-- Money Collected, Money Collected: $" + transaction.getAmountDispensed() + " --");
            } else if (transaction.getTransactionType().equals("Restock")) {
                System.out.println("Total money before restocking: $" + totalMoneyBeforeRestocking);
                System.out.println("-- Restocked --");
                totalMoneyBeforeRestocking = 0; // Reset the total before restocking
            }
        }
        System.out.println("-- End of Transaction History --");
    }


}
