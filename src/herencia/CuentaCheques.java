/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class CuentaCheques extends CuentaBancaria {
    private ArrayList<Cheque> cheques;
    private int contador=1;

    public CuentaCheques(int numero, String cliente) {
        super(numero, cliente);
        cheques = new ArrayList<>();
    }

    @Override
    public boolean retirar(double monto) {
        Cheque ch = new Cheque(contador++,
            monto, super.retirar(monto) );
        cheques.add(ch);
        return ch.valido;
    }

    @Override
    public String toString() {
        return super.toString() + " Cheques Cambiados="+contador; 
    }
    
    public void printCheques(){
        for(Cheque ch : cheques){
            System.out.println(ch);
        }
    }
    
}
