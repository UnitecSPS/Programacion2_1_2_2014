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
public class IPhone extends Phone implements InternetConnection {

    public IPhone(int n){
        super(n);
    }
    
    public String getItunes(){
        return "ii@itunes.com";
    }
    
    @Override
    public void sendMsg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makeConnection() {
        System.out.println("Wiu Wiu Wiu..Connection Stablished");
        return true;
    }

    @Override
    public int httpResultCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeviceType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
