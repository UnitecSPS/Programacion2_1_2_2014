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
    private boolean activa;
    private Date fechaUltimaModif;

    public CuentaAhorro(int n,String c,double sal){
        super(n,c);
        activa = true;
        fechaUltimaModif = new Date();
        saldo = sal;
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
}
