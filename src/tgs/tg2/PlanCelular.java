/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs.tg2;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class PlanCelular {
    protected int numero;
    protected String cliente;
    protected Date fecha;
    protected double montoPorMin, montoPorMsgs;

    public PlanCelular(int numero, String cliente, double montoPorMin, double montoPorMsgs) {
        this.numero = numero;
        this.cliente = cliente;
        this.montoPorMin = montoPorMin;
        this.montoPorMsgs = montoPorMsgs;
        fecha = new Date();
    }

    @Override
    public String toString() {
        return "PlanCelular{" + "numero=" + numero + ", cliente=" + cliente + ", fecha=" + fecha + ", montoPorMin=" + montoPorMin + ", montoPorMsgs=" + montoPorMsgs + '}';
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMontoPorMin() {
        return montoPorMin;
    }

    public double getMontoPorMsgs() {
        return montoPorMsgs;
    }
    
    public double pagoMensual(int cm, int cmgs){
        return cm * montoPorMin + cmgs * montoPorMsgs;
    }
    
}
