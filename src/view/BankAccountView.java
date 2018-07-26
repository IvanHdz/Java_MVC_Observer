/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BankAccountController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.util.Observer;
import java.util.Observable;
import java.text.*;
import model.BankAccountModel;

/**
 *
 * @author Viruz
 */
public class BankAccountView extends JPanel
        implements Observer {

    private final BankAccountModel model;
    private final BankAccountController controller;
    private final JButton depositButton = new JButton("Deposit");
    private final JButton withdrawButton = new JButton("Withdraw");
    private final JTextField amountField = new JTextField();
    private final JLabel balanceLabel = new JLabel();

    //Constructor
    public BankAccountView(BankAccountModel model) {
        model.addObserver(this);
        this.model = model;
        this.controller = new BankAccountController(this, model);
        buildUI();
    }

    //Builds the display as seen by the user
    private void buildUI() {
        setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new BorderLayout());
        JPanel balance = new JPanel(new BorderLayout());
        buttons.add(depositButton, BorderLayout.WEST);
        buttons.add(withdrawButton, BorderLayout.EAST);
        balance.add(balanceLabel, BorderLayout.NORTH);
        balance.add(amountField, BorderLayout.SOUTH);
        add(balance, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
        depositButton.addActionListener(controller);
        withdrawButton.addActionListener(controller);
    }

    //Provides access to the amount entered into the field
    public double getAmount() {
        return Double.parseDouble(amountField.getText());
    }

    //Called by model when the model changes
    @Override
    public void update(Observable thing, Object o) {
        String balance = "";
        balance += NumberFormat.getCurrencyInstance().
                format(((BankAccountModel) thing).getBalance());
        String displayText = " Balance: " + balance;
        balanceLabel.setText(displayText);
    }
}
