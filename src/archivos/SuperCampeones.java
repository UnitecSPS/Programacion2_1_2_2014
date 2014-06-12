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
            System.out.println("5- Listar Temporada Actual");
            System.out.println("6- Export");
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
                    case 3:
                        System.out.println("Equipo #: ");
                        int ne = lea.nextInt();
                        System.out.println("Camisa #: ");
                        int nc = lea.nextInt();
                        System.out.println("Nombre: ");
                        String jug = lea.next();
                        System.out.println("Salario: ");
                        double sal = lea.nextDouble();
                        if( tmn.addPlayerToCurrentSeason(ne, nc, jug, sal)){
                            System.out.println("Agregado bien");
                        }
                        else{
                            System.out.println("No se pudo agregar");
                        }
                        break;
                    case 5:
                        System.out.println("Equipo #: ");
                        ne = lea.nextInt();
                        tmn.printSeason(ne);
                        break;
                    case 6:
                        System.out.println("Direccion de txt: ");
                        tmn.export(lea.next());
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
