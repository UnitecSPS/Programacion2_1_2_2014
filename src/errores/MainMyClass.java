/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.util.InputMismatchException;

/**
 *
 * @author Docente 17082011
 */
public class MainMyClass {
    public static void main(String[] args) {
        System.out.println("Inicia el Main");
        MiClase mc = new MiClase();
        try{
            mc.A();
        }
        catch(InputMismatchException e){
            System.out.println("Error: " + 
                    e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Finaliza el main");
    }
}
