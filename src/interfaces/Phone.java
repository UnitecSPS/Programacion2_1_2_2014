/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author Docente 17082011
 */
public abstract class Phone {
    protected int number;
    
    public Phone(int n){
        number = n;
    }
    
    public void call(){
        System.out.println("Making call");
    }
    
    public abstract void sendMsg();
}
