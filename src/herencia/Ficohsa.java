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
        CuentaBancaria ca = new CuentaAhorro();
        ca.cliente = "Carlos";
        ca.numero = 3;
    }
}
