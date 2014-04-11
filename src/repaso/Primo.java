/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repaso;

/**
 *
 * @author Docente 17082011
 */
public class Primo {
    public static void main(String[] args) {
        int num = 7;
        int div = 0;
        
        for(int x=1; x <= num; x++){
            if( div % num == 0)
                div++;
        }
        
        if(div == 2)
            System.out.println("Es Primo");
        else
            System.out.println("No Es Primo");
    }
}
