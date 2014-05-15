/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emums;

/**
 *
 * @author Docente 17082011
 */
public class SimuladorTipoConsola {
    private int ordinal;
    private double precio;
    public static final SimuladorTipoConsola PS3 = new SimuladorTipoConsola(0,30);
    public static final SimuladorTipoConsola XBOX = new SimuladorTipoConsola(1,50);
    public static final SimuladorTipoConsola WII = new SimuladorTipoConsola(2,20);
    
    private SimuladorTipoConsola(int o, double p){
        ordinal = o;
        precio = p;
    }
    
    public int ordinal(){
        return ordinal;
    }
    
    public double getPrecio(){
        return precio;
    }
}
