/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio07;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *Laboratorio 07
 *@author Iván Rodrigo Huayhua Mayta
 */
public class VideoJuego4 {
    
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    
    public static void main(String[] args) {
        int num_soldados1, num_soldados2;
        //Para poder modificar la matriz ArrayList vamos a crear una 
        // matriz de objetos soldados con nombres null
        
        ArrayList<ArrayList<Soldado2>> ejercitos = new
        ArrayList<ArrayList<Soldado2>>();
        
        ArrayList<Soldado2> ejercito1_fila = new ArrayList<Soldado2>();
        ArrayList<Soldado2> ejercito2_fila = new ArrayList<Soldado2>();
        
        //Generar Tablero 10 x 10
        for (int i = 0; i < 10; i++) {
            ejercitos.add(new ArrayList<Soldado2>());
            for (int j = 0; j < 10; j++) {
                Soldado2 soldadoprueba = new Soldado2();
                ejercitos.get(i).add(soldadoprueba);
            }
        }
        //Soldados Aleatorios
        num_soldados1 = r.nextInt(10) + 1; 
        num_soldados2 = r.nextInt(10) + 1;
        System.out.println("Ejercito1: " + num_soldados1 + "\n" + "Ejercito2: " + num_soldados2+"\n");
        
        //Generar Soldados en la Tabla
        genera_soldado(num_soldados1, num_soldados2, ejercitos);
        
        //Matriz generada Y SOldados
        mostrar_matriz_posiciones(ejercitos); 
        ejercito1_fila = change_b_u_x(ejercitos);
        ejercito2_fila = change_b_u_y(ejercitos);
        
        //Información de Juego 1 
        System.out.println("Soldados con MAYOR PUNTOS DE VIDA: ");
        System.out.println("Mayor Ejercito 1"+mayor_fila(ejercito1_fila));
        System.out.println("Mayor Ejercito 2"+mayor_fila(ejercito2_fila));
        System.out.println();
        
        //Información de Juego 2
        System.out.println("Promedio PUNTOS DE VIDA: ");
        System.out.println("Prom de Ejercito 1"+prom_fila(ejercito1_fila));
        System.out.println("Prom de Ejercito 2"+prom_fila(ejercito2_fila));
        System.out.println();
        
        //Creación Ejército
        System.out.println("Orden de creacion por ejercitos");
        System.out.println(ejercito1_fila);
        System.out.println(ejercito2_fila);
        System.out.println();
        
        //Métodos de ordenamiento
        //Ordenamiento Por Puntos Burbuja
        ordenarPorPuntosBurbuja(ejercito1_fila);
        System.out.println("ORDENAMIENTO MÉTODO BURBUJA");
        System.out.println("Ejercito-ordenado 1: " + "\t"+ejercito1_fila);
        System.out.println();
        
        //Ordenamiento Por Método de Inserción
        System.out.println("ORDENAMIENTO MÉTODO INSERCIÓN");
        ordenarPorPuntosInsercion(ejercito2_fila);
        System.out.println("Ejercito-ordenado 2: "+ejercito2_fila);
        System.out.println();
        
        //Ganador
        System.out.println("GANADOR POR SUMA PUNTOS DE VIDA: ");
        quien_gana(ejercito1_fila, ejercito2_fila);
    }
        
    public static void genera_soldado(int num_sold1, int num_sold2, ArrayList<ArrayList<Soldado2>> a) {
            String nombre;
            int fila, columna, puntos_vida, i = 0, contador_ejercito1 = 0,
            contadore_jercito2 = 0;
            //Asignación de Posición y uso del Boolean: true = ejercito1 y false = ejercito2
            while (i < (num_sold1 + num_sold2)){
                do{
                    fila = r.nextInt(10);
                    columna = r.nextInt(10);
                }while (a.get(fila).get(columna).getNombre() != null);
                boolean team = r.nextBoolean();
                if (team && contador_ejercito1 < num_sold1) {
                    nombre = "soldado " + contador_ejercito1 + "X" + 1;
                    puntos_vida = r.nextInt(5) + 1;
                    Soldado2 soldadoprovisional = new Soldado2();
                    a.get(fila).set(columna, soldadoprovisional);
                    a.get(fila).get(columna).setEquipo(team);
                    a.get(fila).get(columna).setColumna(columna);
                    a.get(fila).get(columna).setFila(fila);
                    a.get(fila).get(columna).setNombre(nombre);
                    a.get(fila).get(columna).setPuntos_Vida(puntos_vida);
                     contador_ejercito1++;    
                }else{
                    nombre = "soldado " + contadore_jercito2 + "X" + 2;
                    puntos_vida = r.nextInt(5) + 1;
                    Soldado2 soldadoprovisional = new Soldado2();
                    a.get(fila).set(columna, soldadoprovisional);
                    a.get(fila).get(columna).setEquipo(team);
                    a.get(fila).get(columna).setColumna(columna);
                    a.get(fila).get(columna).setFila(fila);
                    a.get(fila).get(columna).setNombre(nombre);
                    a.get(fila).get(columna).setPuntos_Vida(puntos_vida);
                    contadore_jercito2++; 
                }
                i++;
            }
    }
    
    //Mostrar Tabla
    public static void mostrar_matriz(ArrayList<ArrayList<Soldado2>> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    //Mostrar Posiciones 
    public static void mostrar_matriz_posiciones(ArrayList<ArrayList<Soldado2>> a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                    String prov_ultimoc = "";
                    if (a.get(i).get(j).getNombre() == null) {
                    System.out.print(" _ ");
                    } else {
                        prov_ultimoc = a.get(i).get(j).getNombre().substring(a.get(i).get(j).getNombre().length() - 1);
                        // Diferenciación Ejercitos en el Tablero
                        if (prov_ultimoc.equals("1")) {
                            System.out.print(" X ");
                        } else {
                                System.out.print("\033[32m Y "); //Color de diferenciación 
                        }
                    }
            }
            System.out.println();
        }
    }
    //Distribución aleatoria
    public static ArrayList<Soldado2>change_b_u_x(ArrayList<ArrayList<Soldado2>> a) {
        //Distinción Ejército por 1 o 2
        ArrayList<Soldado2> soldadoen_fila = new ArrayList<Soldado2>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                String prov_ultimoc = "";
                if (a.get(i).get(j).getNombre() != null) {
                    prov_ultimoc =a.get(i).get(j).getNombre().substring(a.get(i).get(j).getNombre().length() - 1);
                    if (prov_ultimoc.equals("1")) {
                        soldadoen_fila.add(a.get(i).get(j));
                    }
                }
            }
        }
        return soldadoen_fila;
    }
    
    public static ArrayList<Soldado2>change_b_u_y(ArrayList<ArrayList<Soldado2>> a) {
        //Distinción Ejército por 1 o 2
        ArrayList<Soldado2> soldadoen_fila = new ArrayList<Soldado2>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                String prov_ultimoc = "";
                if (a.get(i).get(j).getNombre() != null) {
                    prov_ultimoc =a.get(i).get(j).getNombre().substring(a.get(i).get(j).getNombre().length() - 1);
                    if (prov_ultimoc.equals("2")) {
                        soldadoen_fila.add(a.get(i).get(j));
                    }
                }
            }
        }
        return soldadoen_fila;
    }
    
    //Método para mostrar SOLDADO CON MAYOR PUNTOS DE VIDA
    public static Soldado2 mayor_fila(ArrayList<Soldado2> a) {
        int mayor = 0, indice = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getPuntos_Vida() > mayor) {
                mayor = a.get(i).getPuntos_Vida();
                indice = i;
            }
        }
        return a.get(indice);
    }
    
    //Método para mostrar PROMEDIA DE VIDA DE LOS EJÉRCITOS
    public static double prom_fila(ArrayList<Soldado2> a) {
        int suma=0;
        double prom;
        for (int i = 0; i < a.size(); i++) {
            suma+=a.get(i).getPuntos_Vida();
        }prom=suma/(a.size());
        return prom;
    }
    
    //Método Ordenamiento por Puntos Burbuja
    public static void ordenarPorPuntosBurbuja(ArrayList<Soldado2> a) {
        for (int i = 1; i < a.size(); i++) {
            for (int j = 0; j < a.size() - i; j++) {
                if (a.get(j).getPuntos_Vida() < a.get(j +1).getPuntos_Vida()) {
                    intercambiar(a, j, j+1);
                }
            }
        }
    }

    public static void intercambiar(ArrayList<Soldado2> a, int i, int j) {
        Soldado2 aux = new Soldado2();
        aux = a.get(i);
        a.set(i, a.get(j));
        a.set(j, aux);
    }
    
    //Método Ordenamiento por Puntos de Insercción 
    public static void ordenarPorPuntosInsercion(ArrayList<Soldado2> a) {
        int j, aux;
        Soldado2 sold_temp = new Soldado2();
        for (int i = 1; i < a.size(); i++) {
            sold_temp = a.get(i);
            aux = a.get(i).getPuntos_Vida();
            j = i - 1;
            while (j >= 0 && aux > a.get(j).getPuntos_Vida()) {
                a.set(j + 1, a.get(j));
                j--;
            }
            a.set(j + 1, sold_temp);
        }
    }
    
    //Ganador por mayor SUMA DE PUNTAJES DE VIDA
    public static void quien_gana(ArrayList<Soldado2> a, ArrayList<Soldado2> b) {
        int suma1 = 0, suma2 = 0;
        for (int i = 0; i < a.size(); i++) {
            suma1 += a.get(i).getPuntos_Vida();
        }
        for (int i = 0; i < b.size(); i++) {
            suma2 += b.get(i).getPuntos_Vida();
        }
        if (suma1 > suma2) {
            System.out.println("Gana Ejercito 1");
        } else {
            System.out.println("Gana Ejercito 2");
        }
    }
}

