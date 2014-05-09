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
public class TestServices {
    public static void main(String[] args) {
        Sky sky = new Sky();
        
        sky.agregarServicio(1,"Carlos", "TV");
        sky.agregarServicio(1,"Carlos", "INTERNET");//ya existe, no se agrega
        sky.agregarServicio(2,"Carlos", "INTERNET");
        
        sky.agregarCanalATvService(1, "HBO");
        sky.agregarCanalATvService(2, "HBO"); //no haria nada
        
        sky.imprimirServicios();
        
        sky.cobrarPlan(1);
        sky.cobrarPlan(2);
        sky.cobrarPlan(3);//no existe
    }
}
