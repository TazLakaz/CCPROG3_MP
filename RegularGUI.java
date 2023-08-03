import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularGUI {
    private int balance = 0;
    private JLabel lblBalance;
    private JTextArea textArea;
    private JButton btnGetMoney;
    private JButton btnMaintenance;
    private JButton btnStock;
    private JButton btnVanillaYogurt;
    private JButton btnChocolateYogurt;
    private JButton btnStrawberryYogurt;
    private JButton btnChocoDip;
    private JButton btnStrawberryDip;
    private JButton btnCrushedOreo;
    private JButton btnSprinkles;
    private JButton btnChoppedNuts;
    private JButton btnMacha;
    private JButton btnGraham;
    private JLabel lblVanillaYogurt;
    private JLabel lblChocolateYogurt;
    private JLabel lblStrawberryYogurt;
    private JLabel lblChocoDip;
    private JLabel lblStrawberryDip;
    private JLabel lblCrushedOreo;
    private JLabel lblSprinkles;
    private JLabel lblChoppedNuts;
    private JLabel lblMacha;
    private JLabel lblGraham;
    private JButton btn5;
    private JButton btn10;
    private JButton btn50;
    private JButton btn100;
    private JButton btn500;

    private String[] itemNames = { "Vanilla Yogurt", "Chocolate Yogurt", "Strawberry Yogurt", "Choco Dip", "Strawberry Dip",
            "Crushed Oreo", "Sprinkles", "Chopped Nuts", "Macha", "Graham"};
    private int[] itemCapacities = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    private int[] denominations = {5, 10, 50, 100, 500};
    private int[] machineBalance = {0, 0, 0, 0, 0};
    private int[] buyButtons = {0,0,0,0,0,0,0,0,0,0};
    private int[] Prices = {70, 80, 80, 10, 10, 15, 5, 10, 10, 10};
    public RegularGUI() {
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Regular Vending Machine");
        frame.setLayout(null);

        lblBalance = new JLabel("Balance: ₱" + balance);
        lblBalance.setBounds(410, 150, 100, 30);

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

        ActionListener vanillaYogurtButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[0] && checkItemCapacity(0)) {
                    balance -= Prices[0];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(0);
                    updateMachineBalance(Prices[0]);
                    String message =  "Enjoy your "+ itemNames[0] + "!\n";
                    updateTextArea(message);
                    buyButtons[0] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[0] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener chocolateYogurtButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[1] && checkItemCapacity(1)) {
                    balance -= Prices[1];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(1);
                    updateMachineBalance(Prices[1]);
                    String message =  "Enjoy your "+ itemNames[1] + "!\n";
                    updateTextArea(message);
                    buyButtons[1] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[1] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener strawberryYogurtButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[2] && checkItemCapacity(2)) {
                    balance -= Prices[2];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(2);
                    updateMachineBalance(Prices[2]);
                    String message =  "Enjoy your "+ itemNames[2] + "!\n";
                    updateTextArea(message);
                    buyButtons[2] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[2] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener chocoDipButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[3] && checkItemCapacity(3)) {
                    balance -= Prices[3];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(3);
                    updateMachineBalance(Prices[3]);
                    String message =  "Enjoy your "+ itemNames[3] + "!\n";
                    updateTextArea(message);
                    buyButtons[3] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[3] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener strawberryDipButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[4] && checkItemCapacity(4)) {
                    balance -= Prices[4];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(4);
                    updateMachineBalance(Prices[4]);
                    String message =  "Enjoy your "+ itemNames[4] + "!\n";
                    updateTextArea(message);
                    buyButtons[4] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[4] + "!";
                    updateTextArea(message);
                }
            }
        };
        ActionListener crushedOreoButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[5] && checkItemCapacity(5)) {
                    balance -= Prices[5];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(5);
                    updateMachineBalance(Prices[5]);
                    String message =  "Enjoy your "+ itemNames[5] + "!\n";
                    updateTextArea(message);
                    buyButtons[5] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[5] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener sprinklesButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[6] && checkItemCapacity(6)) {
                    balance -= Prices[6];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(6);
                    updateMachineBalance(Prices[6]);
                    String message =  "Enjoy your "+ itemNames[6] + "!\n";
                    updateTextArea(message);
                    buyButtons[6] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[6] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener choppedNutsButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[7] && checkItemCapacity(7)) {
                    balance -= Prices[7];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(7);
                    updateMachineBalance(Prices[7]);
                    String message =  "Enjoy your "+ itemNames[7] + "!\n";
                    updateTextArea(message);
                    buyButtons[7] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[7] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener machaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[8] && checkItemCapacity(8)) {
                    balance -= Prices[8];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(8);
                    updateMachineBalance(Prices[8]);
                    String message =  "Enjoy your "+ itemNames[8] + "!\n";
                    updateTextArea(message);
                    buyButtons[8] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[8] + "!";
                    updateTextArea(message);
                }
            }
        };

        ActionListener grahamButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (balance >= Prices[9] && checkItemCapacity(9)) {
                    balance -= Prices[9];
                    lblBalance.setText("Balance: ₱" + balance);
                    updateItemCapacity(9);
                    updateMachineBalance(Prices[9]);
                    String message =  "Enjoy your "+ itemNames[9] + "!\n";
                    updateTextArea(message);
                    buyButtons[9] += 1;
                } else {
                    String message = "Not enough balance or not enough capacity to buy "+ itemNames[9] + "!";
                    updateTextArea(message);
                }
            }
        };

        btnVanillaYogurt = new JButton("Vanilla Yogurt");
        btnChocolateYogurt = new JButton("Chocolate Yogurt");
        btnStrawberryYogurt = new JButton("Strawberry Yogurt");
        btnChocoDip = new JButton("Choco Dip");
        btnStrawberryDip = new JButton("Strawberry Dip");
        btnCrushedOreo = new JButton("Crushed Oreo");
        btnSprinkles = new JButton("Sprinkles");
        btnChoppedNuts = new JButton("Chopped Nuts");
        btnMacha = new JButton("Macha");
        btnGraham = new JButton("Graham");
        btnVanillaYogurt.setBounds(10, 10, 180, 30);
        btnChocolateYogurt.setBounds(200, 10, 180, 30);
        btnStrawberryYogurt.setBounds(390, 10, 180, 30);
        btnChocoDip.setBounds(580, 10, 180, 30);
        btnStrawberryDip.setBounds(770, 10, 180, 30);
        btnCrushedOreo.setBounds(10, 80, 180, 30);
        btnSprinkles.setBounds(200, 80, 180, 30);
        btnChoppedNuts.setBounds(390, 80, 180, 30);
        btnMacha.setBounds(580, 80, 180, 30);
        btnGraham.setBounds(770, 80, 180, 30);

        btnVanillaYogurt.addActionListener(vanillaYogurtButtonListener);
        btnChocolateYogurt.addActionListener(chocolateYogurtButtonListener);
        btnStrawberryYogurt.addActionListener(strawberryYogurtButtonListener);
        btnChocoDip.addActionListener(chocoDipButtonListener);
        btnStrawberryDip.addActionListener(strawberryDipButtonListener);
        btnCrushedOreo.addActionListener(crushedOreoButtonListener);
        btnSprinkles.addActionListener(sprinklesButtonListener);
        btnChoppedNuts.addActionListener(choppedNutsButtonListener);
        btnMacha.addActionListener(machaListener);
        btnGraham.addActionListener(grahamButtonListener);


        lblVanillaYogurt = new JLabel("208 cal | ₱" + Prices[0] );
        lblChocolateYogurt = new JLabel("254 cal | ₱" + Prices[1]);
        lblStrawberryYogurt = new JLabel("255 cal | ₱" + Prices[2]);
        lblChocoDip = new JLabel("11 cal | ₱" + Prices[3]);
        lblStrawberryDip = new JLabel("10 cal | ₱" + Prices[4]);
        lblCrushedOreo = new JLabel("24 cal | ₱" + Prices[5]);
        lblSprinkles = new JLabel("4 cal | ₱" + Prices[6]);
        lblChoppedNuts = new JLabel("18 cal | ₱" + Prices[7]);
        lblMacha = new JLabel("9 cal | ₱" + Prices[8]);
        lblGraham = new JLabel("7 cal | ₱" + Prices[9]);
        lblVanillaYogurt.setBounds(70, 40, 180, 40);
        lblChocolateYogurt.setBounds(260, 40, 260, 40);
        lblStrawberryYogurt.setBounds(450, 40, 180, 40);
        lblChocoDip.setBounds(640, 40, 220, 40);
        lblStrawberryDip.setBounds(830, 40, 180, 40);
        lblCrushedOreo.setBounds(70, 120, 100, 20);
        lblSprinkles.setBounds(260, 120, 100, 20);
        lblChoppedNuts.setBounds(450, 120, 100, 20);
        lblMacha.setBounds(640, 120, 100, 20);
        lblGraham.setBounds(830, 120, 100, 20);

        btn5 = new JButton("5");
        btn10 = new JButton("10");
        btn50 = new JButton("50");
        btn100 = new JButton("100");
        btn500 = new JButton("500");
        btn5.setBounds(10, 150, 70, 30);
        btn10.setBounds(90, 150, 70, 30);
        btn50.setBounds(170, 150, 70, 30);
        btn100.setBounds(250, 150, 70, 30);
        btn500.setBounds(330, 150, 70, 30);
        btn5.addActionListener(balanceButtonListener);
        btn10.addActionListener(balanceButtonListener);
        btn50.addActionListener(balanceButtonListener);
        btn100.addActionListener(balanceButtonListener);
        btn500.addActionListener(balanceButtonListener);

        btnGetMoney = new JButton("Get Money");
        btnMaintenance = new JButton("Maintenance");
        btnStock = new JButton("Stock");
        btnGetMoney.setBounds(10, 500, 150, 30);
        btnMaintenance.setBounds(170, 500, 150, 30);
        btnStock.setBounds(330, 500, 150, 30);
        btnGetMoney.addActionListener(getMoneyButtonListener);

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
        scrollPane.setBounds(10, 190, 1060, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        frame.add(btnVanillaYogurt);
        frame.add(btnChocolateYogurt);
        frame.add(btnStrawberryYogurt);
        frame.add(btnChocoDip);
        frame.add(btnStrawberryDip);
        frame.add(btnCrushedOreo);
        frame.add(btnSprinkles);
        frame.add(btnChoppedNuts);
        frame.add(btnMacha);
        frame.add(btnGraham);

        frame.add(lblVanillaYogurt);
        frame.add(lblChocolateYogurt);
        frame.add(lblStrawberryYogurt);
        frame.add(lblChocoDip);
        frame.add(lblStrawberryDip);
        frame.add(lblCrushedOreo);
        frame.add(lblSprinkles);
        frame.add(lblChoppedNuts);
        frame.add(lblMacha);
        frame.add(lblGraham);

        frame.add(btn5);
        frame.add(btn10);
        frame.add(btn50);
        frame.add(btn100);
        frame.add(btn500);

        frame.add(lblBalance);

        frame.add(btnGetMoney);
        frame.add(btnMaintenance);
        frame.add(btnStock);

        frame.setSize(1000, 600);
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

        JLabel lblItem = new JLabel(itemNames[selectedItemIndex[0]]);
        lblItem.setBounds(100, 10, 100, 20);

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
                        String message = "Changed the price of " + itemNames[selectedItemIndex[0]] + " to ₱" + newPrice + ".";
                        updateTextArea(message);
                        if (selectedItemIndex[0] == 0){
                            Prices[0] = newPrice;
                            lblVanillaYogurt.setText("208 cal | ₱" + Prices[0]);
                        }else if(selectedItemIndex[0] == 1){
                            Prices[1] = newPrice;
                            lblChocolateYogurt.setText("254 cal | ₱" + Prices[1]);
                        }else if(selectedItemIndex[0] == 2){
                            Prices[2] = newPrice;
                            lblStrawberryYogurt.setText("255 cal | ₱" + Prices[2]);
                        }else if(selectedItemIndex[0] == 3){
                            Prices[3] = newPrice;
                            lblChocoDip.setText("11 cal | ₱" + Prices[3]);
                        }else if(selectedItemIndex[0] == 4){
                            Prices[4] = newPrice;
                            lblStrawberryDip.setText("10 cal | ₱" + Prices[4]);
                        }else if(selectedItemIndex[0] == 5){
                            Prices[5] = newPrice;
                            lblCrushedOreo.setText("24 cal | ₱" + Prices[5]);
                        }else if(selectedItemIndex[0] == 6){
                            Prices[6] = newPrice;
                            lblSprinkles.setText("4 cal | ₱" + Prices[6]);
                        }else if(selectedItemIndex[0] == 7){
                            Prices[7] = newPrice;
                            lblChoppedNuts.setText("18 cal | ₱" + Prices[7]);
                        }else if(selectedItemIndex[0] == 8){
                            Prices[8] = newPrice;
                            lblMacha.setText("9 cal | ₱" + Prices[8]);
                        }else if(selectedItemIndex[0] == 9){
                            Prices[9] = newPrice;
                            lblGraham.setText("7 cal | ₱" + Prices[9]);
                        }

                    } else {
                        String errorMessage = "Invalid price. Please enter a positive integer.";
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
        for (int i = 0; i < itemNames.length; i++) {
            if (buyButtons[i] > 0) {
                textAreaHistory.append(itemNames[i] + " x" + buyButtons[i] + "\n");
                totalProfit += (buyButtons[i] * Prices[i]);

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