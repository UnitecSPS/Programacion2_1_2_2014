/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria;

/**
 *
 * @author Docente 17082011
 */
public class ListChibolas {
    private Chibola inicio = null;
    
    public void add(Chibola chi){
        if( inicio == null ){
            inicio = chi;
        }
        else{
            Chibola tmp = inicio;
            while(tmp.siguiente != null){
                tmp = tmp.siguiente;
            }
            tmp.siguiente = chi;
        }
    }
    
    public void print(){
        Chibola tmp = inicio;
        
        while(tmp != null){
            System.out.println("-" + tmp.nombre);
            tmp = tmp.siguiente;
        }
    }
    
    public static void main(String[] args) {
        ListChibolas list = new ListChibolas();
        list.add( new Chibola("Andres") );
        list.add( new Chibola("Donaldo") );
        list.add( new Chibola("Juan") );
        list.add( new Chibola("Josseph") );
        list.print();
    }
}
