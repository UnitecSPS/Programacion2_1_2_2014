/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author Docente 17082011
 */
public class Refrigerator implements InternetConnection, Cloneable {

    @Override
    public boolean makeConnection() {
        System.out.println("Trr Trrrr..Connection Stablished");
        return true;
    }

    @Override
    public int httpResultCode() {
        return 200;
    }

    @Override
    public String getDeviceType() {
        return "Refri";
    }
    
}
