import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class SpecialGUI {
    private int balance = 0;
    private int YP = 255;
    private int CSY = 115;
    private int MYS = 105;
    private int GCP = 165;
    private int CNS = 115;
    private JLabel lblBalance;
    private JTextArea textArea;
    private JButton btnGetMoney;
    private JButton btnMaintenance;
    private JButton btnStock;
    private JButton btnRecipe;
    private JButton btnYogurtParfait;
    private JButton btnChocoStrawberryYogurt;
    private JButton btnMachaYogurtSmoothie;
    private JButton btnGrahamCrackerParfait;
    private JButton btnChocoNutSundae;
    private JLabel lblYogurtParfait;
    private JLabel lblChocoStrawberryYogurt;
    private JLabel lblMachaYogurtSmoothie;
    private JLabel lblGrahamCrackerParfait;
    private JLabel lblChocoNutSundae;
    private JButton btn5;
    private JButton btn10;
    private JButton btn50;
    private JButton btn100;
    private JButton btn500;
    private String[] setNames = {"Yogurt Parfait", "Choco-Dipped Strawberry Yogurt Bowl", "Macha Yogurt Smoothie",
            "Graham Cracker Yogurt Parfait", "Choco-Nut Yogurt Sundae"};
    private String[] itemNames = { "Vanilla Yogurt", "Chocolate Yogurt", "Strawberry Yogurt", "Choco Dip", "Strawberry Dip",
            "Crushed Oreo", "Sprinkles", "Chopped Nuts", "Macha", "Graham"};
    private int[] itemCapacities = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    private int[] denominations = {5, 10, 50, 100, 500};
    private int[] machineBalance = {0, 0, 0, 0, 0};
    private int[] buyButtons = {0,0,0,0,0};
    public SpecialGUI() {
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Special Vending Machine");
        frame.setLayout(null);

        lblBalance = new JLabel("Balance: ₱" + balance);
        lblBalance.setBounds(410, 80, 100, 30);

        ActionListener balanceButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(((JButton) e.getSource()).getText());
                balance += amount;
                lblBalance.setText("Balance: ₱" + balance);
            }
        };

        ActionListener getMoneyButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balance = 0;
                lblBalance.setText("Balance: ₱" + balance);
            }
        };

        ActionListener yogurtParfaitButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= YP && checkItemCapacity(0, 1, 2, 5, 7)) {
                    balance -= YP;
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(0, 1, 2, 5, 7);
                    updateMachineBalance(YP);
                    String[] messages = {
                            "Layering vanilla, strawberry, and chocolate yogurt in a cup...",
                            "Sprinkling crushed Oreos...",
                            "Putting chopped nuts on top...",
                            "Finishing touches...",
                            "Serve and Enjoy!\n"
                    };
                    delayUpdateText(messages);
                    buyButtons[0] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy Yogurt Parfait!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener chocoStrawberryYogurtButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= CSY && checkItemCapacity(2, 3, 4, 5)) {
                    balance -= CSY;
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(2, 3, 4, 5);
                    updateMachineBalance(CSY);
                    String[] messages = {
                            "Dispensing strawberry into a cup...",
                            "Pouring chocolate and strawberry dip...",
                            "Sprinkling crushed Oreos...",
                            "Finishing touches...",
                            "Serve and Enjoy!\n"
                    };
                    delayUpdateText(messages);
                    buyButtons[1] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy Choco-Dipped Strawberry Yogurt Bowl!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener machaYogurtSmoothieButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= MYS && checkItemCapacity(0, 5, 7)) {
                    balance -= MYS;
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(0, 5, 7);
                    updateMachineBalance(MYS);
                    String[] messages = {
                            "Dispensing vanilla into a cup...",
                            "Sprinkling macha and crushed Oreos...",
                            "Putting chopped nuts on top...",
                            "Finishing touches...",
                            "Serve and Enjoy!\n"
                    };
                    delayUpdateText(messages);
                    buyButtons[2] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy Macha Yogurt Smoothie!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener grahamCrackerParfaitButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= GCP && checkItemCapacity(0, 1, 8, 6)) {
                    balance -= GCP;
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(0, 1, 8, 6);
                    updateMachineBalance(GCP);
                    String[] messages = {
                            "Layering vanilla and chocolate yogurt in a cup...",
                            "Adding graham on the sides...",
                            "Sprinkling sprinkles on top...",
                            "Finishing touches...",
                            "Serve and Enjoy!\n"
                    };
                    delayUpdateText(messages);
                    buyButtons[3] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy Graham Cracker Yogurt Parfait!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener chocoNutSundaeButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= CNS && checkItemCapacity(1, 3, 5, 7)) {
                    balance -= CNS;
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(1, 3, 5, 7);
                    updateMachineBalance(CNS);
                    String[] messages = {
                            "Dispensing chocolate into a cup...",
                            "Sprinkling crushed Oreos...",
                            "Pouring chocolate dip...",
                            "Putting chopped nuts on top...",
                            "Finishing touches...",
                            "Serve and Enjoy!\n"
                    };
                    delayUpdateText(messages);
                    buyButtons[4] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy Choco-Nut Yogurt Sundae!";
                    updateTextArea(message);
                }
            }
        };

        btnYogurtParfait = new JButton("Yogurt Parfait");
        btnChocoStrawberryYogurt = new JButton("Choco-Dipped Strawberry Yogurt Bowl");
        btnMachaYogurtSmoothie = new JButton("Macha Yogurt Smoothie");
        btnGrahamCrackerParfait = new JButton("Graham Cracker Yogurt Parfait");
        btnChocoNutSundae = new JButton("Choco-Nut Yogurt Sundae");
        btnYogurtParfait.setBounds(10, 10, 180, 30);
        btnChocoStrawberryYogurt.setBounds(200, 10, 260, 30);
        btnMachaYogurtSmoothie.setBounds(470, 10, 180, 30);
        btnGrahamCrackerParfait.setBounds(660, 10, 220, 30);
        btnChocoNutSundae.setBounds(890, 10, 180, 30);
        btnYogurtParfait.addActionListener(yogurtParfaitButtonListener);
        btnChocoStrawberryYogurt.addActionListener(chocoStrawberryYogurtButtonListener);
        btnMachaYogurtSmoothie.addActionListener(machaYogurtSmoothieButtonListener);
        btnGrahamCrackerParfait.addActionListener(grahamCrackerParfaitButtonListener);
        btnChocoNutSundae.addActionListener(chocoNutSundaeButtonListener);

        lblYogurtParfait = new JLabel("759 cal | ₱" + YP );
        lblChocoStrawberryYogurt = new JLabel("300 cal | ₱" + CSY);
        lblMachaYogurtSmoothie = new JLabel("259 cal | ₱" + MYS);
        lblGrahamCrackerParfait = new JLabel("473 cal | ₱" + GCP);
        lblChocoNutSundae = new JLabel("307 cal | ₱" + CNS);
        lblYogurtParfait.setBounds(60, 40, 180, 40);
        lblChocoStrawberryYogurt.setBounds(290, 40, 260, 40);
        lblMachaYogurtSmoothie.setBounds(520, 40, 180, 40);
        lblGrahamCrackerParfait.setBounds(730, 40, 220, 40);
        lblChocoNutSundae.setBounds(940, 40, 180, 40);

        btn5 = new JButton("5");
        btn10 = new JButton("10");
        btn50 = new JButton("50");
        btn100 = new JButton("100");
        btn500 = new JButton("500");
        btn5.setBounds(10, 80, 70, 30);
        btn10.setBounds(90, 80, 70, 30);
        btn50.setBounds(170, 80, 70, 30);
        btn100.setBounds(250, 80, 70, 30);
        btn500.setBounds(330, 80, 70, 30);
        btn5.addActionListener(balanceButtonListener);
        btn10.addActionListener(balanceButtonListener);
        btn50.addActionListener(balanceButtonListener);
        btn100.addActionListener(balanceButtonListener);
        btn500.addActionListener(balanceButtonListener);

        btnGetMoney = new JButton("Get Money");
        btnMaintenance = new JButton("Maintenance");
        btnStock = new JButton("Stock");
        btnRecipe = new JButton("Recipe");
        btnGetMoney.setBounds(10, 430, 150, 30);
        btnMaintenance.setBounds(170, 430, 150, 30);
        btnStock.setBounds(330, 430, 150, 30);
        btnRecipe.setBounds(490, 430, 150, 30);
        btnGetMoney.addActionListener(getMoneyButtonListener);

        btnRecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Yogurt Parfait: \n" +
                        "1x vanilla yogurt \n" +
                        "1x strawberry yogurt \n" +
                        "1x chocolate yogurt \n" +
                        "1x crushed Oreo \n" +
                        "1x chopped nuts \n\n" +

                        "Choco-Dipped Strawberry Yogurt Bowl: \n" +
                        "1x strawberry yogurt \n" +
                        "1x chocolate dip \n" +
                        "1x strawberry dip \n" +
                        "1x crushed Oreo \n\n" +

                        "Macha Yogurt Smoothie: \n" +
                        "1x vanilla yogurt \n" +
                        "1x macha \n" +
                        "1x crushed Oreo \n" +
                        "1x chopped nuts \n\n" +

                        "Graham Cracker Yogurt Parfait: \n" +
                        "1x vanilla yogurt \n" +
                        "1x chocolate yogurt \n" +
                        "1x graham \n" +
                        "1x sprinkles \n\n" +

                        "Choco-Nut Yogurt Sundae: \n" +
                        "1x chocolate yogurt \n" +
                        "1x crushed Oreo \n" +
                        "1x chocolate dip \n" +
                        "1x chopped nuts \n";
                updateTextArea(message);
            }
        });

        btnMaintenance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMaintenanceOptions();
            }
        });

        btnStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder stockMessage = new StringBuilder("Item Stock:\n");
                for (int i = 0; i < itemNames.length; i++) {
                    stockMessage.append(itemNames[i]).append(": ").append(itemCapacities[i]).append("\n");
                }
                updateTextArea(stockMessage.toString());
            }
        });

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 120, 1060, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        frame.add(btnYogurtParfait);
        frame.add(btnChocoStrawberryYogurt);
        frame.add(btnMachaYogurtSmoothie);
        frame.add(btnGrahamCrackerParfait);
        frame.add(btnChocoNutSundae);

        frame.add(lblYogurtParfait);
        frame.add(lblChocoStrawberryYogurt);
        frame.add(lblMachaYogurtSmoothie);
        frame.add(lblGrahamCrackerParfait);
        frame.add(lblChocoNutSundae);

        frame.add(btn5);
        frame.add(btn10);
        frame.add(btn50);
        frame.add(btn100);
        frame.add(btn500);

        frame.add(lblBalance);

        frame.add(btnGetMoney);
        frame.add(btnMaintenance);
        frame.add(btnStock);
        frame.add(btnRecipe);

        frame.setSize(1100, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void showMaintenanceOptions() {
        JFrame maintenanceFrame = new JFrame("Maintenance Options");
        maintenanceFrame.setLayout(null);
        maintenanceFrame.setSize(300, 250);

        JButton btnRestock = new JButton("Restock");
        JButton btnMachineBalance = new JButton("Machine Balance");
        JButton btnChangePrice = new JButton("Change Price");
        JButton btnTransactionHistory = new JButton("Transaction History");

        btnRestock.setBounds(40, 30, 220, 30);
        btnMachineBalance.setBounds(40, 70, 220, 30);
        btnChangePrice.setBounds(40, 110, 220, 30);
        btnTransactionHistory.setBounds(40, 150, 220, 30);

        btnRestock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRestockFrame();
            }
        });

        btnMachineBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMachineBalanceFrame();
            }
        });

        btnChangePrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangePriceFrame();
            }
        });

        btnTransactionHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTransactionHistoryFrame();
            }
        });

        maintenanceFrame.add(btnRestock);
        maintenanceFrame.add(btnMachineBalance);
        maintenanceFrame.add(btnChangePrice);
        maintenanceFrame.add(btnTransactionHistory);

        maintenanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        maintenanceFrame.setVisible(true);
    }

    private void showRestockFrame() {
        JFrame restockFrame = new JFrame("Restock");
        restockFrame.setLayout(null);
        restockFrame.setSize(300, 200);

        final int[] selectedItemIndex = {0};
        final int[] restockQuantity = {0};

        JButton btnItemUp = new JButton("Up");
        JButton btnItemDown = new JButton("Down");
        JButton btnQuantityUp = new JButton("Up");
        JButton btnQuantityDown = new JButton("Down");

        btnItemUp.setBounds(40, 30, 100, 30);
        btnItemDown.setBounds(160, 30, 100, 30);
        btnQuantityUp.setBounds(40, 90, 100, 30);
        btnQuantityDown.setBounds(160, 90, 100, 30);

        JLabel lblItem = new JLabel(itemNames[selectedItemIndex[0]]);
        JLabel lblQuantity = new JLabel("Quantity: " + restockQuantity[0]);

        lblItem.setBounds(100, 10, 100, 20);
        lblQuantity.setBounds(100, 70, 100, 20);

        btnItemUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItemIndex[0] = (selectedItemIndex[0] + 1) % itemNames.length;
                lblItem.setText(itemNames[selectedItemIndex[0]]);
            }
        });

        btnItemDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItemIndex[0] = (selectedItemIndex[0] - 1 + itemNames.length) % itemNames.length;
                lblItem.setText(itemNames[selectedItemIndex[0]]);
            }
        });

        btnQuantityUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restockQuantity[0]++;
                lblQuantity.setText("Quantity: " + restockQuantity[0]);
            }
        });

        btnQuantityDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (restockQuantity[0] > 0) {
                    restockQuantity[0]--;
                    lblQuantity.setText("Quantity: " + restockQuantity[0]);
                }
            }
        });

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(100, 130, 100, 30);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemCapacities[selectedItemIndex[0]] += restockQuantity[0];
                String message = "Restocked " + restockQuantity[0] + " " + itemNames[selectedItemIndex[0]] + ".";
                updateTextArea(message);
                restockFrame.dispose();
            }
        });

        restockFrame.add(btnItemUp);
        restockFrame.add(btnItemDown);
        restockFrame.add(btnQuantityUp);
        restockFrame.add(btnQuantityDown);
        restockFrame.add(lblItem);
        restockFrame.add(lblQuantity);
        restockFrame.add(btnConfirm);

        restockFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        restockFrame.setVisible(true);
    }

    private void showMachineBalanceFrame() {
        JFrame machineBalanceFrame = new JFrame("Machine Balance");
        machineBalanceFrame.setLayout(null);
        machineBalanceFrame.setSize(300, 200);

        final int[] selectedDenominationIndex = {0};
        final int[] balanceQuantity = {machineBalance[selectedDenominationIndex[0]]};

        JButton btnDenominationUp = new JButton("Up");
        JButton btnDenominationDown = new JButton("Down");
        JButton btnQuantityUp = new JButton("Up");
        JButton btnQuantityDown = new JButton("Down");

        btnDenominationUp.setBounds(40, 30, 100, 30);
        btnDenominationDown.setBounds(160, 30, 100, 30);
        btnQuantityUp.setBounds(40, 90, 100, 30);
        btnQuantityDown.setBounds(160, 90, 100, 30);

        JLabel lblDenomination = new JLabel(denominations[selectedDenominationIndex[0]] + " denomination");
        JLabel lblQuantity = new JLabel("Quantity: " + balanceQuantity[0]);

        lblDenomination.setBounds(100, 10, 150, 20);
        lblQuantity.setBounds(100, 70, 100, 20);

        btnDenominationUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDenominationIndex[0] = (selectedDenominationIndex[0] + 1) % denominations.length;
                lblDenomination.setText(denominations[selectedDenominationIndex[0]] + " denomination");
                balanceQuantity[0] = machineBalance[selectedDenominationIndex[0]];
                lblQuantity.setText("Quantity: " + balanceQuantity[0]);
            }
        });

        btnDenominationDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDenominationIndex[0] = (selectedDenominationIndex[0] - 1 + denominations.length) % denominations.length;
                lblDenomination.setText(denominations[selectedDenominationIndex[0]] + " denomination");
                balanceQuantity[0] = machineBalance[selectedDenominationIndex[0]];
                lblQuantity.setText("Quantity: " + balanceQuantity[0]);
            }
        });

        btnQuantityUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balanceQuantity[0]++;
                lblQuantity.setText("Quantity: " + balanceQuantity[0]);
            }
        });

        btnQuantityDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (balanceQuantity[0] > 0) {
                    balanceQuantity[0]--;
                    lblQuantity.setText("Quantity: " + balanceQuantity[0]);
                }
            }
        });

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(100, 130, 100, 30);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                machineBalance[selectedDenominationIndex[0]] = balanceQuantity[0];
                String message = "Updated " + denominations[selectedDenominationIndex[0]] + " denomination balance to " + balanceQuantity[0] + ".";
                updateTextArea(message);
                for(int i = 0; i < 5; i++) {
                    updateTextArea("₱" + String.valueOf(denominations[i])+ " = x" + String.valueOf((machineBalance[i])));
                }
                machineBalanceFrame.dispose();
            }
        });

        machineBalanceFrame.add(btnDenominationUp);
        machineBalanceFrame.add(btnDenominationDown);
        machineBalanceFrame.add(btnQuantityUp);
        machineBalanceFrame.add(btnQuantityDown);
        machineBalanceFrame.add(lblDenomination);
        machineBalanceFrame.add(lblQuantity);
        machineBalanceFrame.add(btnConfirm);

        machineBalanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        machineBalanceFrame.setVisible(true);
    }

    private void showChangePriceFrame() {
        JFrame changePriceFrame = new JFrame("Change Price");
        changePriceFrame.setLayout(null);
        changePriceFrame.setSize(300, 200);

        final int[] selectedItemIndex = {0};

        JButton btnItemUp = new JButton("Up");
        JButton btnItemDown = new JButton("Down");

        btnItemUp.setBounds(40, 30, 100, 30);
        btnItemDown.setBounds(160, 30, 100, 30);

        JLabel lblItem = new JLabel(setNames[selectedItemIndex[0]]);
        lblItem.setBounds(100, 10, 100, 20);

        btnItemUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItemIndex[0] = (selectedItemIndex[0] + 1) % setNames.length;
                lblItem.setText(setNames[selectedItemIndex[0]]);
            }
        });

        btnItemDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItemIndex[0] = (selectedItemIndex[0] - 1 + setNames.length) % setNames.length;
                lblItem.setText(setNames[selectedItemIndex[0]]);
            }
        });

        JTextField txtNewPrice = new JTextField();
        txtNewPrice.setBounds(40, 70, 220, 30);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(100, 110, 100, 30);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPriceText = txtNewPrice.getText();
                try {
                    int newPrice = Integer.parseInt(newPriceText);
                    if (newPrice >= 0) {
                        String message = "Changed the price of " + setNames[selectedItemIndex[0]] + " to ₱" + newPrice + ".";
                        updateTextArea(message);
                        if (selectedItemIndex[0] == 0){
                            YP = newPrice;
                            lblYogurtParfait.setText("759 cal | " + YP );
                        }else if(selectedItemIndex[0] == 1){
                            CSY = newPrice;
                            lblChocoStrawberryYogurt.setText("300 cal | " + CSY);
                        }else if(selectedItemIndex[0] == 2){
                            MYS = newPrice;
                            lblMachaYogurtSmoothie.setText("259 cal | " + MYS);
                        }else if(selectedItemIndex[0] == 3){
                            GCP = newPrice;
                            lblGrahamCrackerParfait.setText("473 cal | " + GCP);
                        }else if(selectedItemIndex[0] == 4){
                            CNS = newPrice;
                            lblChocoNutSundae.setText("307 cal | " + CNS);
                        }
                    } else {
                        String errorMessage = "Invalid price. Please enter a non-negative integer.";
                        updateTextArea(errorMessage);
                    }
                } catch (NumberFormatException ex) {
                    String errorMessage = "Invalid price format. Please enter a valid integer.";
                    updateTextArea(errorMessage);
                }
                changePriceFrame.dispose();
            }
        });

        changePriceFrame.add(btnItemUp);
        changePriceFrame.add(btnItemDown);
        changePriceFrame.add(lblItem);
        changePriceFrame.add(txtNewPrice);
        changePriceFrame.add(btnConfirm);

        changePriceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changePriceFrame.setVisible(true);
    }

    private void showTransactionHistoryFrame() {
        JFrame transactionHistoryFrame = new JFrame("Transaction History");
        transactionHistoryFrame.setLayout(null);
        transactionHistoryFrame.setSize(400, 300);

        JTextArea textAreaHistory = new JTextArea();
        textAreaHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaHistory);
        scrollPane.setBounds(20, 20, 360, 220);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textAreaHistory.append("Items Bought:\n");
        int totalProfit = 0;
        for (int i = 0; i < setNames.length; i++) {
            if (buyButtons[i] > 0) {
                textAreaHistory.append(setNames[i] + " x" + buyButtons[i] + "\n");
                if (i == 0) {
                    totalProfit += (buyButtons[i] * YP);
                }else if(i == 1){
                    totalProfit += (buyButtons[i] * CSY);
                }else if(i == 2){
                    totalProfit += (buyButtons[i] * MYS);
                }else if(i == 3){
                    totalProfit += (buyButtons[i] * GCP);
                }else if(i == 4){
                    totalProfit += (buyButtons[i] * CNS);
                }
            }
        }
        textAreaHistory.append("Total Profit: " + String.valueOf(totalProfit));


        transactionHistoryFrame.add(scrollPane);

        transactionHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transactionHistoryFrame.setVisible(true);
    }
    private void updateTextArea(String message) {
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    private void delayUpdateText(String[] messages) {
        int delay = 1000;

        Timer timer = new Timer();
        for (int i = 0; i < messages.length; i++) {
            int currentIndex = i;
            TimerTask updateTask = new TimerTask() {
                @Override
                public void run() {
                    SwingUtilities.invokeLater(() -> {
                        textArea.append(messages[currentIndex] + "\n");
                        textArea.setCaretPosition(textArea.getDocument().getLength());
                    });
                }
            };
            timer.schedule(updateTask, (i + 1) * delay);
        }
    }

    private boolean checkItemCapacity(int... itemIndices) {
        for (int index : itemIndices) {
            if (itemCapacities[index] <= 0) {
                return false;
            }
        }
        return true;
    }

    private void updateItemCapacity(int... itemIndices) {
        for (int index : itemIndices) {
            itemCapacities[index] -= 1;
        }
    }

    private void updateMachineBalance(int price) {
        for (int i = denominations.length - 1; i >= 0; i--) {
            while (price >= denominations[i]) {
                price -= denominations[i];
                machineBalance[i]++;
            }
        }
    }
}