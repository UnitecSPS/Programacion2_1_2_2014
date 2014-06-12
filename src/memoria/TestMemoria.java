/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class TestMemoria {
    public static void main(String[] args) {
        Chibola ch1 = new Chibola("Andres");
        Chibola ch2 = ch1;
        
        ch2.nombre = "Josselyn";
        
        System.out.println("n1: " + ch1.nombre);
        System.out.println("n2: " + ch2.nombre);
        
        if( ch1 == ch2 )
            System.out.println("Si estan en el mismo espacio");
        
        
        String x = "hola";
        Scanner lea = new Scanner(System.in);
        String y = lea.next();
        
        if( x == y )
            System.out.println("Cadenas Iguales");
        else
            System.out.println("Cadenas distintas");
    }
}
