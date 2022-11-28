/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio12;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author asus
 */

public class VideoJuego9 {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

	//Creación de los Ejércitos
	static HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
	static HashMap<Integer, Soldado> ejercito2 = new HashMap<>();
        public static Soldado[][] tablero;

    public static void VideoJuego9 () {
        
        //Manera Iterativa, preguntat si quiere realizar juego, solo sucede cuando se esscriba Y
        
        String rpta;
        boolean continua = true, turno = true;
        while (true) {
            System.out.println("Desea simular un juego de Soldados en Guerra? y/n");
            rpta = sc.next();
            if (rpta.equals("n")) {
                break;
            }
                
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
            System.out.println("EJERCITO 1: ");
            ordenarPorPuntosBurbuja(ejercito1);
            mostrar_Hasmap(ejercito1);
            System.out.println("\nOrdenmiento Por Puntos de Inserción");
            System.out.println("EJERCITO 2: ");
            ordenarPorPuntosInsercion(ejercito2);
            mostrar_Hasmap(ejercito2);
             
            //Continuación con Juego y Movimiento
            while (continua(tablero)) {
                System.out.println();
			mostrar_tabla(tablero);
			mover_en_tablero(tablero, turno);
			turno = !turno;
            }
        }
        
        System.out.println("");
    }
    
    public static void GenerarSoldados(){
        int num_ejercito1, num_ejercito2;
        boolean look;
        //Creación del Tablero
            tablero = new Soldado[10][10];
            
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
            look = r.nextBoolean();
            if (look) {
                llenar_tabla(ejercito1, tablero);
                llenar_tabla(ejercito2, tablero);

            } else {
                llenar_tabla(ejercito2, tablero);
                llenar_tabla(ejercito1, tablero);
            }
            
            mostrar_tabla(tablero);
    }
    
    //Ganador Final
    public static boolean continua(Soldado[][] a) {
		String ultima_cara;
		int contador_de_soldados_ej1 = 0;
		int contador_de_soldados_ej2 = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != null) {
					ultima_cara = ultima_letra(a[i][j]);
					if (ultima_cara.equals("1")) {
						contador_de_soldados_ej1++;
					}
				}
			}
		}
		if (contador_de_soldados_ej1 == 0) {
			System.out.println("GANA EL EJERCITO 2!!");
                        System.out.println("FIN DEL JUEGO");
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != null) {
					ultima_cara = ultima_letra(a[i][j]);
					if (ultima_cara.equals("2")) {
						contador_de_soldados_ej2++;
					}
				}
			}
		}
		if (contador_de_soldados_ej2 == 0) {
			System.out.println("GANA EL EJERCITO 1");
                        System.out.println("FIN DEL JUEGO");
			return false;
		}
		return true;
	}
    
    public static void mover_en_tablero(Soldado[][] a, boolean turn) { // turn== true, le toca al ejercito 1
        int fila, columna, direccion_mov = 0;
	Soldado soldado_origen = new Soldado();
	Soldado soldado_destino = new Soldado();
	boolean no_se_mueve = true; //Impedimiento salida de matriz
        System.out.println("\nBIENVENIDO AL JUEGO: ");
	if (turn) {
            System.out.println("Turno del jugador 1");
            System.out.println("Equipo ROJO");
            System.out.println("Ingrese el soldado que desea mover, (Coordenad (columna, fila))");
            columna = sc.nextInt();
            fila = sc.nextInt();
            while (a[fila][columna] == null || !ultima_letra(a[fila][columna]).equals("1")) {
                System.out.println(a[fila][columna]);
                System.out.println("No existe soldado en esa posición o el soldado no pertence al  ejercito 1!");
                System.out.println("Ingresa coordenada nuevamente: ");
                fila = sc.nextInt();
                columna = sc.nextInt();
            }
        } else {
            System.out.println("\nTurno del jugador 2");
            System.out.println("Equipo VERDE");
            System.out.println("Ingrese el soldado que desea mover, (Coordenad (columna, fila))");
            columna = sc.nextInt();
            fila = sc.nextInt();
            while (a[fila][columna] == null || !ultima_letra(a[fila][columna]).equals("2")) {
                System.out.println("No existe soldado en esa posición o el soldado no pertence al  ejercito 2!");
                System.out.println("Ingresa coordenada nuevamente: ");
                fila = sc.nextInt();
                columna = sc.nextInt();
            }
        }
        System.out.println("Se selecciono al soldado: " + a[fila][columna]);
	//Validamos que el movimiento no se salga de la matriz con try y catch
        do {
            try{
                //Obtenemos los indices de destino en un ArrayList
                System.out.println("\t LISTA DE MOVIMIENTOS: ");
                System.out.println("\t 1. Arriba" +
                                   "\t 2. Abajo" + 
                                   "\t 3. Izquierda" + 
                                   "\t 4. Derecha" + 
                                   "\t 5. Mantener Posicion");
                System.out.println("OJO: El moviento es de 1 en 1");
                System.out.println("Ingrese un numero para su movimiento: ");
		direccion_mov = sc.nextInt();
		ArrayList<Integer> lista_indices_destino = new ArrayList<>();
		lista_indices_destino = origen_destino(fila, columna, direccion_mov);
		soldado_origen = a[fila][columna];
                soldado_destino = a[lista_indices_destino.get(0)][lista_indices_destino.get(1)];
		System.out.println(soldado_origen + " se mueve a " + lista_indices_destino);
		if(direccion_mov != 5){
                    if (soldado_destino != null && !ultima_letra(soldado_origen).equals(ultima_letra(soldado_destino))) {
                        System.out.println("***Batalla entre " + soldado_origen + " vs " + soldado_destino + "***\n");
                        a[lista_indices_destino.get(0)][lista_indices_destino.get(1)] = batallametr(soldado_origen, soldado_destino);
                        a[fila][columna] = null;
                        no_se_mueve = false;
                    } else if (soldado_destino != null && ultima_letra(soldado_origen).equals(ultima_letra(soldado_destino))) {
                        System.out.println("No se puede mover ahi, porque tiene un soldado aliado en esa posicion!!");
			System.out.println("Ingrese nuevamente un número para su movimiento: ");
                        direccion_mov = sc.nextInt();
                        lista_indices_destino = origen_destino(fila, columna, direccion_mov);
                        soldado_destino = a[lista_indices_destino.get(0)][lista_indices_destino.get(1)];
                    } else {
                        movimiento(a[fila][columna].getNombre(),fila, columna, lista_indices_destino, a);
			no_se_mueve = false;
                    }
                } else
                    no_se_mueve = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Movimiento fuera de la matriz, intente de nuevo");
                System.out.println(e);
                no_se_mueve = true;
            }		
        } while (no_se_mueve);
    }

    public static void movimiento(String nombre, int i, int j, ArrayList<Integer> des , Soldado[][] a) {
        a[des.get(0)][des.get(1)] = a[i][j];
        a[i][j] = null;
    }
	
    public static ArrayList<Integer> origen_destino(int i, int j, int direccion_mv) {
        int destinoi = 0, destinoj = 0;
        ArrayList<Integer> indices_destino = new ArrayList<>();
	switch (direccion_mv) {
            //Arriba
            case 1: 
                destinoi = i - 1;
		destinoj = j;
		break;
            // Abajo
            case 2:		
		destinoi = i + 1;
		destinoj = j;
                break;
            // Izquierda
            case 3:
                destinoi = i;
		destinoj = j - 1;
		break;                        
            //Derecha        
            case 4:
		destinoi = i;
		destinoj = j + 1;
                break;
            //Mantener Posición    
            case 5:
		destinoi = i;
		destinoj = j;
		break;
                
            default:
                destinoi = i;
                destinoj = j;;
		break;
	}
	indices_destino.add(destinoi);
	indices_destino.add(destinoj);
	return indices_destino;
    }
    
    public static Soldado batallametr(Soldado a, Soldado b) {
        int total = a.getVidaActual() + b.getVidaActual();
        double p1, p2;
        p1 = a.getVidaActual();
        p2 = b.getVidaActual(); 
        
        if (p1 > p2) {
            System.out.println("Ganador, SoldadoX: " + "PV: " + p1);
            System.out.println("Probabilidad Ganar S1: " + (p1*100/total) + " %");
            System.out.println("Probabilidad Ganar S2: " + (p2*100/total) + " %");
            a.setVidaActual(a.getVidaActual()+1);
            return a;
        } else {
            System.out.println("Ganador, SoldadoY: " + "PV: " + p2);
            System.out.println("Probabilidad Ganar S2: " + (p2*100/total) + " %");
            System.out.println("Probabilidad Ganar S1: " + (p1*100/total) + " %");
            b.setVidaActual(b.getVidaActual()+1);
            return b;
	}
    }
        
    //Generación de los soldados
    public static void generar_HasMap(HashMap<Integer, Soldado> a, int cantidad, String equipo) {
        String nombre;
        int puntos_vida,ataque,defensa;
        if(a.size()<cantidad)
            for (int i = a.size(); i < cantidad; i++) {
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
        else
            for (int i = a.size(); i > cantidad; i--)
            a.remove(i-1);
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
		for (int i = 0; i < a.length; i++)
			System.out.print("\t|"+i+"|");

        for (int i = 0; i < a.length; i++) {
			System.out.println();
			System.out.print("  |"+i+"|");
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
			System.out.println();
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
    
}
     


                
    