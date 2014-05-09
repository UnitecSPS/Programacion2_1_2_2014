/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs.tg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Tigo {
    static ArrayList<PlanCelular> planes = new ArrayList<>();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {    
        
        int op;
        
        do{
            System.out.println("1- Agregar plan");
            System.out.println("2- Pagar");
            System.out.println("3- Editar Email");
            System.out.println("4- Agregar Amigo");
            System.out.println("5- Ver Plan");
            System.out.println("6- Salir");
            System.out.println("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    agregarPlan();
                    break;
                case 2:
                    System.out.println("Numero del telefono: ");
                    pagarPlan(lea.nextInt());
                    break;
                case 3:
                    System.out.println("Numero del telefono: ");
                    editarEmail(lea.nextInt());
                    break;
                case 4:
                    System.out.println("Numero del telefono: ");
                    agregarAmigo(lea.nextInt());
                    break;
                case 5:
                    System.out.println("Numero del telefono: ");
                    verPlan(lea.nextInt());
            }
        }while(op!=6);
    }

    private static PlanCelular buscar(int n){
        for(PlanCelular pc :  planes){
            if(pc.getNumero() == n)
                return pc;
        }
        return null;
    }
    
    private static void agregarPlan() {
        System.out.println("Nombre: ");
        String n = lea.next();
        System.out.println("Numero: ");
        int num = lea.nextInt();
        
        if(buscar(num) == null){
            System.out.println("Tipo: ");
            String tipo = lea.next();
            
            if(tipo.equalsIgnoreCase("IPHONE"))
                planes.add(new PlanIphone(num, n));
            else{
                System.out.println("Pin: ");
                String pin = lea.next();
                planes.add(new PlanBlackBerry(num, n, pin));
            }
            
        }
            
    }

    private static void pagarPlan(int numero) {
        PlanCelular pc = buscar(numero);
        
        if(pc != null){
            System.out.println("cant min: ");
            int cms = lea.nextInt();
            System.out.println("Cant msgs: ");
            int cmgs = lea.nextInt();
            
            double monto = pc.pagoMensual(cms, cmgs);
            
            System.out.println("Total: "+ monto);
        }
    }

    private static void editarEmail(int numero) {
       PlanCelular pc = buscar(numero);
       
       if(pc instanceof PlanIphone){
           System.out.println("Email: ");
           String email = lea.next();
           ((PlanIphone)pc).setCorreo(email);
       }
    }

    private static void verPlan(int numero) {
        PlanCelular pc = buscar(numero);
        
        if(pc != null){
            System.out.print(pc);
            if(pc instanceof PlanIphone)
                System.out.println(" -- IPHONE");
            else{
                System.out.println(" -- BLACKBERRY");
                ((PlanBlackBerry)pc).printPins();
            }
                
        }
    }

    private static void agregarAmigo(int numero) {
       PlanCelular pc = buscar(numero);
       
       if(pc instanceof PlanBlackBerry){
           System.out.println("Pin Amigo: ");
           String pin = lea.next();
           ((PlanBlackBerry)pc).addPin(pin);
       }
    }
}
