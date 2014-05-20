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
    public void A(){
        System.out.println("Inicia A");
        B();
        System.out.println("Finaliza A");
    }

    private void B() {
        System.out.println("Inicia B");
        Scanner lea = new Scanner(System.in);
        lea.nextInt();
        System.out.println("Finaliza B");
    }
}
