/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

    FORMATO de equipos.tmn
    ---------------------------
    int codigo
    String nombre
    long fundacion
    String DT
    boolean esprimera
    int temporada actual

    FORMATO de temporada#.tmn
    -----------------------------
    int año inicio
    int año final
    int numero camisa
    String nombre
    int goles
    int asistencias
    int minutos
    double salario

 */

package archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
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
    
    public void printTeams()throws IOException{
        rTeam.seek(0);
        
        while(rTeam.getFilePointer() < rTeam.length()){
            int ce = rTeam.readInt();
            String team = rTeam.readUTF();
            Date fundacion = new Date(rTeam.readLong());
            String DT = rTeam.readUTF();
            boolean primera = rTeam.readBoolean();
            rTeam.readInt();
            
            System.out.printf("%d-%s Fundado en %s, DT: %s - %s\n",
                    ce,team,fundacion.toString(),DT,
                    primera ? "Primera" : "Segunda");
        }
    }

    private void createSeasonFile(String teamFolder,int nt) throws IOException{
        String path = teamFolder+"/temporada"+nt+".tmn";
        RandomAccessFile rSeason = new RandomAccessFile(path,"rw");
        Calendar c = Calendar.getInstance();
        int aa = c.get(Calendar.YEAR);
        c.add(Calendar.YEAR, 1);
        int af = c.get(Calendar.YEAR);
        rSeason.writeInt(aa);
        rSeason.writeInt(af);
        rSeason.close();
        System.out.printf("Creando temporada %d/%d....\n\n",aa,af);
    }
    
    private void addGoalsToPlayer(String teamFilePath,int nc,int gols)throws IOException{
        RandomAccessFile rSeason = new RandomAccessFile(teamFilePath,"rw");
        rSeason.skipBytes(8);
        while(rSeason.getFilePointer() < rSeason.length()){
            int numero = rSeason.readInt();
            rSeason.readUTF();
            long pos = rSeason.getFilePointer();
            int goles = rSeason.readInt();
            rSeason.skipBytes(16);
            
            if(numero == nc){
                rSeason.seek(pos);
                rSeason.writeInt(goles+gols);
                break;
            }
        }
        rSeason.close();
    }
    
}
