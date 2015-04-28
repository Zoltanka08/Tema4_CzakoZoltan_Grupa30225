/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4_czakozoltan_grupa30225;

import java.util.Date;

/**
 *
 * @author Zoli
 */
public class BussinesLogic {
    
    private Bank bank = new Bank();
    
    public void initMyBank(String fileName, int type)
    {
        this.bank.bankInitializer(fileName, type);
    }
    
    public Bank getBank()
    {
        return this.bank;
    }
    
    public void addNewAccount(String IBAN, String PIN, String balance, int type) throws NumberFormatException, ExistingAccountException, EmptyFieldException
    {
        if (IBAN == null || IBAN.trim().length()<=1) 
            throw new EmptyFieldException("Too few caracters in IBAN  field");
        if (PIN == null || PIN.trim().length()<=1) 
            throw new EmptyFieldException("Too few caracters in PIN  field");
        if (balance == null || balance.trim().length()<=1) 
            throw new EmptyFieldException("Too few caracters in Balance  field");
        
        double value;
        Account acc = null;
        
        value = Double.parseDouble(balance);
        
        switch(type)
        {
            case 0: acc = new Account(value,IBAN,PIN);break;
            case 1: acc = new SpendingAccount(value,IBAN,PIN);break;
            case 2:
                Date start = new Date();
                Date end = new Date();
                end.setDate(start.getDate()+200); 
                acc = new SavingAccount(value,IBAN,PIN,start,end);
                break;
            default:
                assert false: "Wrong account type!";
        }
        this.bank.addAccount(acc);   
    }
    
    public void removeSelectedAccount(String account, int index)
    {
        String tokens[] = account.split(" ");
        this.bank.removeAccount(tokens[0],index);
    }
    
    public Account verifyAccount(String IBAN, String PIN) throws InexistentAccountException
    {

        return this.bank.findAccount(IBAN);   
    }
    
    public boolean wellFormed() throws WrongAccountTypeException, DuplicatedAccountException
    {
        int i;
        Account[] table = bank.getTable();
        
        for(i=0;i<bank.sizeOfHash();i++)
        {
            Account entry = table[i];
            while(entry!=null)
            {
                if( !(entry instanceof Account) && !(entry instanceof SavingAccount) && !(entry instanceof SpendingAccount))
                {
                    throw new WrongAccountTypeException("An account has wrong type!");
                }
                if(!entry.getClass().equals(SpendingAccount.class))
                {
                    if(entry.getBalance()<-200) 
                        return false;
                }
                else
                {
                    if(entry.getBalance()<0)
                        return false;
                }
                entry = entry.getNext();
            }
            
           Account toVerify = table[i];
           Account verificator = table[i];
 
           while(toVerify!=null)
           {    
               while(verificator!=null)
               {
                   if(!toVerify.equals(verificator))
                       if(toVerify.getIBAN().equals(verificator.getIBAN()))
                           throw new DuplicatedAccountException("Duplicated IBAN!");
                   verificator = verificator.getNext();
               }
               toVerify = toVerify.getNext();
           }
        }
     
        return true;
    }
    
}
