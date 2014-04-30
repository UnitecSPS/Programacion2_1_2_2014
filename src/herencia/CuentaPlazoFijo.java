/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class CuentaPlazoFijo extends CuentaAhorro {
    private double interesesGanados;
    private Date fechaFinPlazo;

    public CuentaPlazoFijo(int n, String c, double sal) {
        super(n, c, sal);
        interesesGanados = 0;
        tasa = 0.09;
        fechaFinPlazo = new Date();
    }

    @Override
    public void registrarIntereses() {
        Date now = new Date();
        
        if( now.before(fechaFinPlazo) )
            interesesGanados += saldo * tasa;
    }

    @Override
    public boolean retirar(double monto) {
        if( interesesGanados > monto ){
            interesesGanados -= monto;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + 
                " fecha fin de plazo= " + fechaFinPlazo; 
    }
    
    
    //fecha debe ser en el formato dd/mm/aaaa
    public void setFechaFinPlazo(String fecha){
        String datos[] = fecha.split("/");
        Calendar c = Calendar.getInstance();
        
        int y = Integer.parseInt(datos[2]);
        int m = Integer.parseInt(datos[1]);
        int d = Integer.parseInt(datos[0]);
        
        c.set(y, m-1, d);
        
        fechaFinPlazo = c.getTime();
    }
    
}
