/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio16;

import java.util.Scanner;
import static laboratorio16.Configuracion.Eliminar;
import static laboratorio16.Configuracion.MOdificarSoldado;
import static laboratorio16.Configuracion.RankingEjercito;
import static laboratorio16.VideoJuego.Generacion;
import static laboratorio16.VideoJuego.VideoJuego1;
import static laboratorio16.VideoJuego.VideoJuego2;


/**
 *
 * @author asus
 */
public class Menu {
    public static void Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\n***********BIENEVENIDO A RSHDRAV***********");
        System.out.println("\t[0] GENERACION REINO - EJERCITOS");
        System.out.println("\t[1] JUGAR");
        System.out.println("\t[2] GESTIÓN REINO EJERCITO");
        System.out.println("\t[3] SALIR DEL JUEGO");
        System.out.println("\tEscoja una opcion: ");
        int opcion = sc.nextInt();
        Seleccion(opcion);
    }

    private static void Seleccion(int opcion) {
        switch(opcion){
            case 0: 
                Generacion();
                break;
            case 1: 
                Menu2();
                break;
            case 2:
                Menu3();
            case 3:
                System.out.println("\t***********FIN DEL JUEGO***********");
                return;
            default: 
                System.out.println("\tNo existe esa opcion");
                System.out.println("\tIntente de nuevo: ");
        }
        Menu();
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
                //Generacion();
                VideoJuego1();
                break;
            case 2:
                System.out.println("\n\t***********BIENVEDIDO AL JUEGO POR MOVIMIENTOS***********");
                System.out.println("\n\t-> El ganador se decide por probabilidades <-");
                VideoJuego2();
                break;
            case 3:
                Menu();
            default: 
                System.out.println("\tNo existe esa opcion");
                System.out.println("\tIntente de nuevo: ");
                Menu2();
                return;
        }
        Menu();
    }

    private static void Menu3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t GESTION REINO - EJERCITO / ESTADISTICAS");
        System.out.println("\t[1] MODIFICAR EJERCITO - SOLDADO");
        System.out.println("\t[2] ELIMINAR EJERCITO - SOLDADO");
        System.out.println("\t[3] RANKING DE PODER EJERCITO");
        System.out.println("\t[4] VOLVER AL MENU PRINCIPAL");
        System.out.println("\tIngrese una opcion: ");
        int opcion3 = sc.nextInt();
        Seleccion3(opcion3);
    }

    private static void Seleccion3(int opcion3) {
        switch(opcion3){
            case 1: 
                System.out.println("\n\t***********MODIFICAR EJERCITO -> SOLDADO***********");
                System.out.println("\n\t -> Se modifica solo ATRIBUTOS de los SOLDADOS <-");
                MOdificarSoldado();    
                Menu3();
            case 2:
                System.out.println("\n\t***********ELIMINAR EJERCITO / SOLDADO***********");
                System.out.println("\n\t-> Se elimina un EJERCITO o SOLDADO de un EJERCITO <-");
                Eliminar();
                Menu3();
            case 3:
                System.out.println("\n\t***********RANKING DE PODER EJERCITO***********");
                System.out.println("\n\t-> Se muestra RANKING por NIVEL DE VIDA por EJERCITO <-");
                RankingEjercito();
                Menu3();
            case 4:
                Menu();
                break;
            default: 
                System.out.println("\tNo existe esa opcion");
                System.out.println("\tIntente de nuevo: ");
                Menu3();
        }
    }
}
