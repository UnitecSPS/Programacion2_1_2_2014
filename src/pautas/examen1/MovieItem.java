/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.examen1;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class MovieItem extends BlockBusterItem {
    private String estado;
    
    public MovieItem(int c, String n, double p){
        super(c,n,p);
        estado = "ESTRENO";
    }

    @Override
    public String toString() {
        return super.toString() + " estado:" + estado + "-Movie"; 
    }
    
    @Override
    public double pagoRenta(int dias){
        if(estado.equals("ESTRENO") && dias > 2)
            return precio + (dias-2) * 50;
        else if(estado.equals("NORMAL") && dias > 5)
            return precio + (dias-5) * 30;
        return precio;
    }
    
    public void evaluarEstado(){
        Date now = new Date();
        long diff = now.getTime() - fecha.getTime();
        long secs = diff / 1000;
        long mins = secs / 60;
        long hrs = mins / 60;
        long dias = hrs / 24;
        long meses = dias/30;
        
        if( meses >= 5 )
            estado = "NORMAL";
    }

    @Override
    public TipoItem getTipo() {
        return TipoItem.MOVIE;
    }
}
