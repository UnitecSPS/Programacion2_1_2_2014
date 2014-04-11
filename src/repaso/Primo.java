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
public class Primo {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        int num = lea.nextInt();
        int div = 0;
        
        for(int x=1; x <= num; x++){
            if( num % x == 0)
                div++;
        }
        
        if(div == 2)
            System.out.println("Es Primo");
        else
            System.out.println("No Es Primo");
    }
}
