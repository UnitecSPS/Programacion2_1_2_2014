/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs.tg3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Sky {
    private ArrayList<Servicio> servicios;
    
    public Sky(){
        servicios = new ArrayList<>();
    }
    
    public void imprimirServicios(){
        int ctvs=0, cinter=0;
        for(Servicio serv : servicios){
            System.out.println(serv);
            
            if(serv instanceof TVService){
                ctvs++;
                ((TVService)serv).imprimirCanales();
            }
            else{
                cinter++;
            }
               
        }
        System.out.println("TVs: " + ctvs);
        System.out.println("Internets: " + cinter);
    }
    
    //EXTRA---para las busquedas
    public Servicio getServicio(int codigo){
        for(Servicio serv : servicios){
            if(codigo == serv.getCodigo())
                return serv;
        }
        return null;
    }
    
    public void agregarServicio(int c,String n,String serviceType){
        Scanner lea = new Scanner(System.in);

        if( getServicio(c) == null ){
            if(serviceType.equals("TV")){
                System.out.println("Digital?(s/n): ");
                char digi = lea.next().charAt(0);
                
                servicios.add( new TVService(c, n, digi == 's'));
            }
            else{
                System.out.println("Tipo Banda (1-4): ");
                int tipo = lea.nextInt();
                servicios.add(new InternetService(c, n, tipo));
            }
        }
    }
    
    public void agregarCanalATvService(int c, String canal){
        Servicio serv = getServicio(c);
        
        if(serv instanceof TVService){
            ((TVService)serv).agregarCanal(canal);
        }
    }
    
    public void cobrarPlan(int c){
        Servicio serv = getServicio(c);
        
        if( serv != null)
            System.out.println("Total: "+serv.getMontoMensual());
        else
            System.out.println("Servicio No existe");
    }
}
