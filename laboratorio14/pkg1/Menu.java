/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio14.pkg1;

import java.util.Scanner;
import static laboratorio14.pkg1.VideoJuego.VideoJuego1;
import static laboratorio14.pkg1.VideoJuego.VideoJuego2;


/**
 *
 * @author asus
 */
public class Menu {
    public static void Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t***********BIENEVENIDO A RSHDRAV***********");
        System.out.println("\t[1] JUGAR");
        System.out.println("\t[2] SALIR DEL JUEGO");
        System.out.println("\tEscoja una opcion: ");
        int opcion = sc.nextInt();
        Seleccion(opcion);
    }

    private static void Seleccion(int opcion) {
        switch(opcion){
            case 1: 
                Menu2();
                break;
            case 2:
                System.out.println("\t***********FIN DEL JUEGO***********");
                break;
            default: 
                System.out.println("\tNo existe esa opcion");
                System.out.println("\tIntente de nuevo: ");
                Menu();
        }
    }

    private static void Menu2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\tJUGAR");
        System.out.println("\t[1] JUEGO RAPIDO");
        System.out.println("\t[2] JUEGO POR MOVIMIENTOS");
        System.out.println("\t[3] RETROCEDER");
        System.out.println("\tIngrese una opcion: ");
        int opcion2 = sc.nextInt();
        Seleccion2(opcion2);
    }

    private static void Seleccion2(int opcion2) {
        switch(opcion2){
            case 1: 
                System.out.println("\n\t***********BIENVEDIDO AL JUEGO RAPIDO***********");
                System.out.println("\n\t -> El ganador se decide por mayor cantidad de Ejercitos <-");
                VideoJuego1();
                break;
            case 2:
                System.out.println("\n\t***********BIENVEDIDO AL JUEGO POR MOVIMIENTOS***********");
                System.out.println("\n\t-> El ganador se decide por probabilidades <-");
                System.out.println("\n\t-> Respecto a la cantidad Total de Vida de los SOLDADOS <-");
                VideoJuego2();
                break;
            case 3:
                Menu();
            default: 
                System.out.println("\tNo existe esa opcion");
                System.out.println("\tIntente de nuevo: ");
                Menu2();
        }
    }
}
