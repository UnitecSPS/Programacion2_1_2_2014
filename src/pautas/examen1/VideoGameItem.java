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
public class VideoGameItem extends BlockBusterItem {
    private String tipoConsola;
    
    public static final String PLAYSTATION = "PS3";
    public static final String XBOX = "XBOX";
    public static final String WII = "Wii";
    
    public VideoGameItem(int c, String n, String tipo){
        super(c,n,30);
        tipoConsola = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + tipoConsola + "-Game"; 
    }
    
    @Override
    public double pagoRenta(int dias){
        return dias * precio;
    }
    
    @Override
    public TipoItem getTipo() {
        return TipoItem.GAME;
    }
}
