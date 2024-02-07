import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleBankingApp {

    private double balance = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Banking App");
            frame.setSize(600, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel balanceLabel = new JLabel("Balance: $0.00");
        balanceLabel.setBounds(10, 20, 200, 25);
        panel.add(balanceLabel);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(10, 50, 120, 25);
        panel.add(amountLabel);

        JTextField amountText = new JTextField(20);
        amountText.setBounds(140, 50, 150, 25);
        panel.add(amountText);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(10, 80, 80, 25);
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(100, 80, 100, 25);
        panel.add(withdrawButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(210, 80, 150, 25);
        panel.add(checkBalanceButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(10, 110, 80, 25);
        panel.add(exitButton);

        SimpleBankingApp bankingApp = new SimpleBankingApp();

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountText.getText();
                double amount = Double.parseDouble(amountStr);
                bankingApp.deposit(amount);
                balanceLabel.setText("Balance: $" + bankingApp.getBalance());
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountText.getText();
                double amount = Double.parseDouble(amountStr);
                bankingApp.withdraw(amount);
                balanceLabel.setText("Balance: $" + bankingApp.getBalance());
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Balance: $" + bankingApp.getBalance(), "Balance", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double getBalance() {
        return balance;
    }
}
