/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Docente 17082011
 */
public class MiClase {
    int array[] = new int[3];
    
    public MiClase()throws AndresException{
        
    }
    
    public void A()throws AndresException{
        System.out.println("Inicia A");
        B();
        System.out.println("Finaliza A");
    }

    /**
     * 
     * @throws AndresException sdskdjksjdksjdksjsj
     */
    private void B()throws AndresException {
        System.out.println("Inicia B");
        Scanner lea = new Scanner(System.in);
        int x = lea.nextInt();
        double div = 10/x;
        if(x <= 5)
            array[x] = 3;
        if( x > 10000)
            throw new AndresException();
        System.out.println("Finaliza B");
    }
}
