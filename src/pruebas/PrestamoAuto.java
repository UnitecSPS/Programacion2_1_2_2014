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
public class PrestamoAuto extends Prestamo {
    private double montoSeguro;
    
    public PrestamoAuto(double mt){
        super(mt,0.09);
        montoSeguro = mt * 0.3;
    }
    
    public String toString(){
        return super.toString()+" montoSeguro="+montoSeguro;
    }

    @Override
    public void pagar(double monto) {
        balanceActual -= monto;
    }
    
    public double getMontoSeguro(){
        return montoSeguro;
    }
    
}
