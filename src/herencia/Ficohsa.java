/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

/**
 *
 * @author Docente 17082011
 */
public class Ficohsa {
    public static void main(String[] args) {
        //UPCASTING
        CuentaBancaria ca = new CuentaAhorro(1,"Luis",7000);
        CuentaBancaria cb = new CuentaBancaria(2, "Marlon");
        
        System.out.println("saldo: " + ca.saldo);
        
        cb.quienSoy();
        ca.quienSoy();
        
    }
}
