/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4_czakozoltan_grupa30225;

/**
 *
 * @author Zoli
 */
public class Account {
    
    protected String IBAN;
    protected double balance;
    protected Account next;
    protected String PIN;
    protected double gainPercentage = 1.5;
    
 
    Account(double value, String IBAN, String PIN) {
        this.balance = value;
        this.IBAN = IBAN;
        this.next = null;
        this.PIN = PIN;
    }
    
    public String getPIN() {
        return PIN;
    }
 
    public double getValue() {
        return balance;
    }
 
    public void setValue(double value) {
        this.balance = value;
    }
 
    public String getIBAN() {
        return IBAN;
    }
 
    public Account getNext() {
        return next;
    }
 
    public void setNext(Account next) {
        this.next = next;
    }
    
    public double withdrawMoney(double value) throws InsufficientMoneyException
    {
        if((this.getValue()-value)<=0)
            throw new  InsufficientMoneyException("Fonduri insuficiente!");
        this.setValue(this.getValue() - value);
        return this.getValue();
    }
    
    public void depositMoney(float value)
    {
        this.setValue(this.getValue() + value);
    }
    
    public double getBalance()
    {
        return this.getValue();
    }
}
