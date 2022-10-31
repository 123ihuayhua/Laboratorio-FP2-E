/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio08;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Laboratorio 08
 * @author Iván Rodrigo Huayhua Mayta
 */
public class VideoJuego5 {
    
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    
    public static void main(String[] args) {
        
        //Manera iterativa de ver, si quiere iniciar una simulacioón de Guerra
        // n = Empieza el juego / y = Bucle infinito 
        int num_ejercito1, num_ejercito2;
        String rpta;
        boolean suerte;
        while (true) {
            System.out.println("" + "Desea simular un juego de Soldados en Guerra? y/n");
            rpta = sc.next();
            if (rpta.equals("n")) {
                break;
            }
        }
        
        //Inicialización tablero
        Soldado[][] tablero = new Soldado[10][10];
        //Inicialización ejército
        HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
        HashMap<Integer, Soldado> ejercito2 = new HashMap<>();
        //Inicialización aleatorio cantidad de soldados
        num_ejercito1 = r.nextInt(10) + 1;
        num_ejercito2 = r.nextInt(10) + 1;
        //Cantidad de Soldados generados por Ejército
        System.out.println("#Soldados Ejercito1: " + num_ejercito1);
        System.out.println("#Sodlado Ejercito2: " + num_ejercito2);
        generar_HasMap(ejercito1, num_ejercito1, "1");
        generar_HasMap(ejercito2, num_ejercito2, "2");
        
        //Dependiendo de la respuesta del jugador, se simula el juego
        suerte = r.nextBoolean();
        if (suerte) {
            llenar_tabler(ejercito1, tablero);
            llenar_tabler(ejercito2, tablero);
        } else {
            llenar_tabler(ejercito2, tablero);
            llenar_tabler(ejercito1, tablero);
        }
        
        mostrar_tabla(tablero);
        //Información de Juego 1, Soldado con mayor PV de cada Ejército
        System.out.println("El mayor y primero del ejercito 1 es: " + mayor_hasmap(ejercito1));
        System.out.println("El mayor y primero del ejercio 2 es: " +  mayor_hasmap(ejercito2));
        
        //Imformación de Juego 2, Promedio de PV por cada Ejército
        System.out.println("El promedio de PV " + "Ejercito 1 :" + prom_fila(ejercito1));
        System.out.println("El promedio de PV " + "Ejercito 2 :" + prom_fila(ejercito2));
        
        //Orden creación de Cada Ejército
        System.out.println("\n\nOrden de creacion");
        System.out.println("Ejército 1: ");
        mostrar_Hasmap(ejercito1);
        System.out.println("Ejército 2: ");
        mostrar_Hasmap(ejercito2);

        //Ordenamiento de Ejército por Puntos Burbuja e Inserción
        System.out.println("\nEjercitos ordenados Ordenados");
        ordenarPorPuntosBurbuja(ejercito1);
        ordenarPorPuntosInsercion(ejercito2);
        System.out.println("Ejército 1:");
        mostrar_Hasmap(ejercito1);
        System.out.println("Ejército 2:");
        mostrar_Hasmap(ejercito2);
        
        //Ganador de la Contienda 
        System.out.println("\n¿Quién ganara? ");
        quien_gana(ejercito1, ejercito2);
        System.out.println("Porque tiene en total mas Puntos " + "de Vida");

    }
    //Generar soldados
    public static void generar_HasMap(HashMap<Integer, Soldado> a, int cantidad,String equipo) {
        String nombre;
        int puntos_vida;
        for (int i = 0; i < cantidad; i++) {
            Soldado soldado_cre = new Soldado();
            nombre = "Soldado" + i + 'X' + equipo;
            puntos_vida = r.nextInt(5) + 1;
            soldado_cre.setNombre(nombre);
            soldado_cre.setPuntos_Vida(puntos_vida);
            a.put(i, soldado_cre);
        }
    }
    
    //llenar tablero
    public static void llenar_tabler(HashMap<Integer, Soldado> a, Soldado[][] c){
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

    //Mostrar Tablero
    public static void mostrar_tabla(Soldado[][] a) {
        String ultimocaracte;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != null) {
                    ultimocaracte = ultima_letra(a[i][j]);
                    if (ultimocaracte.equals("1")) {
                        System.out.print("\t\033[32m X" + a[i][j].getPuntos_Vida());
                    } else {
                        System.out.print("\tY" + a[i][j].getPuntos_Vida());
                    }
                } else {
                    System.out.print("\t_ ");
                }
            }
            System.out.print("\n\n");
        }
    }
    
    //sacar el ultimo caracter para saber a que equipo pertenece
    public static String ultima_letra(Soldado a) {
        String ultima_letra;
        ultima_letra = a.getNombre().substring(a.getNombre().length() - 1);
        return ultima_letra;
    }
    
    //Mayor PV de soldado por Ejército
    public static Soldado mayor_hasmap(HashMap<Integer, Soldado> a) {
        int mayor = 0, indice = 0;
        for (Integer key : a.keySet()) {
            if (a.get(key).getPuntos_Vida() > mayor) {
                mayor = a.get(key).getPuntos_Vida();
                indice = key;
            }
        }
        return a.get(indice);
    }
    
    //Promedio de PV por Ejército
    public static double prom_fila(HashMap<Integer, Soldado> a) {
        int suma = 0;
        double prom;
        for (Integer key : a.keySet()) {
            suma += a.get(key).getPuntos_Vida();
        }
        prom = suma / (a.size());
        return prom;
    }
    
    public static void mostrar_Hasmap(HashMap<Integer, Soldado> a) {
        for (Integer key : a.keySet()) {
            System.out.println(a.get(key));
        }
    }
    
    // Método de ordenamiento 1
    public static void ordenarPorPuntosInsercion(HashMap<Integer, Soldado> a) {
        int j, aux;
        Soldado sold_temp = new Soldado();
        for (int i = 1; i < a.size(); i++) {
            sold_temp = a.get(i);
            aux = a.get(i).getPuntos_Vida();
            j = i - 1;
            while (j >= 0 && aux < a.get(j).getPuntos_Vida()) {
                a.put(j + 1, a.get(j));
                j--;
            }
            a.put(j + 1, sold_temp);
        }
    }
    
    // Método de Ordenamiento 2
    public static void ordenarPorPuntosBurbuja(HashMap<Integer, Soldado> a) {
        for (int i = 1; i < a.size(); i++) {
            for (int j = 0; j < a.size() - i; j++) {
                if (a.get(j).getPuntos_Vida() > a.get(j + 1).getPuntos_Vida()) {
                    intercambiar(a, j, j + 1);
                }
            }
        }
    }
    //Intercambio de pocisiones en el Método Burbuja
    public static void intercambiar(HashMap<Integer, Soldado> a, int i, int j) {
        Soldado aux = new Soldado();
        aux = a.get(i);
        a.put(i, a.get(j));
        a.put(j, aux);
    }

    //Criterio de ganar quien tiene la mayor suma de puntajes de vida
    public static void quien_gana(HashMap<Integer, Soldado> a, HashMap<Integer,Soldado> b) {
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
