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
public abstract class Animal {
    protected String raza;
    protected int patas;

    public Animal(String raza, int patas) {
        this.raza = raza;
        this.patas = patas;
    }

    public String getRaza() {
        return raza;
    }

    public int getPatas() {
        return patas;
    }

    @Override
    public String toString() {
        return "raza="+raza+" #patas: " + patas; 
    }
    
    public abstract void hablar();
    
    public static Animal getInstance(int op){
        if(op==0)
            return new Perro();
        else
            return new Gato();
    }
    
}
