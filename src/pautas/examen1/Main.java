/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen1;

/**
 *
 * @author Docente 17082011
 */
public class Main {
    public static void main(String[] args) {
        BlockBuster block = new BlockBuster();
        
        block.agregarItem(1, "Call of Duty", TipoItem.GAME);
        block.agregarItem(1, "Harry Potter", TipoItem.MOVIE);
    }
}
