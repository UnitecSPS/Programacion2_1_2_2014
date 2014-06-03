/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class TeamManagement {
    private RandomAccessFile rTeam;
    public static final String ROOT_FOLDER = "SuperCampeones";
    
    public TeamManagement(){
        initRootFolder();
        try{
            rTeam = new RandomAccessFile(ROOT_FOLDER+"/equipos.tmn", "rw");
            initCodigosFile();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void initRootFolder() {
        File f = new File(ROOT_FOLDER);
        f.mkdir();
    }

    private void initCodigosFile() throws IOException{
        RandomAccessFile rCodes = 
                new RandomAccessFile(ROOT_FOLDER+"/codigos.tmn", "rw");
        
        if(rCodes.length() == 0){
            rCodes.writeInt(1);
        }
        
        rCodes.close();
    }
    
    private int getCodigo()throws IOException{
        RandomAccessFile rCodes = 
                new RandomAccessFile(ROOT_FOLDER+"/codigos.tmn", "rw");
        
        int codigo = rCodes.readInt();
        rCodes.seek(0);
        rCodes.writeInt(codigo+1);
        
        rCodes.close();
        return codigo;
    }
    
    public void addEquipo(String n, String dt)throws IOException{
        rTeam.seek( rTeam.length() );
        //codigo
        int code = getCodigo();
        rTeam.writeInt(code);
        //nombre
        rTeam.writeUTF(n);
        //fecha
        Date fecha = new Date();
        rTeam.writeLong(fecha.getTime());
        //DT
        rTeam.writeUTF(dt);
        //es primera
        rTeam.writeBoolean(true);
        //num temporada actual
        rTeam.writeInt(1);
        
        //create team folder
        String tfolder = ROOT_FOLDER+"/"+code+n;
        File dir = new File(tfolder);
        dir.mkdir();
        
        createSeasonFile(tfolder,1);
    }

    private void createSeasonFile(String teamFolder,int nt) throws IOException{
        
    }
}
