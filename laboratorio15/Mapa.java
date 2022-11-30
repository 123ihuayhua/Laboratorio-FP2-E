/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio15;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author asus
 */
public class Mapa {
    static Random r = new Random();
    private int fila;
    private int columna;
    private Ejercito[][] tablero;
    private String terreno;
    
    public static void territorio(){
    ArrayList<String> territorio = new ArrayList<String>();
        territorio.add("Campo abierto");
    }
    
    public Mapa(int a, int b, String terreno) {
        fila = a;
        columna = b;
        tablero = new Ejercito[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                tablero[i][j] = null;
            }
	}
	this.terreno = terreno;
    }
    
    public String getTerreno() {
	return terreno;
    }
    
    public void setTerreno(String terreno) {
	this.terreno = terreno;
    }
	
    public void generaTerreRandom(ArrayList<String> a) {
        int aleatorio = r.nextInt(a.size());
	this.setTerreno(a.get(aleatorio));
    }
    
    public void mostrar() {
	for (int i = 0; i < tablero.length; i++)
            System.out.print("\t|"+i+"|");
        for (int i = 0; i < tablero.length; i++) {   
            System.out.println();
            System.out.print(" |"+i+"|");
        for (int j = 0; j < tablero[i].length; j++) {
		if (tablero[i][j] == null) {
                    System.out.print("\t_ ");
		} else {
                    System.out.print("\t" + tablero[i][j].getReino().substring(0, 1) + tablero[i][j].getNum_soldados());
		}    
            }
            System.out.println();    
	}
    }
	
    public void llenartablero(Ejercito a) {
        int filat, columnat, i = 0;
        do {
            filat = r.nextInt(Ejercito.MAX);
            columnat = r.nextInt(Ejercito.MAX);
        } while (tablero[filat][columnat] != null);
        tablero[filat][columnat] = a;
        i++;
    }
    
    public Ejercito[][] getTablero() {
	return tablero;
    }
	
    public Ejercito getEjercito(int fila, int columna) {
	Ejercito ejercitoobtenido = new Ejercito();
	ejercitoobtenido = this.tablero[fila][columna];
	return ejercitoobtenido;
    }
	
    public void setEjercito(int fila, int columna, Ejercito a) {
        this.tablero[fila][columna] = a;
    }
    
    public void setTablero(Ejercito[][] tablero) {
	this.tablero = tablero;
    }
}
