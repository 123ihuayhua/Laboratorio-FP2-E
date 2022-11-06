/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio09;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class VideoJuego6 {
    
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        
        //Manera Iterativa, preguntat si quiere realizar juego, solo sucede cuando se esscriba Y
        int num_ejercito1, num_ejercito2;
        String rpta;
        boolean suerte;
        while (true) {
            System.out.println("Desea simular un juego de Soldados en Guerra? y/n");
            rpta = sc.next();
            if (rpta.equals("n")) {
                break;
            }
            
            //Creación del Tablero
            Soldado[][] tablero = new Soldado[10][10];
            
            //Creación de los Ejércitos
            HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
            HashMap<Integer, Soldado> ejercito2 = new HashMap<>();
            
            //Cantidad de soldados aleatorios por ejército
            num_ejercito1 = r.nextInt(10) + 1;
            num_ejercito2 = r.nextInt(10) + 1;
            
            //Cantidad de soldados generadas
            System.out.println("#Soldados Ejercito1: " + num_ejercito1);
            System.out.println("#Sodlado Ejercito2: " + num_ejercito2);
            
            //Generar los ejércitos
            generar_HasMap(ejercito1, num_ejercito1, "1");
            generar_HasMap(ejercito2, num_ejercito2, "2");
            
            //Definir los Ejercitos 
            suerte = r.nextBoolean();
            if (suerte) {
                llenar_tabla(ejercito1, tablero);
                llenar_tabla(ejercito2, tablero);

            } else {
                llenar_tabla(ejercito2, tablero);
                llenar_tabla(ejercito1, tablero);
            }
            
            mostrar_tabla(tablero);
            //Información del juego 1
            System.out.println();
            System.out.println("El mayor y primero del ejercito 1 es: " + mayor_hasmap(ejercito1));
            System.out.println("El mayor y primero del ejercio 2 es: " + mayor_hasmap(ejercito2));
           
            //Información del juego 2
            System.out.println();
            System.out.println("El promedio de PV: " + "Ejercito 1 :" + prom_fila(ejercito1));
            System.out.println("El promedio de PV "  + "Ejercito 2 :" + prom_fila(ejercito2));
            
            //Orden de creación
            System.out.println("\nOrden de creacion");
            mostrar_Hasmap(ejercito1);
            mostrar_Hasmap(ejercito2);
            
            //Ejércitos ordenados
            System.out.println("\nEjercitos Ordenados");
            System.out.println("Ordenamiento por Puntos Burbuja: ");
            ordenarPorPuntosBurbuja(ejercito1);
            mostrar_Hasmap(ejercito1);
            System.out.println("\nOrdenmiento Por Puntos de Inserción");
            ordenarPorPuntosInsercion(ejercito2);
            mostrar_Hasmap(ejercito2);
            
            //Ganador de la guerra
            System.out.println("\nGanador de la  batalla: ");
            quien_gana(ejercito1, ejercito2);
            
        }
    }
    
    //Generación de los soldados
    public static void generar_HasMap(HashMap<Integer, Soldado> a, int cantidad, String equipo) {
        String nombre;
        int puntos_vida,ataque,defensa;
        for (int i = 0; i < cantidad; i++) {
            Soldado soldado_cre = new Soldado();
            nombre = "Soldado" + i + 'X' + equipo;
            puntos_vida = r.nextInt(5) + 1;
            ataque=r.nextInt(5)+1;
            defensa=r.nextInt(5)+1;
            soldado_cre.setNombre(nombre);
            soldado_cre.setVidaActual(puntos_vida);
            soldado_cre.setNivelAtaque(ataque);
            soldado_cre.setNivelDefensa(defensa);
            a.put(i, soldado_cre);
        }
    }
    
    //Llenar el tablero
    public static void llenar_tabla(HashMap<Integer, Soldado> a, Soldado[][] c) {
        int i = 0, fila, columna, j = 0, k = 0;
        while (i < a.size()) {
            do {
                fila = r.nextInt(10);
                columna = r.nextInt(10);
            } while (c[fila][columna] != null);
            c[fila][columna] = a.get(i);
            i++;
        }

    }
    
    //Mostrar el tablero
    public static void mostrar_tabla(Soldado[][] a) {
        String ultimocaracte;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != null) {
                    ultimocaracte = ultima_letra(a[i][j]);
                    if (ultimocaracte.equals("1")) {
                        System.out.print("\t\033[0;31m" + a[i][j].getVidaActual());
                    } else {
                        System.out.print("\t\033[32m" + a[i][j].getVidaActual());
                    }

                } else {

                    System.out.print("\t_  ");
                }
            }
            System.out.print("\n\n");

        }

    }

    //sacar el ultimo caracter para saber a que equipo pertenece y definir a que éjercito va
    public static String ultima_letra(Soldado a) {
        String ultima_letra;
        ultima_letra = a.getNombre().substring(a.getNombre().length() - 1);
        return ultima_letra;

    }
    
    //Mayor PV de soldado por cada Ejército
    public static Soldado mayor_hasmap(HashMap<Integer, Soldado> a) {
        int mayor = 0, indice = 0;

        for (Integer key : a.keySet()) {
            if (a.get(key).getVidaActual() > mayor) {
                mayor = a.get(key).getVidaActual();
                indice = key;
            }
        }
        return a.get(indice);
    }
    
    //Promedio PV de cada Ejército
    public static double prom_fila(HashMap<Integer, Soldado> a) {
        int suma = 0;
        double prom;
        for (Integer key : a.keySet()) {
            suma += a.get(key).getVidaActual();
        }
        prom = suma / (a.size());
        return prom;
    }
    
    //Mostrar orden de creación
    public static void mostrar_Hasmap(HashMap<Integer, Soldado> a) {
        for (Integer key : a.keySet()) {
            System.out.println(a.get(key));
        }
    }
    
    //Ordenamiento por Puntos de Intersección
    public static void ordenarPorPuntosInsercion(HashMap<Integer, Soldado> a) {
        int j, aux;
        Soldado sold_temp = new Soldado();
        for (int i = 1; i < a.size(); i++) {
            sold_temp = a.get(i);
            aux = a.get(i).getVidaActual();
            j = i - 1;
            while (j >= 0 && aux < a.get(j).getVidaActual()) {
                a.put(j + 1, a.get(j));

                j--;
            }
            a.put(j + 1, sold_temp);
        }
    }
    
    //Ordenamiento por Punto Burbuja
    public static void ordenarPorPuntosBurbuja(HashMap<Integer, Soldado> a) {
        for (int i = 1; i < a.size(); i++) {
            for (int j = 0; j < a.size() - i; j++) {
                if (a.get(j).getVidaActual() > a.get(j + 1).getVidaActual()) {
                    intercambiar(a, j, j + 1);
                }
            }
        }
    }
    
    //Submétodo de intercambio para ordenamiento  por Puntos Burbuja
    public static void intercambiar(HashMap<Integer, Soldado> a, int i, int j) {
        Soldado aux = new Soldado();
        aux = a.get(i);
        a.put(i, a.get(j));
        a.put(j, aux);

    }

    //Criterio de ganar: Quien tiene la mayor cantidad de soldados
    public static void quien_gana (HashMap<Integer, Soldado> a, HashMap<Integer, Soldado> b) {
       
        if (a.size() > b.size()) {
            System.out.println("Ganador Ejército 1, porque tiene mayor cantidad de soldados");
        }
        else if (a.size() < b.size()) {
            System.out.println("Ganador Ejército 2, porque tiene mayor cantidad de soldados");
        }
        else if (a.size() == b.size()) {
            System.out.println("No hay ganador, es un empate!");
        }
    }
}

