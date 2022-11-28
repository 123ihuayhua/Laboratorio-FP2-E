/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio14.pkg1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class VideoJuego {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    
    //Metodo para VideoJuego 1 -> Juego Rapido
    public static void VideoJuego1(){
        //Creacion ArrayList almacenar un Territorio
        ArrayList<String> territorio = new ArrayList<String>();
	territorio.add("Campo abierto");
        //Creacion ArrayList almacenar Reinos
	ArrayList<String> reinos = new ArrayList<String>();
	reinos.add("INGLATERRA");
	reinos.add("FRANCIA");
	reinos.add("CASTILLA - ARAGON");
	reinos.add("MOROS");
	reinos.add("SACRO IMPERIO ROMANO");
        //Varibales de Indice 
	int indiceRandomReino;
	int indiceRandomTerritorio;
        String territoriElegido, reinoElegido1, reinoElegiod2;
        //Aleatorio para obtener un reino y territorio
	indiceRandomTerritorio = r.nextInt(territorio.size());
	indiceRandomReino = r.nextInt(reinos.size());
        //Se extrae territorio
	territoriElegido = territorio.get(indiceRandomTerritorio);
        Mapa map1 = new Mapa(10, 10, territoriElegido);
        //Jugador 1 (aleatorio)
        System.out.println("\t\nELECCION ALEATORIA DE REINO - JUGADOR 1\n");
        ArrayList<Ejercito> lista_ejercito1 = new ArrayList<Ejercito>();
	reinoElegido1 = reinos.get(indiceRandomReino);
	lista_ejercito1 = generarEjercitos(reinoElegido1);
	indiceRandomReino = r.nextInt(reinos.size());
	System.out.println(lista_ejercito1);
        //Jugador 2 (aleatorio)
        System.out.println("\t\nELECCION ALEATORIA DE REINO - JUGADOR 2\n");
        reinoElegiod2 = reinos.get(indiceRandomReino);
	ArrayList<Ejercito> lista_ejercito2 = new ArrayList<Ejercito>();
	lista_ejercito2 = generarEjercitos(reinoElegiod2);
	System.out.println(lista_ejercito2);
        //Llenado de Ejercitos
        llenadoiterativo(map1, lista_ejercito1);
	llenadoiterativo(map1, lista_ejercito2);
	map1.mostrar();
        //Verificacion de Ejercitos Vacios
	while (!verificaEjercitosvacios(lista_ejercito1, lista_ejercito2)) {
            break;
        }
        //Metrica Ganador -> Mayor Cantidad de Ejercitos
        metricaNumEjercitos(lista_ejercito1, lista_ejercito2);
    }
    
    //Metodo para VideoJuego 1 -> Juego Rapido
    public static void VideoJuego2(){
        boolean turn;
        turn = r.nextBoolean();
        //ArrayList para almacenar territorio
        ArrayList<String> territorio = new ArrayList<String>();
	territorio.add("Campo abierto");
        //ArrayList almacenar Reinos
	ArrayList<String> reinos = new ArrayList<String>();
	reinos.add("INGLATERRA");
	reinos.add("FRANCIA");
	reinos.add("CASTILLA - ARAGON");
	reinos.add("MOROS");
	reinos.add("SACRO IMPERIO ROMANO");
        //Indices 
	int indiceRandomReino;
	int indiceRandomTerritorio;
        String territoriElegido, reinoElegido1, reinoElegiod2;
        //Aleatoriedad para obtener un reino y territorio
	indiceRandomTerritorio = r.nextInt(territorio.size());
	indiceRandomReino = r.nextInt(reinos.size());
        //Territorio escogido
	territoriElegido = territorio.get(indiceRandomTerritorio);
        Mapa map1 = new Mapa(10, 10, territoriElegido);
        //Jugador 1 -> aleatorio
        System.out.println("\t\nELECCION ALEATORIA DE REINO - JUGADOR 1\n");
        ArrayList<Ejercito> lista_ejercito1 = new ArrayList<Ejercito>();
	reinoElegido1 = reinos.get(indiceRandomReino);
	lista_ejercito1 = generarEjercitos(reinoElegido1);
	indiceRandomReino = r.nextInt(reinos.size());
	System.out.println(reinoElegido1);
        //Jugador 2 -> aleatorio
        System.out.println("\t\nELECCION ALEATORIA DE REINO - JUGADOR 2\n");
        reinoElegiod2 = reinos.get(indiceRandomReino);
	ArrayList<Ejercito> lista_ejercito2 = new ArrayList<Ejercito>();
	lista_ejercito2 = generarEjercitos(reinoElegiod2);
	System.out.println(reinoElegiod2);
        //LLenado de Ejercitos
        llenadoiterativo(map1, lista_ejercito1);
	llenadoiterativo(map1, lista_ejercito2);
	map1.mostrar();
        //Verificacion de Ejercitos 
	while (!verificaEjercitosvacios(lista_ejercito1, lista_ejercito2)) {
            //Movimiento
            mover_en_tableroE(lista_ejercito1, lista_ejercito2, map1,turn);
            map1.mostrar();
            turn = !turn;
        }
    }

    //Metodo para el movimiento
    public static void mover_en_tableroE(ArrayList<Ejercito> a, ArrayList<Ejercito> b, Mapa c, boolean turn) {
        // si turn == true, le toca al ejercito 1
        int fila, columna, direccion_mov = 0, filas, columnas,direccion_movs = 0;
	Ejercito ejercito_origen = new Ejercito();
	Ejercito ejercito_destino = new Ejercito();
	// guardaremos al soldado
	boolean no_se_mueve = true; //con esoto validamos que no se salga de la matriz el movimiento
	//Valido de forma conjunta que el soldado elegido no este vacio y valido el turno
	if (turn) {
            System.out.println("\t\nTurno del jugador: " + a.get(0).getReino());
            System.out.println("\tIngrese el ejercito que desea mover: (Fila, Columna)");
            fila = sc.nextInt();
            columna = sc.nextInt();
            while (c.getEjercito(fila, columna) == null || !c.getEjercito(fila, columna).getReino().equals(a.get(0).getReino())) {
            System.out.println("\tNo existe ejercito en esa coordenada o el ejercito no pertence a su Reino");
            System.out.println("\tIngrese nuevamente coordena: ");
            fila = sc.nextInt();
            columna = sc.nextInt();
            }
        } else {
            System.out.println("\t\nTurno del jugador: " + b.get(0).getReino());
            System.out.println("\tIngrese el ejercito que desea mover: (Fila, Columna)");
            fila = sc.nextInt();
            columna = sc.nextInt();
            while (c.getEjercito(fila, columna) == null || !c.getEjercito(fila, columna).getReino().equals(b.get(0).getReino())) {
                System.out.println("\tNo existe ejercito en esa coordenada o el ejercito no pertence a su Reino");
                System.out.println("\tIngrese nuevamente coordena: ");
                fila = sc.nextInt();
		columna = sc.nextInt();
            }
	}
	System.out.println("\tSe selecciono el ejercito: " + c.getEjercito(fila, columna));
	//validamos que el movimiento no se salga de la matriz con try y catch
	do {
            try {
            //obetengo los indices de destino en un ArrayList
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
            lista_indices_destino = vector_direccion(fila, columna, direccion_mov);
            //Posicion inicial
            ejercito_origen = c.getEjercito(fila, columna);
            //Posicion final
            ejercito_destino =	c.getEjercito(lista_indices_destino.get(0),lista_indices_destino.get(1));
            System.out.println(ejercito_origen + " se mueve a " + lista_indices_destino);
            System.out.println(" a la casilla donde desea moverse esta " + ejercito_destino);
            if (ejercito_destino != null && !ejercito_origen.getReino().equals(ejercito_destino.getReino())){
            System.out.println("~~~~***BATALLA***~~~~ \n" + ejercito_origen + "\n\t\t\t\t\t vs \n" + ejercito_destino + "***~~~~\n");
            Ejercito ejercito_ganador = batallametr(ejercito_origen, ejercito_destino);
            c.setEjercito(lista_indices_destino.get(0),
            lista_indices_destino.get(1), ejercito_ganador);
            System.out.println("Ganador ==== " + ejercito_ganador);
            /*De acuerdo a un ganador, habra perdedor que pasará a ser eliminado desde sus soldados 
              Se hara uso de una busqueda lineal para mayor facilidad*/
            if (turn) {
                //Para Ejercito 
                if (c.getEjercito(lista_indices_destino.get(0),lista_indices_destino.get(1)).getReino().equals(a.get(0).getReino())) {
                    b.get(busqueda_lineal(b,ejercito_destino.getNombre_ejercito())).eliminarsusSoldados();
                    b.remove(busqueda_lineal(b,ejercito_destino.getNombre_ejercito()));
		} else if(c.getEjercito(lista_indices_destino.get(0), lista_indices_destino.get(1)).getReino().equals(b.get(0).getReino())) {
                    b.get(busqueda_lineal(a, ejercito_origen.getNombre_ejercito())).eliminarsusSoldados();
                    a.remove(busqueda_lineal(a, ejercito_origen.getNombre_ejercito()));
		}
                //Para Ejercito
            } else {
                if (c.getEjercito(lista_indices_destino.get(0), lista_indices_destino.get(1)).getReino().equals(a.get(0).getReino())) {
                    b.get(busqueda_lineal(b, ejercito_origen.getNombre_ejercito())).eliminarsusSoldados();
                    b.remove(busqueda_lineal(b, ejercito_origen.getNombre_ejercito()));
		} else if (c.getEjercito(lista_indices_destino.get(0), lista_indices_destino.get(1)).getReino().equals(b.get(0).getReino())) {
                    a.get(busqueda_lineal(a,ejercito_destino.getNombre_ejercito())).eliminarsusSoldados();
                    a.remove(busqueda_lineal(a, ejercito_destino.getNombre_ejercito()));
                }
            }
            c.setEjercito(fila, columna, null);
            System.out.println(a);
            System.out.println(b);
            no_se_mueve = false;
            } else if (ejercito_destino != null && ejercito_origen.getReino().equals(ejercito_destino.getReino())) {
		System.out.println("\tMovimiento invalido, existe un ejercito aliado en esa posicion");
                System.out.println("\t Ingrese nuevamente un movimiento: ");
		direccion_mov = sc.nextInt();
		lista_indices_destino = vector_direccion(fila,columna, direccion_mov);
		ejercito_destino = c.getEjercito(lista_indices_destino.get(0),lista_indices_destino.get(1));
            } else {
		c.setEjercito(lista_indices_destino.get(0),lista_indices_destino.get(1), ejercito_origen);
		c.setEjercito(fila, columna, null);
		no_se_mueve = false;
            }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\tMovimiento fuera de la matriz, intente de nuevo: ");
		System.out.println(e);
		no_se_mueve = true;
            }
        } while (no_se_mueve);
    }
    
    //Metodo busqueda lineal, para eliminar ejercitos
    public static int busqueda_lineal(ArrayList<Ejercito> a, String buscar) {
        for (int i = 0; i < a.size(); i++) {
            if (buscar.equals(a.get(i).getNombre_ejercito())) {
                return i;
            }
	}
	return -1;
    }
    
    //Metodo donde aparacera lucha por soldados una vez choquen 2 ejercitos
    public static Ejercito batallametr(Ejercito a, Ejercito b) {
        if(VideoJuegoSoldados.VideoJuegoSold(a.misSoldados,b.misSoldados))
            return a;
        return b;
    }
    
    //Verificar Ejercitos
    public static boolean verificaEjercitosvacios(ArrayList<Ejercito> a,ArrayList<Ejercito> b) {
        if (a.isEmpty() || b.isEmpty()) {
            return true;
	}
	return false;
    }
    
    //Movimiento -> Teclado
    public static ArrayList<Integer> vector_direccion(int i, int j, int direccion_mv) {
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
            default: ;
            break;
        }
        indices_destino.add(destinoi);
	indices_destino.add(destinoj);
	return indices_destino;
    }
    
    //Metrica Ganador -> Juego Rapido
    public static void metricaNumEjercitos(ArrayList<Ejercito> a, ArrayList<Ejercito> b) {
        if (a.size() > b.size()) {
            System.out.println("\t\nGANADOR");
            System.out.println("\tREINO: " + a.get(0).getReino());
            System.out.println("\tEJERCITOS: " + a.size());
	} else if (a.size() < b.size()) {
            System.out.println("\t\nGANADOR");
            System.out.println("\tREINO: " + b.get(0).getReino());
            System.out.println("\tEJERCITOS: " + b.size());
		} else {
            System.out.println("\t\nNO HAY GANADOR, ES UN EMPATE!!!");
        }
    }
	
    //Llenar el tablero
    public static void llenadoiterativo(Mapa a, ArrayList<Ejercito> b) {
	for (int i = 0; i < b.size(); i++) {
            a.llenartablero(b.get(i));
	}
    }
    
    //Generar Ejercitos
    public static ArrayList<Ejercito> generarEjercitos(String a) {
        int aleatorio;
	ArrayList<Ejercito> lista_ejercito = new ArrayList<Ejercito>();
	aleatorio = r.nextInt(Ejercito.MAX) + 1;
	for (int i = 1; i < aleatorio; i++) {
            Ejercito ejrcito1 = new Ejercito("Ejercito: " + i," ");
            ejrcito1.generarEjercitoAleatorio(a);
            lista_ejercito.add(ejrcito1);
	}
	return lista_ejercito;
    }
    
}
