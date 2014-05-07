/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class BAC {
    public static void main(String[] args) {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
             
        cuentas.add(new CuentaBancaria(1, "Marlon"));
        cuentas.add(new CuentaAhorro(2, "Leonel", 500));
        cuentas.add(new CuentaCheques(3, "Nimer"));
        cuentas.add(new CuentaPlazoFijo(4, "Andres", 100000));
        
        for(CuentaBancaria cb : cuentas){
            System.out.println(cb);
            
            if(cb instanceof CuentaCheques){
                ((CuentaCheques)cb).printCheques();
            }
            
        }
        
        CuentaBancaria cuentaABuscar = new CuentaBancaria(3, "");
        if( cuentas.contains(cuentaABuscar) )
            System.out.println("Si existe en la pos: " + 
                    cuentas.indexOf(cuentaABuscar));
        else
            System.out.println("No existe");
    }
}
