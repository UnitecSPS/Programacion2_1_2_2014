/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author Docente 17082011
 */
public class Granja {
    public static void main(String[] args) {
        PS3 ps3 = new PS3();
        
        if( ps3 instanceof Patito){
            System.out.println("Que se vayan a nadar....");
        }
    }
}
