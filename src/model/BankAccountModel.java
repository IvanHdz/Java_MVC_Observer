/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Viruz
 */
public class BankAccountModel extends Observable {

    private double balance;

    public BankAccountModel(double initDeposit) {
        setBalance(initDeposit);
    }

    private void setBalance(double newBalance) {
        balance = newBalance;
        setChanged();
        notifyObservers();
    }

    public double getBalance() {
        return balance;
    }

    public void depositFunds(double amount) {
        setBalance(getBalance() + amount);
    }

    public void withdrawFunds(double amount) {
        if (amount > getBalance()) {
            amount = getBalance();
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
