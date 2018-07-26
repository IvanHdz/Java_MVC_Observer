/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import model.BankAccountModel;

/**
 *
 * @author Viruz
 */
public class ManagerView extends JFrame implements Observer {

    private final JLabel label;

    public ManagerView() {
        setTitle("Bank Manager's view of the account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        label = new JLabel("nothing happened on account yet");
        add("Center", label);
        pack();
        setVisible(true);
    }

    /**
     * gets called when model is updated
     *
     * @param acc
     * @param blank
     */
    @Override
    public void update(Observable acc, Object blank) {
    //must have an Object in params too 
        double balance = ((BankAccountModel) acc).getBalance();
        label.setText(Double.toString(balance));
    }
}
