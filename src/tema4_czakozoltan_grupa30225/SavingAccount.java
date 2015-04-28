/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4_czakozoltan_grupa30225;

import java.time.LocalDateTime;
import java.util.Date;


/**
 *
 * @author Zoli
 */
public class SavingAccount extends Account{
    
    private Date startingDate;
    private Date endingDate;
    private double C = 2.5;

    public SavingAccount(double value, String IBAN, String PIN, Date start, Date end) {
        super(value, IBAN, PIN);
        this.startingDate = start;
        this.endingDate = end;
    }
    
    public Date getEndingDate()
    {
        return this.endingDate;
    }
    
    public Date getStartingDate()
    {
        return this.startingDate;
    }
     
    @Override
    public double withdrawMoney(double value) 
    {
        Date d = new Date();
        if (!(this.getEndingDate().equals(d))) throw new AssertionError("Your money is locked until " + this.endingDate);
        assert (this.getValue()-value)<=0:"Insufficient fund!";
        this.setValue(this.getValue() - value);
        return this.getValue();
    }
}
