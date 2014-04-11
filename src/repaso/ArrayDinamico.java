/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repaso;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class ArrayDinamico {
    public static void main(String[] args) {
        ArrayList<Alumno> arr = new ArrayList<>();
        arr.add(new Alumno(1,"Marlon"));
        arr.add(new Alumno(2,"Nimer"));
        arr.add(new Alumno(3,"Josue"));
        
        //size
        System.out.println("arr size = " + arr.size());
        
        //recorrer
        for(int pos=0; pos < arr.size(); pos++){ 
            System.out.println("Alumno = " + arr.get(pos).getNombre() );
            
        }
        
        for(Alumno al : arr){
            System.out.println("al = " + al.getNombre());
        }
    }
}
