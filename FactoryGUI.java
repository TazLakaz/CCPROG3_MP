import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryGUI extends JFrame {
    public FactoryGUI() {

        setTitle("Vending Machine Factory");

        JPanel panel = new JPanel();

        JLabel Text = new JLabel("Vending Machine Factory");
        panel.add(Text);

        JButton regularVendingMachineButton = new JButton("Regular Vending Machine");
        panel.add(regularVendingMachineButton);

        JButton specialVendingMachineButton = new JButton("Special Vending Machine");
        panel.add(specialVendingMachineButton);

        regularVendingMachineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegularGUI regularGUI = new RegularGUI();
                setVisible(false);
            }
        });

        specialVendingMachineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpecialGUI specialGUI = new SpecialGUI();
                setVisible(false);
            }
        });

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}