/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Prueba3 {
    static Scanner lea = new Scanner(System.in);
    static int arr[] = new int[3];
    
    public static void main(String[] args) {
        //ingresarArreglo();
        ingresarArregloRecursivo();
    }

    private static void ingresarArreglo() {
        do{
            try{
                System.out.println("La posicion: ");
                int pos = lea.nextInt();
                System.out.println("Valor: ");
                lea.close();
                arr[pos] = lea.nextInt();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un Entero");
                lea.next();
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Coordenada no Valida");
                break;
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
                break;
            }
            
        }while(true);
    }
    
    private static void ingresarArregloRecursivo() {
        Scanner lea2 = new Scanner(System.in);
        try{
            System.out.println("La posicion: ");
            int pos = lea2.nextInt();
            System.out.println("Valor: ");
            arr[pos] = lea2.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Ingrese un Entero");
            ingresarArregloRecursivo();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Coordenada no Valida");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
