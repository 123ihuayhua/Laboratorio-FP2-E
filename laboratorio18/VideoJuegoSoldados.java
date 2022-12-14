     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio18;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class VideoJuegoSoldados {
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);
    //VideoJuego Soldados
    public static boolean VideoJuegoSold(ArrayList<Soldado> a, ArrayList<Soldado> b){
        boolean turn;
        turn = r.nextBoolean();
        //Creacion de Territorio
        ArrayList<String> territorio = new ArrayList<String>();
	territorio.add("Campo abierto");
        //Variables para eleccion territorio
        String territoriElegido;
        int indiceRandomTerritorio;
        //Territorio Aleatorio
	indiceRandomTerritorio = r.nextInt(territorio.size());
	territoriElegido = territorio.get(indiceRandomTerritorio);
        Mapa_Soldados map1 = new Mapa_Soldados(10, 10, territoriElegido);
        //Llenado de tableros con soldados de ejercitos que entraron en conflicto
        llenadoiterativo(map1, a);
	llenadoiterativo(map1, b);
	map1.mostrar();
        //Verificacion Soldados (Falta cambiar nombre al metodo de referencia)
	while (!verificaSoldadossvacios(a, b)) {
            System.out.println("\t\n PARTIDA POR 3 METRICAS");
            System.out.println("\t-> BATALLA NORMAL (TURNOS) <-");
            mover_en_tableroE(a, b, map1,turn);
            map1.mostrar();
            turn = !turn;                          
        }
        if (a.isEmpty()) {
            return false;
        }
        return true;
    }
    
    //Movimiento en el tablero para los soldados
    public static void mover_en_tableroE(ArrayList<Soldado> a, ArrayList<Soldado> b, Mapa_Soldados c, boolean turn) {
    // si turn== true, le toca al soldado 1
        int fila, columna, direccion_mov = 0, filas, columnas,direccion_movs = 0;
	Soldado soldado_origen = new Soldado();
	Soldado soldado_destino = new Soldado();
	// guardaremos al soldado
	boolean no_se_mueve = true; //con esoto validamos que no se salga de la matriz el movimiento
	//Valido de forma conjunta que el soldado elegido no este vacio y valido el turno
	if (turn) {
            System.out.println("\t\nTurno del jugador: " + a.get(0).getReino());
            System.out.println("\tIngrese el soldado que desea mover: (Fila, Columna)");
            fila = sc.nextInt();
            columna = sc.nextInt();
            while (c.getSoldado(fila, columna) == null || !c.getSoldado(fila, columna).getReino().equals(a.get(0).getReino())) {
            System.out.println("\tNo existe soldado en esa coordenada o el soldado no pertence a su Reino");
            System.out.println("\tIngrese nuevamente coordena: ");
            fila = sc.nextInt();
            columna = sc.nextInt();
            }
        } else {
            System.out.println("\t\nTurno del jugador: " + b.get(0).getReino());
            System.out.println("\tIngrese el soldado que desea mover: (Fila, Columna)");
            fila = sc.nextInt();
            columna = sc.nextInt();
            while (c.getSoldado(fila, columna) == null || !c.getSoldado(fila, columna).getReino().equals(b.get(0).getReino())) {
                System.out.println("\tNo existe soldado en esa coordenada o el soldado no pertence a su Reino");
                System.out.println("\tIngrese nuevamente coordena: ");
                fila = sc.nextInt();
		columna = sc.nextInt();
            }
	}
	System.out.println("\tSe selecciono el soldado: " + c.getSoldado(fila, columna));
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
            //Indices de Movimiento
            ArrayList<Integer> lista_indices_destino = new ArrayList<>();
            lista_indices_destino = vector_direccion(fila, columna, direccion_mov);
            soldado_origen = c.getSoldado(fila, columna);
            soldado_destino =	c.getSoldado(lista_indices_destino.get(0),lista_indices_destino.get(1));
            System.out.println(soldado_origen + " se mueve a " + lista_indices_destino);
            System.out.println(" a la casilla donde desea moverse esta " + soldado_destino);
            if (soldado_destino != null && !soldado_origen.getReino().equals(soldado_destino.getReino())) {
            System.out.println("~~~~***BATALLA***~~~~ \n" + soldado_origen + "\n\t\t vs \n" + soldado_destino + "***~~~~\n");
            System.out.println("\tMETRICA 1: ");
            System.out.println("\t->Ganador respecto a la probabilidad del NIVEL DE VIDA <-");
            Soldado soldado_ganador = batallametr1(soldado_origen, soldado_destino);
            System.out.println("\tMETRICA 2");
            System.out.println("\t->Ganador respecto a la probabilidad del NIVEL DE ATAQUE <-");
            Soldado soldado_ganador1 = batallametr2(soldado_origen, soldado_destino);
            System.out.println("\tMETRICA 3");
            System.out.println("\t->Ganador respecto a la probabilidad del NIVEL DE VIDA Y NIVEL DE ATAQUE<-");
            Soldado soldado_ganador2 = batallametr3(soldado_origen, soldado_destino);
            System.out.println("");
            //Definiendo ganador por mayor cantidad de m??tricas
                if ((soldado_ganador == soldado_ganador1)) {
                    c.setSoldado(lista_indices_destino.get(0), lista_indices_destino.get(1), soldado_ganador);
                    System.out.println("\tGANADOR EN 2 METRICAS o + -> " + soldado_ganador.getReino());
                } else if (soldado_ganador == soldado_ganador2) {
                    c.setSoldado(lista_indices_destino.get(0), lista_indices_destino.get(1), soldado_ganador);
                    System.out.println("\tGANADOR EN 2 METRICAS o + -> " + soldado_ganador.getReino());
                } else if (soldado_ganador1 == soldado_ganador2) {
                    c.setSoldado(lista_indices_destino.get(0), lista_indices_destino.get(1), soldado_ganador1);
                    System.out.println("\tGANADOR EN 2 METRICAS o + -> " + soldado_ganador1.getReino());
                }else{
                    c.setSoldado(lista_indices_destino.get(0), lista_indices_destino.get(1), soldado_ganador1);
                    System.out.println("\tGANADOR EN 2 METRICAS o + -> " + soldado_ganador1.getReino());
                } 
 
            if (turn) {
                //EjercitoA 
                if (c.getSoldado(lista_indices_destino.get(0),lista_indices_destino.get(1)).getReino().equals(a.get(0).getReino())) {
                    b.remove(busqueda_lineal(b,soldado_destino.getNombre()));
		}else if(c.getSoldado(lista_indices_destino.get(0), lista_indices_destino.get(1)).getReino().equals(b.get(0).getReino())) {
                    a.remove(busqueda_lineal(a, soldado_origen.getNombre()));
		}
            } else { //Ejercito b
                if (c.getSoldado(lista_indices_destino.get(0), lista_indices_destino.get(1)).getReino().equals(a.get(0).getReino())) {
                    b.remove(busqueda_lineal(b, soldado_origen.getNombre()));
		} else if (c.getSoldado(lista_indices_destino.get(0), lista_indices_destino.get(1)).getReino().equals(b.get(0).getReino())) {
                    a.remove(busqueda_lineal(a, soldado_destino.getNombre()));
                }
            }
            c.setSoldado(fila, columna, null);
            System.out.println(a);
            System.out.println(b);
            no_se_mueve = false;
            } else if (soldado_destino != null && soldado_origen.getReino().equals(soldado_destino.getReino())) {
		System.out.println("\tMovimiento invalido, existe un ejercito aliado en esa posicion");
                System.out.println("\t Ingrese nuevamente un movimiento: ");
		direccion_mov = sc.nextInt();
		lista_indices_destino = vector_direccion(fila,columna, direccion_mov);
		soldado_destino = c.getSoldado(lista_indices_destino.get(0),lista_indices_destino.get(1));
            } else {
		c.setSoldado(lista_indices_destino.get(0),lista_indices_destino.get(1), soldado_origen);
		c.setSoldado(fila, columna, null);
		no_se_mueve = false;
            }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\tMovimiento fuera de la matriz, intente de nuevo: ");
		System.out.println(e);
		no_se_mueve = true;
            }
        } while (no_se_mueve);
    }
    
    //Busqieda Lineal
    public static int busqueda_lineal(ArrayList<Soldado> a, String buscar) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getNombre().contains(buscar)) {
                return i;
            }
	}
	return -1;
    }
    
    //Metrica de Victoria -> probabilidad 
    public static Soldado batallametr1(Soldado a, Soldado b) {
        int total = a.getNivelVida()+ b.getNivelVida();
        double p1, p2;
	p1 = a.getNivelVida() * 1.0 / total;
	p2 = b.getNivelVida() * 1.0 / total;
	System.out.println("" + a.getNombre()+ " tiene probabilidad " + p1);
        System.out.println("" + b.getNombre() + " tiene probabilidad " + p2);
	double aleatorio = r.nextDouble();
        if (aleatorio >= p1) {
            System.out.println("El aleatorio fue " + aleatorio + " , por lo tanto " + "" + "gana el soldado de " + b.getReino());
            return b;
	} else {
            System.out.println("El aleatorio fue " + aleatorio + " , por lo tanto "+ "" + "gana el soldado de" + a.getReino());
            return a;
        }
    }
    
    public static Soldado batallametr2(Soldado a, Soldado b){
        int total = a.getNivelAtaque()+ b.getNivelAtaque();
        double p1, p2;
	p1 = a.getNivelAtaque() * 1.0 / total;
	p2 = b.getNivelAtaque() * 1.0 / total;
	System.out.println("" + a.getNombre() + " tiene probabilidad " + p1);
        System.out.println("" + b.getNombre() + " tiene probabilidad " + p2);
	double aleatorio = r.nextDouble();
        if (aleatorio >= p1) {
            System.out.println("El aleatorio fue " + aleatorio + " , por lo tanto " + "" + "gana el soldado de " + b.getReino());
            return b;
	} else {
            System.out.println("El aleatorio fue " + aleatorio + " , por lo tanto "+ "" + "gana el soldado de " + a.getReino());
            return a;
        }
    }
    
    public static Soldado batallametr3(Soldado a, Soldado b){
        int total = a.getNivelVida()+ a.getNivelAtaque()+b.getNivelVida()+b.getNivelAtaque();
        double p1, p2;
	p1 = a.getNivelVida() + a.getNivelAtaque() * 1.0 / total;
	p2 = b.getNivelVida() + b.getNivelAtaque() * 1.0 / total;
	System.out.println("" + a.getNombre()+ " tiene probabilidad " + p1);
        System.out.println("" + b.getNombre() + " tiene probabilidad " + p2);
	double aleatorio = r.nextDouble();
        if (aleatorio >= p1) {
            System.out.println("El aleatorio fue " + aleatorio + " , por lo tanto " + "" + "gana el soldado de " + b.getReino());
            return b;
	} else {
            System.out.println("El aleatorio fue " + aleatorio + " , por lo tanto "+ "" + "gana el soldado de " + a.getReino());
            return a;
        }
    }
    
    public static boolean verificaSoldadossvacios(ArrayList<Soldado> a,ArrayList<Soldado> b) {
        if (a.isEmpty() || b.isEmpty()) {
            return true;
	}
	return false;
    }
    
    //Lista de Movimientos
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
            //Mantener Posici??n    
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
    
    //Llenado tablero
    public static void llenadoiterativo(Mapa_Soldados a, ArrayList<Soldado> b) {
	for (int i = 0; i < b.size(); i++) {
            a.llenartablero(b.get(i));
	}
    } 
    
}
