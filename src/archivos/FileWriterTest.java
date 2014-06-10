/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileWriterTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("Direccion: ");
            String path = lea.next();
            
            if(!path.equalsIgnoreCase("exit")){
                System.out.println("Append? (s/n): ");
                char app = lea.next().charAt(0);
                
                try(FileWriter fw=new FileWriter(path,app == 's')){
                   
                   do{
                       System.out.println("Texto a escribir: ");
                       String text = lea.nextLine();
                       
                       if(!text.equals("$%&")){
                           fw.write(text+"\n");
                           fw.flush();
                           
                       }
                       else
                           break;
                   }while(true);
                   
                }
                catch(IOException e){
                    System.out.println("error: " + e.getMessage());
                }
            }
            else
                break;
   
        }while(true);
    }
}
