/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio15;

import java.util.ArrayList;
import static laboratorio15.Ejercito.sc;
import static laboratorio15.VideoJuego.busqueda_lineal;
import static laboratorio15.VideoJuego.indiceRandomReino1;
import static laboratorio15.VideoJuego.indiceRandomReino2;
import static laboratorio15.VideoJuego.lista_ejercito1;
import static laboratorio15.VideoJuego.reinos;
import static laboratorio15.VideoJuegoSoldados.a;
import static laboratorio15.VideoJuegoSoldados.busqueda_lineal;

/**
 *
 * @author asus
 */
public class Configuracion {
    
    public static void MOdificarSoldado(){
        System.out.println("\t\n MODIFICAR SOLDADO");
        System.out.println("\t [0] REINO 1 -> " + reinos.get(indiceRandomReino1));
        System.out.println("\t [0] REINO 2 -> " + reinos.get(indiceRandomReino2));
        System.out.println("\t Ingrese NOMBRE del REINO");
        String opcion = sc.next();
        if (opcion.toUpperCase().equals(reinos.get(indiceRandomReino1))) {
            System.out.println("Eleccion correcta");
            SeleccionSoldado1();
        }else{
            System.out.println("Reino no Generado");
            System.out.println("Intente de Nuevo");
        }
    }
    
    public static void Eliminar(){
        
    }
    
    public static void RankingEjercito(){
        
    }
    
    public static void RankingSoldado(){
        
    }
    
    public static void SeleccionSoldado1(){
        System.out.println("\t\n Seleccione Ejercito del REINO -> " + reinos.get(indiceRandomReino1));
        System.out.println("\tSolo existen " + lista_ejercito1.size() +" ejercitos");
        int opcion = sc.nextInt();
        System.out.println(lista_ejercito1.get(busqueda_lineal(lista_ejercito1,String.valueOf(opcion))));
        System.out.println("\t\nSeleccione Soldado para modificar ATRIBUTOS: ");
        int opcion2 = sc.nextInt();
        //System.out.println(misSoldados.get(busqueda_lineal(misSoldados,String.valueOf(opcion2))));
    }
}
    
