/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Viruz
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.BankAccountModel;
import view.BankAccountView;

public class BankAccountController
        implements ActionListener {

    private final BankAccountView view;
    private final BankAccountModel model;

    //Constructor
    public BankAccountController(BankAccountView view,
            BankAccountModel model) {
        this.view = view;
        this.model = model;
    }

    //Responds to a deposit or withdrawal event
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Withdraw":
                model.withdrawFunds(view.getAmount());
                break;
            case "Deposit":
                model.depositFunds(view.getAmount());
                break;
        }
    }
}
