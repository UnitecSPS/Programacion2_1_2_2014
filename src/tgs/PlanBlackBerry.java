/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tgs;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class PlanBlackBerry extends PlanCelular {
    private String pin;
    private ArrayList<String> pines;
    
    public PlanBlackBerry(int num,String cli, String p){
        super(num,cli,2,0.3);
        pin = p;
        pines = new ArrayList<>();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return super.toString() + " pin: " + pin; 
    }

    @Override
    public double pagoMensual(int cm, int cmgs) {
        return super.pagoMensual(cm, cmgs) + 800; 
    }

    public void addPin(String pinamigo){
        if(!pines.contains(pinamigo))
            pines.add(pinamigo);
    }
    
    public void printPins(){
        for(String p : pines)
            System.out.println("-" + p);
    }
    
}
