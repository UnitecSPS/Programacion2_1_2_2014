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
public abstract class BlockBusterItem {
    protected int codigo;
    protected String nombre;
    protected double precio;
    protected Date fecha;
    protected TipoItem tipo;
    
    public BlockBusterItem(int c, String n, double p){
        codigo = c;
        nombre = n;
        precio = p;
        fecha = new Date();
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nombre=" + nombre 
                + ", precio=" + precio;
    }
    
    public abstract double pagoRenta(int dias);
    public abstract TipoItem getTipo();
}
