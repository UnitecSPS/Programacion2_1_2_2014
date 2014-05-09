/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs.tg3;

/**
 *
 * @author Docente 17082011
 */
public class InternetService extends Servicio {

    public static final int V256 = 1;
    public static final int V512 = 2;
    public static final int V1M = 3;
    public static final int V2M = 4;
    private int tipoBanda;
    
    public InternetService(int codigo, String nombre, int tipo) {
        super(codigo, nombre);
        setTipoBanda(tipo);
    }

    @Override
    public double getMontoMensual() {
        switch(tipoBanda){
            case V256:
                monto = 15;
                break;
            case V512:
                monto = 25;
                break;
            case V1M:
                monto = 35;
                break;
            default:
                monto = 45;
        }
        return monto;
    }

    public final void setTipoBanda(int tipo) {
        switch(tipo){
            case V256:
            case V512:
            case V1M:
            case V2M:
                tipoBanda = tipo;
                break;
            default:
                tipoBanda = V256;
        }
    }

    @Override
    public String toString() {
        return super.toString()+" tipo banda:"+tipoBanda; 
    }
    
    
    
}
