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
public class CuentaAhorro extends CuentaBancaria {
    protected boolean activa;
    protected Date fechaUltimaModif;
    protected double tasa;

    public CuentaAhorro(int n,String c,double sal){
        super(n,c);
        activa = true;
        fechaUltimaModif = new Date();
        saldo = sal;
        tasa = 0.03;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }

    /**
     * 
     * @return 
     */
    public boolean isActiva() {
        numero = 3;
        return activa;
    }

    public Date getFechaUltimaModif() {
        return fechaUltimaModif;
    }
    
    @Override
    public void quienSoy(){
        super.quienSoy();
        System.out.println("SOY LA AHORRATIVA");
    }

    @Override
    public String toString() {
        return super.toString() + " Activa=" + activa + 
                " tasa=" + tasa; 
    }
    
    
    @Override
    public void deposito(double m){
        if( !activa )
            m = m * 0.9;
        super.deposito(m);
        fechaUltimaModif = new Date();
    }

    @Override
    public boolean retirar(double monto) {
        if( activa ){
            fechaUltimaModif = new Date();
            return super.retirar(monto);
        }
        return false;
    }
    
    public void registrarIntereses(){
        if( activa )
            saldo += saldo * tasa;
    }
    
    
    
}
