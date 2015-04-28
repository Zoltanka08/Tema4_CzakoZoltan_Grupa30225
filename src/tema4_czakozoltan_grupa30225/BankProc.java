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
public interface BankProc {
    
    double readValue(String IBAN);
    void writeAccount(int value, String IBAN);
    void addAccount(Account acc) throws ExistingAccountException;
    void removeAccount(String IBAN, int index);
    int generateReport();
}
