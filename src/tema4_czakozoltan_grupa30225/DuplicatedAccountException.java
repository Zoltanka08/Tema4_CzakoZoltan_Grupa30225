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
public class DuplicatedAccountException extends Exception{
    
    public DuplicatedAccountException() {};
    
    public DuplicatedAccountException(String message)
    {
        super(message);
    }
    
}
