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
public class SuperCampeones {
    public static void main(String[] args) {
        TeamManagement tmn = new TeamManagement();
        int op=0;
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("1- Adicionar Equipo");
            System.out.println("2- Listar Equipos");
            System.out.println("3- Agregar Jugadores a Temporada");
            System.out.println("4- Adicionar goles a Jugador");
            System.out.println("9- Salir");
            System.out.println("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        System.out.println("Nombre: ");
                        String team = lea.next();
                        System.out.println("dt: ");
                        String dt = lea.next();
                        tmn.addEquipo(team, dt);
                        break;
                    case 2:
                        tmn.printTeams();
                        break;
                }
                
            }
            catch(InputMismatchException e){
                lea.next();
            }
            catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op!=9);
    }
}
