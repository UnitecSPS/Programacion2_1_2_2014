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
public class WWW {
    public static void main(String[] args) {
        InternetConnection ic = new Refrigerator();
        
        if(ic instanceof InternetConnection)
            System.out.println("SII LO ES!");
        
        ic.makeConnection();
        
        InternetConnection test = new InternetConnection() {

            @Override
            public boolean makeConnection() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int httpResultCode() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getDeviceType() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
