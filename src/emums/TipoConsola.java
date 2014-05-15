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
public enum TipoConsola {
    PS3(30), XBOX(50), WII(20);
    private int precio;
    int test;
    
    private TipoConsola(int p){
        precio = p;
    }
    
    public int getPrecio(){
        return precio;
    }
}
