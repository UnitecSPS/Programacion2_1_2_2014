/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs.tg2;

/**
 *
 * @author Docente 17082011
 */
public class PlanIphone extends PlanCelular {
    private String correo;

    public PlanIphone(int num,String cli) {
        super(num,cli,1.5,0.4);
        correo = "";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return super.toString() + " correo: " + correo;
    }

    @Override
    public double pagoMensual(int cm, int cmgs) {
        double monto = 1500;
        if(cm > 600 )
            monto += (cm-600) * montoPorMin;
        if(cmgs > 1000)
            monto += (cmgs-1000) * montoPorMsgs;
        return monto; 
    }
    
    
    
    
    
}
