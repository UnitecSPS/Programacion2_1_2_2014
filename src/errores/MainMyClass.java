/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errores;

import java.io.Closeable;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @author Docente 17082011
 */
public class MainMyClass{
    public static void main(String[] args) {
        System.out.println("Inicia el Main");
 
        try{
            MiClase mc = new MiClase();
            mc.A();
        }
        catch(InputMismatchException e){
            System.out.println("Escribi bien");
        }
        catch(ArithmeticException e){
            System.out.println("Error Matematico: " +
                    e.getMessage());
            
        }
        catch(NullPointerException e){
            System.out.println("Instancialo primero");
        }
        catch(Exception e){
           System.out.println("Error " + e.getClass() + " : " + e.getMessage());
           //e.printStackTrace(); 
        }
        finally{
            System.out.println("Este codigo siempre se ejecuta");
        }
        
        System.out.println("Finaliza el main");
    }

}
