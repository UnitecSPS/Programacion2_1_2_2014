/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

/**
 *
 * @author Docente 17082011
 */
public class Granja {
    public static void main(String[] args) {
        //Animal ani = new Animal("muppet",2); NO PUEDO!
        Animal a1 = new Perro();
        Animal a2 = new Chihuahua();
        Animal a3 = new Gato();
        Animal a4 = Animal.getInstance(0);
        
        a1.hablar();
        a2.hablar();
        a3.hablar();
        a4.hablar();
        
        
        if(a4 instanceof Perro){
            System.out.println("Es Perro!");
        }
        else if(a4 instanceof Gato){
            System.out.println("Es Gato!");
        }
        else if(a4 instanceof Animal){
            System.out.println("Es animal!");
        }
        else{
            System.out.println("No se que sos :(");
        }
    }
}
