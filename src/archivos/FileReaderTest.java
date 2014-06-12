/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileReaderTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.println("Archivo: ");
        String path = lea.next();
        
        try{
            //1- METODO
            File file = new File(path);
            FileReader reader = new FileReader(file);
            
            char buffer[] = new char[(int)file.length()];
            int bytesleidos = reader.read(buffer);
            
            System.out.println("CONTENIDOS\n--------");
            System.out.println(buffer);
            
            System.out.println("bl: " + bytesleidos + 
                    " length: " + file.length());
            
            //2- METODO
            reader = new FileReader(path);
            Scanner read = new Scanner(reader);
            read.useDelimiter(System.getProperty("line.separator"));
            
            while(read.hasNext()){
                String dato = read.next();
                System.out.println(dato);
            }
            
            
            reader.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
