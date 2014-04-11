/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repaso;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Palindromo {
    public static void main(String[] args) {
        char arreglo[];
        Scanner lea = new Scanner(System.in);
        System.out.println("Cauntos? ");
        int cuantos = lea.nextInt();
        arreglo = new char[cuantos];
        
        for(int pos=0; pos < arreglo.length; pos++){
            arreglo[pos] = lea.next().charAt(0);
        }
        
        boolean pali = true;
        int fin = arreglo.length - 1;
        
        for(int inicio=0; inicio < fin; inicio++){
            if( arreglo[inicio] != arreglo[fin] ){
                pali = false;
                break;
            }
            fin--;
        }
        
        if( pali )
            System.out.println("Es Palindromo");
        else
            System.out.println("No es palindromo");
            
                
        
        
    }
}
