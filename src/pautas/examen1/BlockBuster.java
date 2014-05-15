/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class BlockBuster {
    private ArrayList<BlockBusterItem> items;
    
    public BlockBuster(){
        items = new ArrayList<>();
    }
    
    public BlockBusterItem buscarItem(int cod, TipoItem tipo){
        for(BlockBusterItem bi : items){
            if(tipo == TipoItem.MOVIE && bi instanceof MovieItem || 
                    tipo == TipoItem.GAME && bi instanceof VideoGameItem){
                
                if( cod == bi.codigo )
                    return bi;
            }
        }
        return null; 
    }
    
    public void agregarItem(int cod, String no, TipoItem tipo){
        Scanner lea = new Scanner(System.in);
        
        if( buscarItem(cod, tipo) == null ){
            if(tipo == TipoItem.MOVIE ){
                double prec = lea.nextDouble();
                items.add( new MovieItem(cod,no,prec) );
            }
            else{
                String tipoconsol = lea.next();
                items.add( new VideoGameItem(cod,no,tipoconsol) );
            }
        }
    }
    
    public void rentar(int cod, TipoItem tipo, int dias){
        BlockBusterItem item = buscarItem(cod,tipo);
        
        if( item != null ){
            System.out.println(item);
            System.out.println("Total: " + item.pagoRenta(dias));
        }
    }
    
    public void auditarMovieEstado(){
        auditarMovieEstado(0);
    }

    private void auditarMovieEstado(int pos) {
        if(pos < items.size()){
            BlockBusterItem bi = items.get(pos);
            if( bi instanceof MovieItem )
                ((MovieItem)bi).evaluarEstado();
            auditarMovieEstado(pos+1);
        }
    }
}
