/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

/**
 *
 * @author Docente 17082011
 */
public abstract class Prestamo {
    protected double montoTotal, balanceActual, tasa;
    
    public Prestamo(double mt, double ta){
        montoTotal = mt;
        tasa = ta;
        balanceActual = mt;
    }
    
    public String toString(){
        return "monto="+montoTotal+" tasa="+tasa+
                " balance="+balanceActual;
    }
    
    public abstract void pagar(double monto);
}
