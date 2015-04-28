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
public class SpendingAccount extends Account{

    private double gainPercentage = 1.2; 
    
    public SpendingAccount(double value, String IBAN, String PIN) {
        super(value, IBAN, PIN);
    }
    
    @Override
    public double withdrawMoney(double value)
    {
        if ((this.getValue()-value)<=-200) throw new AssertionError("Insufficient fund!");
        this.setValue(this.getValue() - value);
        return this.getValue();
    }
}
