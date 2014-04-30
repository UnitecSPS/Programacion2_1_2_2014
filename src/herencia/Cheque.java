/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class Cheque {
    public int numero;
    public double monto;
    public Date fecha;
    public boolean valido;

    public Cheque(int numero, double monto, boolean valido) {
        this.numero = numero;
        this.monto = monto;
        this.valido = valido;
        fecha = new Date();
    }

    @Override
    public String toString() {
        return "Cheque{" + "numero=" + numero + ", monto=" + monto + ", fecha=" + fecha + ", valido=" + valido + '}';
    }
    
    
}
