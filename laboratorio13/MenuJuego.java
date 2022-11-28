/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio12;

import java.util.Scanner;
import static laboratorio12.Configuracione_2.AgregarSoldado;
import static laboratorio12.Configuracione_2.CambiarPosicion;
import static laboratorio12.Configuracione_2.ClonarSoldado;
import static laboratorio12.Configuracione_2.ModificarSoldado;
import static laboratorio12.Configuracione_2.QuitarSoldado;
import static laboratorio12.Configuracione_2.SumarNiveles;
import static laboratorio12.Configuracione_2.VerEjercito;
import static laboratorio12.Configuracione_2.VerSoldado;
import static laboratorio12.VideoJuego9.GenerarSoldados;
import static laboratorio12.VideoJuego9.VideoJuego9;



/**
 *
 * @author asus
 */
public class MenuJuego {
    
    public static void main(String [] args){
       
        Scanner sc = new Scanner (System.in);
        String run = "y";
        while(!run.toLowerCase().equals("n")){
            Menu();
            int opcion;
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    GenerarSoldados();
                    VideoJuego9();
                    break;
                case 2: 
                    Menu2();
                    int opcion2 = sc.nextInt();
                    Menu2_1(opcion2);
                    while (opcion2 > 11){
                        System.out.println("Opcion Invalida, ingrese de nuevo: ");
                        opcion2 = sc.nextInt();
                        Menu2_1(opcion2);
                    }
                    break;
                case 3:
                    System.out.println("Salir del Juego: ");
                    run = "n";
                    break;
                default: break;
            }
        }
    }
    
    public static void Menu(){
        System.out.println("\n****BIENVENIDO AL JUEGO DE BATALLA****");
        System.out.println("1. Empezar a Jugar");
        System.out.println("2. Gestionar Ejercito");                      
        System.out.println("3. Salir");  
        System.out.println("Ingrese una opcion del menu para INICIAR: ");
    }
    
    public static void Menu2(){
        System.out.println("\n****BIENVENIDO AL MENU 2 DEL JUEGO****");
        System.out.println("GESTIÓN DEL EJÉRCITO");
        System.out.println("0. Generar Soldados: ");
        System.out.println("1. Crear Soldado: ");
        System.out.println("2. Eliminar Soldado: ");                      
        System.out.println("3. Clonar Soldado: ");
        System.out.println("4. Modificar Soldado: ");
        System.out.println("5. Comparar Soldados: ");
        System.out.println("6. Intercambiar Soldados");
        System.out.println("7. Ver soldado: ");
        System.out.println("8. Ver ejercito: ");
        System.out.println("9. Sumar niveles: ");
        System.out.println("10. Jugar con las Modificaciones: ");
        System.out.println("11. Volver al Menu Principal: ");
        System.out.println("Ingrese una opcion del menu para ingresar: "); 
    }
    
    public static void Menu2_1(int a){
        switch(a){
            case 0: 
                System.out.println("Generar Soldados: ");
                GenerarSoldados();
                break;
            case 1: 
                System.out.println("Crear Soldado: ");
                AgregarSoldado();
                break;
            case 2:
                System.out.println("Eliminar Soldado: ");
                QuitarSoldado();
                break;
            case 3: 
                System.out.println("Clonar Soldado: ");
                ClonarSoldado();    
                break;
            case 4: 
                System.out.println("Modificar Soldado: ");
                ModificarSoldado();
                break;
            case 5: 
                System.out.println("Comparar Soldado: ");
                break;
            case 6: 
                System.out.println("Intercambiar Soldado: ");
                CambiarPosicion();
                break;
            case 7: 
                System.out.println("Ver Soldado: ");
                VerSoldado();
                break;
            case 8: 
                System.out.println("Ver Ejercito: ");
                VerEjercito();
                break;
            case 9:
                System.out.println("Sumar Niveles: ");
                SumarNiveles();
                break;
            case 10:
                System.out.println("Jugar con los Modificaciones: ");
                VideoJuego9();
                break;
            case 11: 
                System.out.println("Volver al Menú Principal: ");
                System.out.println("No se guardaran las modificaciones:");
                Menu();
                break;
            default: 
                break;
        }
        
    }
}
