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
    
    
}
