/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs.tg3;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public abstract class Servicio {
    protected int codigo;
    protected String nombre;
    protected double monto;
    protected Date fecha;

    public Servicio(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        fecha = new Date();
    }

    @Override
    public String toString() {
        return "Servicio{" + "codigo=" + codigo + ", nombre=" + nombre + ", monto=" + monto + ", fecha=" + fecha + '}';
    }

    public final int getCodigo() {
        return codigo;
    }

    public final String getNombre() {
        return nombre;
    }

    public final Date getFecha() {
        return fecha;
    }
    
    public abstract double getMontoMensual();
    
}
