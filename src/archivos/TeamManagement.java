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
import java.io.FileWriter;
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
    
    public void addGoalsToPlayer(String teamFilePath,int nc,int gols)throws IOException{
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
    
    public boolean searchTeam(int teamcode)throws IOException{
        rTeam.seek(0);
        while(rTeam.getFilePointer() < rTeam.length() ){
            if(teamcode == rTeam.readInt())
                return true;
            rTeam.readUTF();
            rTeam.readLong();
            rTeam.readUTF();
            rTeam.skipBytes(5);
        }
        return false;
    }
    
    private boolean searchPlayer(RandomAccessFile file,int nc)throws IOException{
        file.seek(8);
        while(file.getFilePointer()<file.length()){
            if(nc==file.readInt())
                return true;
            file.readUTF();
            file.skipBytes(20);
        }
        return false;
    }
    
    /**
     1-Adiciona un nuevo jugador en la temporada actual de un equipo dado.
     * Los datos estadisticos del jugador por default se escriben en cero.
     * Se VALIDA que no exista ya un jugador con ese numero de camisa en el
     * archivo de la temporada.
     * @param teamCode CODIGO del Equipo
     * @param nc Numero de camisa del jugador
     * @param n Nombre del jugador
     * @param sal Salario del jugador
     * @return Si se pudo agregar el jugador o no
     */
    public boolean addPlayerToCurrentSeason(int teamCode,int nc,String n,double sal)throws IOException{
        if(searchTeam(teamCode)){
            String nombt = rTeam.readUTF();
            rTeam.readLong();
            rTeam.readUTF();
            rTeam.readBoolean();
            int ta = rTeam.readInt();
            
            String path = ROOT_FOLDER+"/"+teamCode+nombt+"/temporada"+ta+".tmn";
            try (RandomAccessFile rplayer = new RandomAccessFile(path, "rw")) {
                if(!searchPlayer(rplayer, nc)){
                    rplayer.seek(rplayer.length());
                    //int numero camisa
                    rplayer.writeInt(nc);
                    //String nombre
                    rplayer.writeUTF(n);
                    //int goles
                    rplayer.writeInt(0);
                    //int asistencias
                    rplayer.writeInt(0);
                    //int minutos
                    rplayer.writeInt(0);
                    //double salario
                    rplayer.writeDouble(sal);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 2-Imprime TODOS los datos del archivo de temporada actual de un equipo
     * dado, incluyendo claro, sus jugdores con TODAS sus estadisticas
     * @param teamCode 
     */
    public void printSeason(int teamCode)throws IOException{
        if(searchTeam(teamCode)){
            String nombt = rTeam.readUTF();
            rTeam.readLong();
            rTeam.readUTF();
            rTeam.readBoolean();
            int ta = rTeam.readInt();
            
            String path = ROOT_FOLDER+"/"+teamCode+nombt+"/temporada"+ta+".tmn";
            try (RandomAccessFile rplayer = new RandomAccessFile(path, "rw")){
                System.out.println("Año Inicial: "+rplayer.readInt());
                System.out.println("Año Final: "+rplayer.readInt());
                System.out.println("----LISTADO JUGADORES--------------");
                while(rplayer.getFilePointer() < rplayer.length()){
                    int nc = rplayer.readInt();
                    String n = rplayer.readUTF();
                    int goles = rplayer.readInt();
                    rplayer.skipBytes(8);
                    double sal = rplayer.readDouble();
                    System.out.printf("%d-%s Goles: %d Salario:$%.1f\n",
                            nc,n,goles,sal);
                    
                }
            }
        }
    }
    
    public void export(String txtPath)throws IOException{
        FileWriter fw = new FileWriter(txtPath);
        rTeam.seek(0);
        fw.write("LISTADO DE EQUIPOS\n-----------------\n");
        
        while(rTeam.getFilePointer() < rTeam.length()){
            int cod = rTeam.readInt();
            String n = rTeam.readUTF();
            rTeam.readLong();
            String dt = rTeam.readUTF();
            boolean primera = rTeam.readBoolean();
            rTeam.readInt();
            
            String team = cod + " - " + n + " - " + dt + " - Es de " +
                    (primera ? "Primera" : "Segunda" ) + "\n";
            
            fw.write(team);
        }
        
        fw.close();
    }
    
    //3- TODO: Funciones para adicionar asistencias y otros para minutos para un
    //jugador dado, al igual que hicimos con la de los goles.
    
    /**
     * 4- Actualiza la fecha de fundacion de un equipo existente. La 
     * fecha viene de parametro con el formado dd/mm/yyyy
     * @param teamCode Codigo del equipo
     * @param fecha Fecha de fundacion
     */
    public void updateFechaFundacion(int teamCode, String fecha){
        
    }
    
    /**
     * 5-Imprime los maximos goleadores (NOMBRE-EQUIPO-# GOLES) de
     * toda la temporada actual entre todos los equipos agregados al
     * sistema
     */
    public void topCurrentStrikers(){
        
    }
    
    /**
     * 6- Adicionar estas opciones en el MENU...en SuperCampeones.java
     */
    
}
