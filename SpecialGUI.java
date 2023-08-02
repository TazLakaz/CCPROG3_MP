/**
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineGUI extends JFrame implements ActionListener {
    private JButton[] itemButtons;
    private JButton[] moneyButtons;
    private JButton moneyReturn;
    private JLabel displayLabel;
    private JLabel balanceLabel;
    private JTextArea vendDisplay;
    private double balance;

    // Setting the products with their respective prices
    private String[] products = {"Yogurt Parfait", "Choco-Dipped Strawberry Yogurt Bowl", "Macha Yogurt Smoothie", "Graham Cracker Yogurt Parfait", "Choco-Nut Yogurt Sundae"};
    private double[] productPrices = {255, 115, 105, 165, 115};

    // Sets the available denominations of money
    private double[] moneyDenominations = {5, 20, 50, 100, 500};

    public VendingMachineGUI() {
        setTitle("Vending Machine");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout(20, 20));

        displayLabel = new JLabel("Please select a product.");
        add(displayLabel, BorderLayout.NORTH);

        JPanel productPanel = new JPanel(new GridLayout(products.length, 1, 5, 5));
        itemButtons = new JButton[products.length];
        for (int i = 0; i < products.length; i++) {
            itemButtons[i] = new JButton(products[i] + " (₱" + productPrices[i] + ")");
            itemButtons[i].addActionListener(this);
            productPanel.add(itemButtons[i]);
        }
        add(productPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new GridLayout(1, 2)); // GridLayout with 1 row and 2 columns
        balanceLabel = new JLabel("Balance: ₱" + String.format("%.2f", balance));
        southPanel.add(balanceLabel);

        JPanel moneyPanel = new JPanel(new GridLayout(moneyDenominations.length + 1, 1, 5, 5));
        moneyButtons = new JButton[moneyDenominations.length];
        for (int i = 0; i < moneyDenominations.length; i++) {
            moneyButtons[i] = new JButton("₱" + moneyDenominations[i]);
            moneyButtons[i].addActionListener(this);
            moneyPanel.add(moneyButtons[i]);
        }
        moneyReturn = new JButton("Coin Return");
        moneyReturn.addActionListener(this);
        moneyPanel.add(moneyReturn);

        add(moneyPanel, BorderLayout.WEST);

        vendDisplay = new JTextArea(5, 30);
        vendDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(vendDisplay);


        scrollPane.setPreferredSize(new Dimension(400, 60));
        southPanel.add(scrollPane);

        add(southPanel, BorderLayout.SOUTH);

        balance = 0.0; // Initial balance
        updateitemButtons(); // Disable product buttons if balance is insufficient
    }

    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        // Check if the button clicked is a product button, money button, or coin return button
        if (containsButton(itemButtons, source)) {
            String selectedProduct = source.getText().split(" ")[0]; // Extract product name
            double productPrice = getProductPrice(selectedProduct);

            if (balance >= productPrice) {
                // Successful purchase

                JOptionPane.showMessageDialog(this, "You've purchased " + selectedProduct + ".");
                balance -= productPrice;
            } else {
                // Insufficient balance
                JOptionPane.showMessageDialog(this, "Insufficient balance. Please add more money.");
            }
        } else if (containsButton(moneyButtons, source)) {
            // Add money to balance
            String buttonText = source.getText();
            double amount = Double.parseDouble(buttonText.substring(1));
            balance += amount;
        } else if (source == moneyReturn) {
            // Return coins to the user
            JOptionPane.showMessageDialog(this, "Returned ₱" + String.format("%.2f", balance) + ".");
            balance = 0.0;
        }

        // Update the balance label and product buttons
        balanceLabel.setText("Balance: ₱" + balance);
        updateitemButtons();
    }

    private boolean containsButton(JButton[] buttonArray, JButton button) {
        for (JButton btn : buttonArray) {
            if (btn.getText().equals(button.getText())) {
                return true;
            }
        }
        return false;
    }

    private double getProductPrice(String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals(productName)) {
                return productPrices[i];
            }
        }
        return 0.0;
    }


    private void updateitemButtons() {
        for (int i = 0; i < products.length; i++) {
            if (balance >= productPrices[i]) {
                itemButtons[i].setEnabled(true);
            } else {
                itemButtons[i].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VendingMachineGUI vendingMachine = new VendingMachineGUI();
            vendingMachine.setVisible(true);
        });
    }
}
**/