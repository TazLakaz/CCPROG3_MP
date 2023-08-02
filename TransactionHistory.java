
/**
 * Represents the transaction history of a vending machine.
 */
public class TransactionHistory {
    private int itemINDEX;
    private int moneyIN;
    private double amountDispensed;
    private String transactionType;

    /**
     * Constructor for non-purchase transactions.
     *
     * @param transactionType The type of non-purchase transaction.
     */

    // Constructor for Restock, and Replenish
    public TransactionHistory(String transactionType) {
        this.itemINDEX = -1;
        this.moneyIN = 0;
        this.amountDispensed = 0.0;
        this.transactionType = transactionType;
    }

    // Constructor for Collect

    public TransactionHistory(String transactionType, double totalMoney) {
        this.itemINDEX = -1;
        this.moneyIN = 0;
        this.amountDispensed = totalMoney;
        this.transactionType = transactionType;
    }
    // Constructor for purchase transactions
    public TransactionHistory(int choice, int totalUserMoney, double changeCopy) {
        this.itemINDEX = choice;
        this.moneyIN = totalUserMoney;
        this.amountDispensed = changeCopy;
        this.transactionType = "Purchase";
    }


    public int getItemINDEX() {
        return itemINDEX;
    }

    public int getMoneyIN() {
        return moneyIN;
    }

    public double getAmountDispensed() {
        return amountDispensed;
    }

    public String getTransactionType() {
        return transactionType;
    }
}