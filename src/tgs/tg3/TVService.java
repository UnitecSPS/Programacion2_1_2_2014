/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs.tg3;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class TVService extends Servicio {
    private ArrayList<String> canales;
    private boolean digital;
    
    public TVService(int codigo, String nombre, boolean d) {
        super(codigo, nombre);
        digital = d;
        canales = new ArrayList<>();
    }
    
    public void agregarCanal(String canal){
        if(!canales.contains(canal))
            canales.add(canal);
    }

    @Override
    public double getMontoMensual() {
        monto = digital ? canales.size()*8 : canales.size()*5;
        return monto;
    }

    @Override
    public String toString() {
        return super.toString()+ " digital:"+digital; 
    }
    
    public void imprimirCanales(){
        for(String c : canales)
            System.out.println("-"+c);
    }
    
}
