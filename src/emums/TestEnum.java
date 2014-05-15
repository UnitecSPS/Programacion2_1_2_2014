/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emums;

/**
 *
 * @author Docente 17082011
 */
public class TestEnum {
    public static void main(String[] args) {
        Meses mes;
        
        mes = Meses.DECEMBER;
        
        System.out.println("mes: " + mes.name() + " ordinal: " + 
                mes.ordinal());
        
        //----Asignar por medio de una String
        String m = "MARCH";
        mes = Meses.valueOf(m);
        
        System.out.println("mes: " + mes.name() + " ordinal: " + 
                mes.ordinal());
        
        //cada elemento de la enum es un OBJETO INSTANCIADO
        System.out.println("mes: " + Meses.FEBRUARY.name() + " ordinal: " + 
                Meses.FEBRUARY.ordinal());
        
        //comparar enums
        
        //if
        if( mes == Meses.JANUARY )
            System.out.println("si es january");
        else
            System.out.println("No es january, es " + mes);
        
        //switch
        switch(mes){
            case JANUARY:
                System.out.println("Primer mes del año");
                break;
            case FEBRUARY:
                System.out.println("Mes del amor");
                break;
            case MARCH:
                System.out.println("Mes del calor");
                break;
            case DECEMBER:
                System.out.println("Mes de la navidad");
                
        }
        
        if(mes.ordinal() == 0 )
            System.out.println("si es 0");
        else
            System.out.println("No es 0, es " + mes.ordinal());
        
        
        if(mes.equals(Meses.MARCH))
            System.out.println("si es March");
        else
            System.out.println("No es March, es " + mes);
        
        
        if(mes.name().equals(Meses.MARCH.name()))
            System.out.println("si es march");
        else
            System.out.println("No es march, es " + mes);
        
        //recorrer
        for(Meses ms : Meses.values()){
            System.out.println("-" + ms);
        }
    }
}
