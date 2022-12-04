/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio16;

import static laboratorio16.Ejercito.sc;
import static laboratorio16.VideoJuego.busqueda_lineal;
import static laboratorio16.VideoJuego.indiceRandomReino1;
import static laboratorio16.VideoJuego.indiceRandomReino2;
import static laboratorio16.VideoJuego.lista_ejercito1;
import static laboratorio16.VideoJuego.lista_ejercito2;
import static laboratorio16.VideoJuego.reinos;
import static laboratorio16.VideoJuegoSoldados.busqueda_lineal;

/**
 *
 * @author asus
 */
public class Configuracion {
    
    public static void MOdificarSoldado(){
        System.out.println("\t\n MODIFICAR SOLDADO");
        System.out.println("\t [0] REINO 1 -> " + reinos.get(indiceRandomReino1));
        System.out.println("\t [1] REINO 2 -> " + reinos.get(indiceRandomReino2));
        System.out.println("\t Ingrese NOMBRE del REINO");
        String opcion = sc.next();
        if (opcion.toUpperCase().equals(reinos.get(indiceRandomReino1))) {
            System.out.println("\tEleccion correcta");
            SeleccionSoldado1();        
        }else if (opcion.toUpperCase().equals(reinos.get(indiceRandomReino2))) {
            System.out.println("Eleccion correcta");
            SeleccionSoldado2();
        } else{
            System.out.println("Reino no Generado");
            System.out.println("Intente de Nuevo");
        }
    }
    
    public static void Eliminar(){
        System.out.println("\t\n ELIMINAR EJERCITO/SOLDADO");
        System.out.println("\t [0] REINO 1 -> " + reinos.get(indiceRandomReino1));
        System.out.println("\t [1] REINO 2 -> " + reinos.get(indiceRandomReino2));
        System.out.println("\t Ingrese NOMBRE del REINO");
        String opcion = sc.next();
        if (opcion.toUpperCase().equals(reinos.get(indiceRandomReino1))) {
            System.out.println("\tEleccion correcta");
            MenuEliminar1();        
        }else if (opcion.toUpperCase().equals(reinos.get(indiceRandomReino2))) {
            System.out.println("\tEleccion correcta");
            MenuEliminar2();
        } else{
            System.out.println("Reino no Generado");
            System.out.println("Intente de Nuevo");
        }        
    }
    
    public static void RankingEjercito(){
        System.out.println("\t\n RANKING EJERCITO");
        System.out.println("\t [0] REINO 1 -> " + reinos.get(indiceRandomReino1));
        System.out.println("\t [1] REINO 2 -> " + reinos.get(indiceRandomReino2));
        System.out.println("\t Ingrese NOMBRE del REINO");
        String opcion = sc.next();
        if (opcion.toUpperCase().equals(reinos.get(indiceRandomReino1))) {
            System.out.println("\tEleccion correcta");
            for(Ejercito ejercito: lista_ejercito1){
            ejercito.rankSoldados();
        }        
        }else if (opcion.toUpperCase().equals(reinos.get(indiceRandomReino2))) {
            System.out.println("Eleccion correcta");
            for(Ejercito ejercito: lista_ejercito2){
            ejercito.rankSoldados();
        }
        } else{
            System.out.println("Reino no Generado");
            System.out.println("Intente de Nuevo");
        }
    }
    
    
    //Modificar Soldado Ejercito 1
    public static void SeleccionSoldado1(){
        System.out.println("\t\n Seleccione Ejercito del REINO -> " + reinos.get(indiceRandomReino1));
        System.out.println("\tSolo existen " + lista_ejercito1.size() +" ejercitos");
        System.out.println("\tSeleccione un EJERCITO, DENTRO DEL LÍMITE");
        int opcion = sc.nextInt();
        Ejercito ejercito = lista_ejercito1.get(busqueda_lineal(lista_ejercito1,String.valueOf(opcion)));
        System.out.println(ejercito);
        
        System.out.println("\t\nSeleccione Soldado para modificar ATRIBUTOS: ");
        int opcion2 = sc.nextInt();
        Soldado soldado = ejercito.misSoldados.get(busqueda_lineal(ejercito.misSoldados,String.valueOf(opcion2)));
        System.out.println(soldado);
        System.out.println("\tIngrese nuevo nivel de VIDA: ");
        int nivelvida = sc.nextInt();
        soldado.setNivelVida(nivelvida);
        System.out.println("\tIngrese nuevo nivel de ATAQUE: ");
        int nivelAtaque = sc.nextInt();
        soldado.setNivelAtaque(nivelAtaque);
        System.out.println("\tIngrese nuevo nivel de DEFENSA: ");
        int nivelDefensa = sc.nextInt();
        soldado.setNivelDefensa(nivelDefensa);
        System.out.println(soldado);
    }
    
    //Modificar Soldado Ejercito 2
    public static void SeleccionSoldado2(){
        System.out.println("\t\n Seleccione Ejercito del REINO -> " + reinos.get(indiceRandomReino2));
        System.out.println("\tSolo existen " + lista_ejercito2.size() +" ejercitos");
        System.out.println("\tSeleccione un EJERCITO, DENTRO DEL LÍMITE");
        int opcion = sc.nextInt();
        Ejercito ejercito = lista_ejercito2.get(busqueda_lineal(lista_ejercito2,String.valueOf(opcion)));
        System.out.println(ejercito);
        System.out.println("\t\nSeleccione Soldado para modificar ATRIBUTOS: ");
        int opcion2 = sc.nextInt();
        Soldado soldado = ejercito.misSoldados.get(busqueda_lineal(ejercito.misSoldados,String.valueOf(opcion2)));
        System.out.println(soldado);
        System.out.println("\tIngrese nuevo nivel de VIDA: ");
        int nivelvida = sc.nextInt();
        soldado.setNivelVida(nivelvida);
        System.out.println("\tIngrese nuevo nivel de ATAQUE: ");
        int nivelAtaque = sc.nextInt();
        soldado.setNivelAtaque(nivelAtaque);
        System.out.println("\tIngrese nuevo nivel de DEFENSA: ");
        int nivelDefensa = sc.nextInt();
        soldado.setNivelDefensa(nivelDefensa);
        System.out.println(soldado);
    }
    
    //Metodos para Eliminar Reino 1 Ejercito 1 Soldado 1
    public static void MenuEliminar1(){
        System.out.println("\t[0] ELIMINAR EJERCITO");
        System.out.println("\t[1] ELIMINAR SOLDADO");
        System.out.println("\tEscoja una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 0:
                EliminarEjercito1();
                break;            
            case 1:
                EliminarSoldadoEj1();
                break;
            default: 
                System.out.println("\tNo existe esa opción");
                System.out.println("\tIntente de nuevo");
                MenuEliminar1();
        }
    }
    
    public static void EliminarEjercito1(){
        System.out.println("\t\n Seleccione Ejercito del REINO -> " + reinos.get(indiceRandomReino1));
        System.out.println("\tSolo existen " + lista_ejercito1.size() +" ejercitos");
        System.out.println("\tSeleccione un EJERCITO a ELIMINAR, DENTRO DEL LÍMITE");
        int opcion1 = sc.nextInt();
        Ejercito ejercito = lista_ejercito1.get(busqueda_lineal(lista_ejercito1,String.valueOf(opcion1)));
        lista_ejercito1.remove(ejercito);
        System.out.println("\tAhora solo existen -> " + lista_ejercito1.size());
        System.out.println(lista_ejercito1);
    }
    
    public static void EliminarSoldadoEj1(){
        System.out.println("\t\n Seleccione Ejercito del REINO -> " + reinos.get(indiceRandomReino1));
        System.out.println("\tSolo existen " + lista_ejercito1.size() +" ejercitos");
        System.out.println("\tSeleccione un EJERCITO, DENTRO DEL LÍMITE");
        int opcion1 = sc.nextInt();
        Ejercito ejercito = lista_ejercito1.get(busqueda_lineal(lista_ejercito1,String.valueOf(opcion1)));
        System.out.println(ejercito);
        System.out.println("\t\nSeleccione SOLDADO para ELIMINAR: ");
        int opcion2 = sc.nextInt();
        Soldado soldado = ejercito.misSoldados.get(busqueda_lineal(ejercito.misSoldados,String.valueOf(opcion2)));
        ejercito.misSoldados.remove(soldado);
        System.out.println(soldado);         
    }
    
    //Menu Eliminar Reino 2 Ejecito Soldado 2
    public static void MenuEliminar2(){
        System.out.println("\t[0] ELIMINAR EJERCITO");
        System.out.println("\t[1] ELIMINAR SOLDADO");
        System.out.println("\tEscoja una opción: ");
        int opcion = sc.nextInt();
        switch(opcion){
            case 0:
                EliminarEjercito2();
                break;           
            case 1:
                EliminarSoldadoEj2();
                break;
            default: 
                System.out.println("\tNo existe esa opción");
                System.out.println("\tIntente de nuevo");
                MenuEliminar2();
        }
    }
    
    public static void EliminarEjercito2(){
        System.out.println("\t\n Seleccione Ejercito del REINO -> " + reinos.get(indiceRandomReino2));
        System.out.println("\tSolo existen " + lista_ejercito2.size() +" ejercitos");
        System.out.println("\tSeleccione un EJERCITO a ELIMINAR, DENTRO DEL LÍMITE");
        int opcion1 = sc.nextInt();
        Ejercito ejercito = lista_ejercito2.get(busqueda_lineal(lista_ejercito2,String.valueOf(opcion1)));
        lista_ejercito2.remove(ejercito);
        System.out.println("\tAhora solo existen -> " + lista_ejercito2.size());
        System.out.println(lista_ejercito2);
    }
    
    public static void EliminarSoldadoEj2(){
        System.out.println("\t\n Seleccione Ejercito del REINO -> " + reinos.get(indiceRandomReino2));
        System.out.println("\tSolo existen " + lista_ejercito2.size() +" ejercitos");
        System.out.println("\tSeleccione un EJERCITO, DENTRO DEL LÍMITE");
        int opcion1 = sc.nextInt();
        Ejercito ejercito = lista_ejercito2.get(busqueda_lineal(lista_ejercito2,String.valueOf(opcion1)));
        System.out.println(ejercito);
        System.out.println("\t\nSeleccione SOLDADO para ELIMINAR: ");
        int opcion2 = sc.nextInt();
        Soldado soldado = ejercito.misSoldados.get(busqueda_lineal(ejercito.misSoldados,String.valueOf(opcion2)));
        ejercito.misSoldados.remove(soldado);
        System.out.println(soldado);         
    }
  
}
    
