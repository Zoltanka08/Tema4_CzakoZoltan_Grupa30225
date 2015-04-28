/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4_czakozoltan_grupa30225;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Zoli
 */
public class Person {
    
    private Account PersonalAccount;
    private String name;
    private String mail;
    private String address;
    private String phone;
    
    public Person(Account account, String name, String mail, String address, String phone) throws InexistentAccountException, WrongEmailFormatException
    {
        if(isValidAccount(account))
            this.PersonalAccount = account;
        else 
            throw new InexistentAccountException("Account doesn't exists!");
        
        this.name = name;
        this.address = address;
        this.phone = phone;
        
        if(isValidMail(mail))
            this.mail = mail;
        else
            throw new WrongEmailFormatException("Wrong e-mail address!");        
    }
    
    public boolean isValidAccount(Account acc) {
        Bank bank = new Bank();
        if (bank.readValue(acc.getIBAN())!= -1)
            return true;
        else 
            return false;   
    }
    
    public boolean isValidMail(String email) {
        String pattern = "^[A-Z0-9._%-]+@[A-Z0-9.-]+.[A-Z]{2,4}$";
        
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        
        if (m.find( ))
            return true;
        else
            return false;    
    }
    
}
