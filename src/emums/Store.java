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
public class Store {
    public int pagar(TipoConsola tipo){
        tipo.test = 3;
        System.out.println("tipo: " + tipo.test);
        return tipo.getPrecio();
    }
    
    public void testSimulador(){
        TipoConsola.PS3.ordinal();
        SimuladorTipoConsola stc = SimuladorTipoConsola.PS3;
        //stc.getPrecio()
        
    }
    
    public static void main(String[] args) {
        Store s = new Store();
        double p = s.pagar(TipoConsola.PS3);
        System.out.println("Precio a pagar: " + p);
    }
}
