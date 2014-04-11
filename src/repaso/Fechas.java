/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repaso;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class Fechas {
    public static void main(String[] args) {
       
        Date d = new Date();
        Date hoy = new Date();
        Date old = new Date(100);
        
        if( d.compareTo(hoy) == 0  )
            System.out.println("Hoy paso despues de " + old);
        
        System.out.println("Milis de hoy = " + d.getTime());
        
        System.out.println("d = " + d);
        
        //-----------------------------------------
        Calendar c = Calendar.getInstance();
        c.set(1982, Calendar.AUGUST, 10);
        System.out.println("cal: " + c.getTime());
        c.add(Calendar.YEAR, 1);
        System.out.println("cal: " + c.getTime());
        c.add(Calendar.MONTH, 6);
        System.out.println("cal: " + c.getTime());
        
        System.out.println("Week of year = " + c.get(Calendar.MONTH));
        System.out.println("zona horario = " + c.getTimeZone());
        
       
    }
}
