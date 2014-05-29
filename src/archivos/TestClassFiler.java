/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class TestClassFiler {
    static Scanner lea = new Scanner(System.in);
    static MiArchivo mafile = new MiArchivo();
    
    public static void main(String[] args) {
        int op=0;
        
        do{
            System.out.println("1- Configurar Archivo");
            System.out.println("2- Crear Archivo");
            System.out.println("3- File Info.");
            System.out.println("4- Borrar");
            System.out.println("5- Crear Folder");
            System.out.println("6- Salir");
            System.out.println("Escoja Opcion: ");
            
            try{
                op = lea.nextInt();
                switch(op){
                    case 1:
                        System.out.println("Ingrese direccion: ");
                        mafile.setFile(lea.next());
                        break;
                    case 2:
                        crearFile();
                        break;
                    case 3:
                        mafile.info();
                        break;
                    case 4:
                        borrarFile();
                        break;
                    case 5:
                        crearFolder();
                        break;
                }
            }
            catch(NullPointerException e){
                System.out.println("Seleccione la opcion 1 primero");
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un valor valido");
                lea.next();
            }
            catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op!=6);
    }

    private static void crearFile()throws IOException {
        if( mafile.createFile() )
            System.out.println("ARCHIVO CREADO BIEN");
        else
            System.out.println("ARCHIVO NO SE PUDO CREAR");
    }

    private static void borrarFile() {
        if( mafile.deleteFile() )
            System.out.println("Borrado BIEN");
        else
            System.out.println("NO se pudo borrar");
    }

    private static void crearFolder() {
        if( mafile.createFolder() )
            System.out.println("Folder Creado Bien");
        else
            System.out.println("Folder no se pudo crear");
    }
}
