/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class MiArchivo {
    private File file = null;
    
    public void setFile(String path){
        file = new File(path);
    }

    public boolean createFile()throws IOException {
        return file.createNewFile();
    }

    public void info() {
        System.out.println("FILE INFO\n----------");
        if(file.exists()){
            System.out.println("Nombre: " + file.getName());
            System.out.println("Dir Absoluta: " + file.getAbsolutePath());
            System.out.println("Path: " + file.getPath());
            System.out.println("Parent: " + file.getAbsoluteFile().getParentFile().getName());
            System.out.println("***");
            System.out.println("Size " + file.length() + " bytes");
            if(file.isFile())
                System.out.println("<ES ARCHIVO>");
            if(file.isDirectory()){
                System.out.println("<ES DIRECTORIO O FOLDER>");
                System.out.println("******CONTENIDO***************");
                dir();
            }
            if(file.isAbsolute())
                System.out.println("<CREADO CON DIRECC. ABSOLUTA");
            if(file.isHidden())
                System.out.println("<ESCONDIDO>");
            System.out.println("***");
            Date n = new Date(file.lastModified());
            System.out.println("Ultima Fecha de Modif.: " + n);
            System.out.println("******");
        }
        else{
            System.out.println("Archivo o Directorio NO EXISTE");
        }
    }

    public boolean deleteFile() {
        return file.delete();
    }

    public boolean createFolder() {
        return file.mkdirs();
    }
    
    public void dir(){
        if( file.isDirectory() ){
            File childs[] = file.listFiles();
            
            for(File child : childs){
                if( !child.isHidden() ){
                    Date ultima = new Date(child.lastModified());
                    System.out.print(ultima + "\t");

                    if(child.isDirectory())
                        System.out.print("<DIR>\t");
                    if(child.isFile()){
                        System.out.print("     \t");
                        System.out.print(child.length() + " ");
                    }
                    System.out.println(child.getName());
                }
            }
        }
    }
    
    
}
